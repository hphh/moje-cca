import { Component, OnInit } from '@angular/core';
import { VykazPraceService } from '../services/vykaz-prace.service';
import { ApplicationService } from '../services/application.service';
import { Observable, Subscription } from 'rxjs/Rx';

@Component( {
    selector: 'app-napracovano-overview',
    templateUrl: './napracovano-overview.component.html',
    styleUrls: ['./napracovano-overview.component.css'],
    providers: [ VykazPraceService ]
} )
export class NapracovanoOverviewComponent implements OnInit {

    napracovanoHod: number = 0;

    constructor(
        private vykazPraceService: VykazPraceService,
        private applicationService: ApplicationService ) { }

    ngOnInit() {
        this.readNapracovano();
        Observable.interval( 59000 ).subscribe(() => this.readNapracovano() );
    }

    readNapracovano() {
        this.vykazPraceService.napracovanoHodin(
                this.applicationService.kodUzivatele,
               data => this.napracovanoHod = data);
    }


}
