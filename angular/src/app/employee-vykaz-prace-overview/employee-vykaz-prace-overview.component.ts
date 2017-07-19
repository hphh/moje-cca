import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { VykazPraceService } from '../services/vykaz-prace.service';
import { ApplicationService } from '../services/application.service';
import { ToasterService } from 'angular2-toaster';
import { VykazPrace } from '../model/vykaz-prace';
import { Observable, Subscription } from 'rxjs/Rx';
import { MenuItem } from 'primeng/primeng';

@Component( {
    selector: 'app-employee-vykaz-prace-overview',
    templateUrl: './employee-vykaz-prace-overview.component.html',
    styleUrls: ['./employee-vykaz-prace-overview.component.css'],
    providers: [VykazPraceService]
} )
export class EmployeeVykazPraceOverviewComponent implements OnInit {

    fromDate: Date = new Date();
    toDate: Date = new Date();
    vykazPraces: VykazPrace[] = [];
    readingVykazPraces: boolean = false;
    vykazMenuItems: MenuItem[];
    selectedVykazPrace: VykazPrace;

    private autoRefreshSubscription: Subscription;

    @ViewChild( 'vykazPraceEditor' ) vykazPraceEditor;



    constructor(
        private vykazPraceService: VykazPraceService,
        private toasterService: ToasterService,
        private applicationService: ApplicationService ) {

        this.fromDate = new Date();
        this.fromDate.setDate( this.fromDate.getDate() - 2 );

        this.toDate = new Date();
        this.toDate.setDate( this.toDate.getDate() + 365 );
    }

    ngOnInit() {
        this.vykazMenuItems = [
            { label: 'Upravit', icon: 'fa-pencil-square-o', command: ( event ) => this.editVykazPrace(this.selectedVykazPrace) }
        ];

        this.readVykazPraces();
        this.refreshAutoRefreshSubscription();


    }

    readVykazPraces() {
        this.readingVykazPraces = true;
        this.unsubscribeAutoRefreshSubscription();
        this.vykazPraceService.getEmployeeVykazPracesOverview( this.fromDate, this.toDate ).subscribe(
            data => {
                this.readingVykazPraces = false;
                this.vykazPraces = data;
                this.refreshAutoRefreshSubscription();
            },
            err => {
                this.readingVykazPraces = false;
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
            this.readVykazPraces();
        } );
    }
    
    private editVykazPrace(vykaz: VykazPrace) {
        this.vykazPraceEditor.show(vykaz);
    }

}
