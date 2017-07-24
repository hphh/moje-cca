import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { VykazPraceService } from '../services/vykaz-prace.service';
import { ImisKalendarService } from '../services/imis-kalendar.service';
import { ApplicationService } from '../services/application.service';
import { ToasterService } from 'angular2-toaster';
import { VykazPrace } from '../model/vykaz-prace';
import { Observable, Subscription } from 'rxjs/Rx';
import { MenuItem } from 'primeng/primeng';
import { VykazPraceFilterParameters } from '../model/vykaz-prace-filter-parameters';
import { ImisDay } from '../model/imis-day';
import { ImisDaysFilterParameters } from '../model/imis-days-filter-parameters';



@Component( {
    selector: 'app-employee-vykaz-prace-overview',
    templateUrl: './employee-vykaz-prace-overview.component.html',
    styleUrls: ['./employee-vykaz-prace-overview.component.css'],
    providers: [VykazPraceService, ImisKalendarService]
} )
export class EmployeeVykazPraceOverviewComponent implements OnInit {

    fromDate: Date = new Date();
    toDate: Date = new Date();
    vykazPraces: VykazPrace[] = [];
    readingData: boolean = false;
    imisDays: ImisDay[] = [];
    selectedDay: ImisDay;
    unsolvedDaysOnly: boolean = true;

    kalendarMenuItems: MenuItem[];


    private autoRefreshSubscription: Subscription;

    constructor(
        private vykazPraceService: VykazPraceService,
        private imisKalendarService: ImisKalendarService,
        private toasterService: ToasterService,
        private applicationService: ApplicationService ) {

        this.fromDate = new Date();
        this.fromDate.setDate( this.fromDate.getDate() - 30 );

        this.toDate = new Date();
        this.toDate.setDate( this.toDate.getDate() + 30 );
    }

    ngOnInit() {
        this.kalendarMenuItems = [
            { label: 'Potvrdit výkazy', icon: 'fa-check', command: ( event ) => this.confirmVykazPraces( this.selectedDay ) }
        ];

        this.readImisDays();
        this.refreshAutoRefreshSubscription();
    }

    readImisDays() {
        this.readingData = true;
        this.unsubscribeAutoRefreshSubscription();

        let params = new ImisDaysFilterParameters();
        params.kodUzivatele = this.applicationService.kodUzivatele;
        params.fromDate = this.fromDate;
        params.toDate = this.toDate;
        params.unsolvedDaysOnly = this.unsolvedDaysOnly;

        this.imisKalendarService.getImisDays( params ).subscribe(
            data => {
                this.readingData = false;
                this.refreshAutoRefreshSubscription();
                this.imisDays = data;
                this.readVykazPraces();
            },
            err => {
                this.readingData = false;
                this.refreshAutoRefreshSubscription();
                console.log( 'chyba při čtení imis kalendáře' );
                console.log( err );
                this.toasterService.pop( 'error', 'Nedaří se načíst data', null );
            }
        );
    }

    readVykazPraces() {
        if ( this.selectedDay == null ) {
            this.vykazPraces = [];
            return;
        }

        this.readingData = true;
        this.unsubscribeAutoRefreshSubscription();

        let params = new VykazPraceFilterParameters();
        params.kodUzivatele = this.applicationService.kodUzivatele;
        params.fromDate = this.selectedDay.datum;
        params.toDate = this.selectedDay.datum;

        this.vykazPraceService.getVykazPraces( params ).subscribe(
            data => {
                this.readingData = false;
                this.vykazPraces = data;
                this.refreshAutoRefreshSubscription();
            },
            err => {
                this.readingData = false;
                this.refreshAutoRefreshSubscription();
                console.log( 'chyba při čtení výkazu práce' );
                console.log( err );
                this.toasterService.pop( 'error', 'Nedaří se načíst data', null );
            } )
    }


    celkemOdvedenePrace( date: number ): number {
        var sum = 0;

        this.vykazPraces.forEach( value => {
            if ( value.datum === date ) {
                sum += value.mnozstviOdvedenePrace;
            }
        } );
        return sum;
    }

    private unsubscribeAutoRefreshSubscription() {
        if ( this.autoRefreshSubscription != null ) {
            this.autoRefreshSubscription.unsubscribe();
        }
    }

    private refreshAutoRefreshSubscription() {
        this.unsubscribeAutoRefreshSubscription();
        this.autoRefreshSubscription = Observable.interval( 60000 ).subscribe(() => {
            this.readImisDays()
        } );
    }

    isToday( date: number ): boolean {
        let today = new Date();
        today.setHours( 0, 0, 0, 0 );
        return date === today.getTime();
    }

    onDateSelect( imisDay: ImisDay ) {
        this.readVykazPraces();
    }

    private confirmVykazPraces( imisDay: ImisDay ) {
        this.vykazPraceService.confirmVykazPraces( imisDay.datum, imisDay.datum ).subscribe(
            data => {
                this.readImisDays();
            },
            err => {
                console.log( 'chyba při potvrzování výkazu práce' );
                console.log( err );
                this.toasterService.pop( 'error', 'Nedaří se potvrdit výkazy práce', null );
            } )
    }

}
