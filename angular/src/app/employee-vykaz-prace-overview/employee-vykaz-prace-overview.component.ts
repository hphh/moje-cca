import { Component, OnInit, Input } from '@angular/core';
import { VykazPraceService } from '../services/vykaz-prace.service';
import { ApplicationService } from '../services/application.service';
import { ToasterService } from 'angular2-toaster';
import { VykazPrace } from '../model/vykaz-prace';

@Component( {
    selector: 'app-employee-vykaz-prace-overview',
    templateUrl: './employee-vykaz-prace-overview.component.html',
    styleUrls: ['./employee-vykaz-prace-overview.component.css'],
    providers: [VykazPraceService, ApplicationService]
} )
export class EmployeeVykazPraceOverviewComponent implements OnInit {

    fromDate: Date = new Date();
    toDate: Date = new Date();
    vykazPraces: VykazPrace[] = [];

    constructor(
        private vykazPraceService: VykazPraceService,
        private toasterService: ToasterService,
        private applicationService: ApplicationService) {
        
        this.fromDate = new Date();
        this.fromDate.setDate(this.fromDate.getDate() - 2);
        
        this.toDate = new Date();
        this.toDate.setDate(this.toDate.getDate() + 365);
    }
    
    readVykazPraces() {
        this.vykazPraceService.getEmployeeVykazPracesOverview(this.fromDate, this.toDate ).subscribe(
                data => {
                    this.vykazPraces = data;
                },
                err => {
                    console.log( 'chyba při čtení výkazu práce' );
                    console.log( err );
                    this.toasterService.pop( 'error', 'Nedaří se načíst data', null );
                } )        
    }

    ngOnInit() {
        this.readVykazPraces();
    }
    
    celkemOdvedenePrace(date: Date): number {
        var sum = 0;
        
        this.vykazPraces.forEach(value => {
           if (value.datum === date) {
               sum += value.mnozstviOdvedenePrace;
           } 
        });
        return sum;
    }

}
