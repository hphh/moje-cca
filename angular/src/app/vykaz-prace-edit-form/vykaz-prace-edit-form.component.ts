import { Component, OnInit, Input, Output, EventEmitter, ViewChild } from '@angular/core';
import { DatePipe } from '@angular/common';
import { VykazPrace } from '../model/vykaz-prace';
import { VykazPraceService } from '../services/vykaz-prace.service';
import { ToasterService } from 'angular2-toaster';
import { DataConvertor } from '../converts/data-convertor';
import { VykazPraceFilterParameters } from '../model/vykaz-prace-filter-parameters';
import { ApplicationService } from '../services/application.service';
import { KalendarService } from '../services/kalendar.service';
import { DensFilterParameters } from '../model/dens-filter-parameters';
import { Den } from '../model/den';
import { ZakazkaFilterParameters } from '../model/zakazka-filter-parameters';
import { Zakazka } from '../model/zakazka';
import { ZakazkaPolozka } from '../model/zakazka-polozka';
import { ZakazkaPozice } from '../model/zakazka-pozice';
import { ZakazkaPozicesFilterParameters } from '../model/zakazka-pozices-filter-parameters';
import { ZakazkaPolozkasFilterParameters } from '../model/zakazka-polozkas-filter-parameters';

@Component( {
    selector: 'app-vykaz-prace-edit-form',
    templateUrl: './vykaz-prace-edit-form.component.html',
    styleUrls: ['./vykaz-prace-edit-form.component.css'],
    providers: [DatePipe]
} )
export class VykazPraceEditFormComponent implements OnInit {

    vykazPrace: VykazPrace = new VykazPrace();
    vykazPraceDatum: Date;
    vykazPraceMnozstviOdvedenePrace: Date;

    zakazkaSuggestions: string[];
    zakazkaSuggestionDatas: Zakazka[];

    zakazkaPolozkaSuggestions: number[];
    zakazkaPolozkaSuggestionDatas: ZakazkaPolozka[];

    zakazkaPoziceSuggestions: number[];
    zakazkaPoziceSuggestionDatas: ZakazkaPozice[];

    fillDayButtonLabel: string = 'Vyplň den';

    constructor(
        private vykazPraceService: VykazPraceService,
        private toasterService: ToasterService,
        public applicationService: ApplicationService,
        private kalendarService: KalendarService,
        private datePipe: DatePipe ) { }

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
        this.refreshFillDayButtonLabel();
    }

    private calculateFillDay( fnc: ( Date ) => void ) {
        let params = new VykazPraceFilterParameters();
        params.fromDate = this.vykazPraceDatum.getTime();
        params.toDate = params.fromDate;
        params.kodUzivatele = this.applicationService.kodUzivatele;

        this.vykazPraceService.getVykazPraces( params,
            data => {
                let vyks: VykazPrace[] = data;
                let sumVyks = vyks.filter( value => value.id !== this.vykazPrace.id ).map( value => value.mnozstviOdvedenePrace ).reduce(( previousValue, currentValue ) => {
                    return previousValue + currentValue;
                } );

                let params = new DensFilterParameters();
                params.fromDate = this.vykazPrace.datum;
                params.toDate = this.vykazPrace.datum;
                params.kodUzivatele = this.applicationService.kodUzivatele;
                params.unsolvedDaysOnly = false;

                this.kalendarService.getImisDays( params,
                    data => {
                        let days: Den[] = data;

                        var odprac = 0;
                        if ( days && ( days.length > 0 ) ) {
                            odprac = days[0].imisDen.odpracovanoHod;
                        }

                        var result = odprac - sumVyks; 
                        if ( result < 0 ) {
                            result = DataConvertor.toMnozstviHod(this.vykazPraceMnozstviOdvedenePrace);
                        }

                        fnc( DataConvertor.mnozstviHodToDate( result ) );
                    }
                );

            }
        );
    }

    mnozstviOdvedenePraceFillDay() {
        this.calculateFillDay( date => this.vykazPraceMnozstviOdvedenePrace = date );
    }

    refreshFillDayButtonLabel() {
        this.calculateFillDay( date => this.fillDayButtonLabel = this.datePipe.transform( date, 'HH:mm' ) );
    }

    public getVykazPrace(): VykazPrace {
        this.vykazPrace.datum = this.vykazPraceDatum.getTime();
        this.vykazPrace.mnozstviOdvedenePrace = DataConvertor.toMnozstviHod( this.vykazPraceMnozstviOdvedenePrace );
        if ( this.vykazPrace.zakazka ) {
            this.vykazPrace.zakazka = this.vykazPrace.zakazka.toUpperCase();
        }
        return this.vykazPrace;
    }

    findZakazkaSuggestions( event ) {
        let query: string = event.query;

        let params = new ZakazkaFilterParameters();
        if ( query ) {
            params.zakazkaPattern = query.toUpperCase() + '%';
        } else {
            params.zakazkaPattern = '%';
        }

        this.vykazPraceService.getZakazkas( params,
            data => {
                this.zakazkaSuggestions = data.map( value => value.zakazka );
                this.zakazkaSuggestionDatas = [];
                data.forEach( value => this.zakazkaSuggestionDatas[value.zakazka] = value );
            }
        );

    }

    onZakazkaDropdownClick() {
        this.findZakazkaSuggestions( { query: this.vykazPrace.zakazka } );
    }


    findZakazkaPolozkaSuggestions( event ) {
        let query: string = event.query;

        let zakazka = this.getVykazPrace().zakazka;
        if ( !zakazka ) {
            this.zakazkaPolozkaSuggestions = [];
            return;
        }

        let params = new ZakazkaPolozkasFilterParameters();
        params.zakazka = zakazka;
        if ( query ) {
            params.polozkaPattern = query + '%';
        }

        this.vykazPraceService.getZakazkaPolozkas( params,
            data => {
                this.zakazkaPolozkaSuggestions = data.map( value => value.polozka );
                this.zakazkaPolozkaSuggestionDatas = [];
                data.forEach( value => this.zakazkaPolozkaSuggestionDatas[value.polozka] = value );
            }
        );

    }

    onZakazkaPolozkaDropdownClick() {
        this.findZakazkaPolozkaSuggestions( { query: this.vykazPrace.polozka } );
    }

    findZakazkaPoziceSuggestions( event ) {
        let query: string = event.query;

        var zakazka = this.vykazPrace.zakazka;
        if ( !zakazka ) {
            this.zakazkaPoziceSuggestions = [];
            return;
        }
        zakazka = zakazka.toUpperCase();

        let polozka = this.vykazPrace.polozka;
        if ( !polozka ) {
            this.zakazkaPoziceSuggestions = []
            return;
        }

        let params = new ZakazkaPozicesFilterParameters();
        params.polozka = polozka;
        params.zakazka = zakazka;
        if ( query ) {
            params.pozicePattern = query + '%';
        }

        this.vykazPraceService.getZakazkaPozices( params,
            data => {
                this.zakazkaPoziceSuggestions = data.map( value => value.pozice );
                this.zakazkaPoziceSuggestionDatas = [];
                data.forEach( value => this.zakazkaPoziceSuggestionDatas[value.pozice] = value );
            }
        );

    }

    onZakazkaPoziceDropdownClick() {
        this.findZakazkaPoziceSuggestions( { query: this.vykazPrace.pozice } );
    }
    
    onDatumSelect() {
        this.refreshFillDayButtonLabel();
    }

}
