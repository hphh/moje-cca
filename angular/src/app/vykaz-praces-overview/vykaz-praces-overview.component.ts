import { Component, OnInit, Input } from '@angular/core';
import { VykazPrace } from '../model/vykaz-prace';
import { VykazPraceService } from '../services/vykaz-prace.service';
import { ToasterService } from 'angular2-toaster';
import { VykazPraceFilterParameters } from '../model/vykaz-prace-filter-parameters';
import { UkolService } from '../services/ukol.service';
import { KrokService } from '../services/krok.service';
import { UkolFilterParameters } from '../model/ukol-filter-parameters';
import { KrokFilterParameters } from '../model/krok-filter-parameters';
import { Ukol } from '../model/ukol';
import { Krok } from '../model/krok';
import { DataConvertor } from '../converts/data-convertor';

@Component( {
    selector: 'app-vykaz-praces-overview',
    templateUrl: './vykaz-praces-overview.component.html',
    styleUrls: ['./vykaz-praces-overview.component.css'],
    providers: [UkolService, KrokService]
} )
export class VykazPracesOverviewComponent implements OnInit {

    params: VykazPraceFilterParameters;

    dialogVisible: boolean = false;
    vykazPraces: VykazPrace[] = [];
    sumVykazano: number = 0;
    pracnostOdhad: number;

    constructor(
        private vykazPraceService: VykazPraceService,
        private ukolService: UkolService,
        private krokService: KrokService,
        private toasterService: ToasterService ) { }

    ngOnInit() {
    }

    private readVykazPraces() {
        if (!this.params) {
            return;
        }
        
        this.vykazPraceService.getVykazPraces( this.params,
            data => {
                this.vykazPraces = data;
                this.sumVykazano = 0;
                this.vykazPraces.forEach( value => {
                    this.sumVykazano += value.mnozstviOdvedenePrace;
                } );
            }
        );

        this.readPracnostOdhad();
    }
    
    private readPracnostOdhad() {
        this.pracnostOdhad = null;
        
        if (this.params.ukol) {
            this.readPracnostUkolu();
        }
        if (this.params.krok) {
            this.readPracnostKroku();
        }
    }

    private readPracnostUkolu() {
        if ( this.params.ukol == null ) {
            return;
        }

        let params = new UkolFilterParameters();
        let cisloRok = DataConvertor.toCisloRok( this.params.ukol );

        if ( cisloRok == null ) {
            return;
        }

        params.cisloUkolu = cisloRok.cislo;
        params.rokUkolu = cisloRok.rok;

        this.ukolService.getUkols( params,
            data => {
                let ukols: Ukol[] = data;
                if ( ( ukols == null ) || ( ukols.length == 0 ) ) {
                    this.pracnostOdhad = 0;
                    console.log( 'nenalezen úkol ' + this.params.ukol );
                    this.toasterService.pop( 'error', 'Nenalezen úkol ' + this.params.ukol, null );
                    return;
                }
                this.pracnostOdhad = ukols[0].pracnostPlan;
            }
        );
    }

    private readPracnostKroku() {
        if ( this.params.krok == null ) {
            return;
        }

        let params = new KrokFilterParameters();
        let cisloRok = DataConvertor.toCisloRok( this.params.krok );

        if ( cisloRok == null ) {
            return;
        }

        params.cisloKroku = cisloRok.cislo;
        params.rokKroku = cisloRok.rok;

        this.krokService.getKroks( params,
            data => {
                let kroks: Krok[] = data;
                if ( ( kroks == null ) || ( kroks.length == 0 ) ) {
                    this.pracnostOdhad = 0;
                    console.log( 'nenalezen krok ' + this.params.krok );
                    this.toasterService.pop( 'error', 'Nenalezen krok ' + this.params.krok, null );
                    return;
                }
                this.pracnostOdhad = kroks[0].pracnostPlan;
            }
        );
    }
    
    @Input()
    show( params: VykazPraceFilterParameters ) {
        this.params = params;
        this.dialogVisible = true;
        this.readVykazPraces();
    }
    
    paramsDecription() {
        if (!this.params) {
            return '';
        }
        
        var result = '';
        if (this.params.ukol) {
            result += 'úkol ' + this.params.ukol;
        }
        if (this.params.krok) {
            result += 'krok ' + this.params.krok;
        }
        if (this.params.hlaseni) {
            result += 'hlášení ' + this.params.hlaseni;
        }
        if (result.length == 0) {
            result += 'něco jiného';
        }
        return 'na ' + result;        
    }

}
