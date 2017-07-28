import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { VykazPrace } from '../model/vykaz-prace';
import { VykazPraceService } from '../services/vykaz-prace.service';
import { ToasterService } from 'angular2-toaster';
import { DataConvertor } from '../converts/data-convertor';
import { VykazPraceFilterParameters } from '../model/vykaz-prace-filter-parameters';
import { ApplicationService } from '../services/application.service';
import { ImisKalendarService } from '../services/imis-kalendar.service';
import { ImisDaysFilterParameters } from '../model/imis-days-filter-parameters';
import { ImisDay } from '../model/imis-day';

@Component( {
    selector: 'app-vykaz-prace-edit-form',
    templateUrl: './vykaz-prace-edit-form.component.html',
    styleUrls: ['./vykaz-prace-edit-form.component.css']
} )
export class VykazPraceEditFormComponent implements OnInit {

    vykazPrace: VykazPrace = new VykazPrace();
    vykazPraceDatum: Date;
    vykazPraceMnozstviOdvedenePrace: Date;


    constructor(
        private vykazPraceService: VykazPraceService,
        private toasterService: ToasterService,
        private applicationService: ApplicationService,
        private imisKalendarService: ImisKalendarService ) { }

    ngOnInit() {
    }

    @Input()
    show( vykazPrace: VykazPrace ) {
        if ( vykazPrace == null ) {
            return;
        }

        this.vykazPrace = Object.assign( {}, vykazPrace );
        this.vykazPraceDatum = new Date( this.vykazPrace.datum );
        this.vykazPraceMnozstviOdvedenePrace = DataConvertor.mnozstviHodToDate( this.vykazPrace.mnozstviOdvedenePrace );
    }
    
    mnozstviOdvedenePraceFillDay() {
        let params = new VykazPraceFilterParameters();
        params.fromDate = this.vykazPrace.datum;
        params.toDate = this.vykazPrace.datum;
        params.kodUzivatele = this.applicationService.kodUzivatele;

        this.vykazPraceService.getVykazPraces( params,
            data => {
                let vyks: VykazPrace[] = data;
                let sumVyks = vyks.filter( value => value.id !== this.vykazPrace.id ).map( value => value.mnozstviOdvedenePrace ).reduce(( previousValue, currentValue ) => {
                    return previousValue + currentValue;
                } );

                let params = new ImisDaysFilterParameters();
                params.fromDate = new Date( this.vykazPrace.datum );
                params.toDate = new Date( this.vykazPrace.datum );
                params.kodUzivatele = this.applicationService.kodUzivatele;
                params.unsolvedDaysOnly = false;

                this.imisKalendarService.getImisDays( params, 
                    data => {
                        let days: ImisDay[] = data;

                        var odprac = 0;
                        if ( days && ( days.length > 0 ) ) {
                            odprac = days[0].odpracovanoHod;
                        }

                        if ( odprac - sumVyks < 0 ) {
                            return;
                        }

                        this.vykazPraceMnozstviOdvedenePrace = DataConvertor.mnozstviHodToDate( odprac - sumVyks );
                    }
                );

            }
        );
    }
    
    public getVykazPrace(): VykazPrace {
        this.vykazPrace.datum = this.vykazPraceDatum.getTime();
        this.vykazPrace.mnozstviOdvedenePrace = DataConvertor.toMnozstviHod( this.vykazPraceMnozstviOdvedenePrace );
        return this.vykazPrace;
    }
    

}
