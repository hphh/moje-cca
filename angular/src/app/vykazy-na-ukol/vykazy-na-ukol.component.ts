import { Component, OnInit, Input } from '@angular/core';
import { VykazPrace } from '../model/vykaz-prace';
import { VykazPraceService } from '../services/vykaz-prace.service';
import { ToasterService } from 'angular2-toaster';
import { VykazPraceFilterParameters } from '../model/vykaz-prace-filter-parameters';
import { UkolService } from '../services/ukol.service';
import { UkolFilterParameters } from '../model/ukol-filter-parameters';
import { Ukol } from '../model/ukol';
import { DataConvertor } from '../converts/data-convertor';

@Component( {
    selector: 'app-vykazy-na-ukol',
    templateUrl: './vykazy-na-ukol.component.html',
    styleUrls: ['./vykazy-na-ukol.component.css'],
    providers: [UkolService]
} )
export class VykazyNaUkolComponent implements OnInit {

    ukol: string;
    dialogVisible: boolean = false;
    vykazPraces: VykazPrace[] = [];
    sumVykazano: number = 0;
    pracnostUkolu: number = 0;

    constructor( 
            private vykazPraceService: VykazPraceService, 
            private ukolService: UkolService,
            private toasterService: ToasterService ) { }

    ngOnInit() {
    }

    private readVykazPraces() {
        let params = new VykazPraceFilterParameters();
        params.ukol = this.ukol;
        
        this.vykazPraceService.getVykazPraces( params ).subscribe(
            data => {
                this.vykazPraces = data;
                this.sumVykazano = 0;
                this.vykazPraces.forEach(value => {
                   this.sumVykazano += value.mnozstviOdvedenePrace; 
                });
            },
            err => {
                console.log( 'chyba při čtení dat' );
                console.log( err );
                this.toasterService.pop( 'error', 'Nedaří se načíst data', null );
            }
        );
        
        this.readPracnostUkolu();
    }
    
    private readPracnostUkolu() {
        this.pracnostUkolu = 0;
        
        if (this.ukol == null) {
            return;
        }
        
        let params = new UkolFilterParameters();
        let cisloRok = DataConvertor.toCisloRok(this.ukol);
        
        if (cisloRok == null) {
            return;
        }
        
        params.cisloUkolu = cisloRok.cislo;
        params.rokUkolu = cisloRok.rok;
        
        this.ukolService.getUkols( params ).subscribe(
                data => {
                    let ukols: Ukol[] = data;
                    if ((ukols == null) || (ukols.length == 0)) {
                        this.pracnostUkolu = 0;
                        console.log( 'nenalezen úkol ' + this.ukol );
                        this.toasterService.pop( 'error', 'Nenalezen úkol ' + this.ukol, null );
                        return;
                    } 
                    this.pracnostUkolu = ukols[0].pracnostPlan;
                },
                err => {
                    console.log( 'chyba při čtení úkolu' );
                    console.log( err );
                    this.toasterService.pop( 'error', 'Nedaří se načíst úkol', null );
                }
            );        
    }

    @Input()
    show( ukol: string ) {
        this.ukol = ukol;
        this.dialogVisible = true;
        this.readVykazPraces();
    }

}
