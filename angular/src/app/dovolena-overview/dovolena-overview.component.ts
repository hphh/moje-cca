import { Component, OnInit } from '@angular/core';
import { Dovolena } from '../model/dovolena';
import { DovolenaFilterParameters } from '../model/dovolena-filter-parameters';
import { DochazkaService } from '../services/dochazka.service';
import { ApplicationService } from '../services/application.service';
import { Observable, Subscription } from 'rxjs/Rx';

@Component( {
    selector: 'app-dovolena-overview',
    templateUrl: './dovolena-overview.component.html',
    styleUrls: ['./dovolena-overview.component.css'],
    providers: [ DochazkaService ]
} )
export class DovolenaOverviewComponent implements OnInit {

    dovolena: Dovolena;

    constructor(
        private dochazkaService: DochazkaService,
        private applicationService: ApplicationService
    ) { }

    ngOnInit() {
        this.readDovolena();
        Observable.interval( 60 * 60000 ).subscribe(() => this.readDovolena());
    }

    readDovolena() {
        let params = new DovolenaFilterParameters();
        params.kodUzivatele = this.applicationService.kodUzivatele;

        this.dochazkaService.getDovolena( params,
            data => this.dovolena = data );
    }


}
