import { Component, OnInit } from '@angular/core';
import { DochazkaService } from '../services/dochazka.service';
import { ApplicationService } from '../services/application.service';
import { Observable, Subscription } from 'rxjs/Rx';
import { EmployeeNahradniVolnoFilterParameters } from '../model/employee-nahradni-volno-filter-parameters';
import { EmployeeNahradniVolno } from '../model/employee-nahradni-volno';

@Component( {
    selector: 'app-nahradni-volno-overview',
    templateUrl: './nahradni-volno-overview.component.html',
    styleUrls: ['./nahradni-volno-overview.component.css'],
    providers: [ DochazkaService ]
} )
export class NahradniVolnoOverviewComponent implements OnInit {

    nahradniVolno: EmployeeNahradniVolno;

    constructor(
        private dochazkaService: DochazkaService,
        private applicationService: ApplicationService ) { }

    ngOnInit() {
        this.readNahradniVolno();
        Observable.interval( 1000 * 60 * 60 ).subscribe(() => this.readNahradniVolno() );
    }

    readNahradniVolno() {
        let params = new EmployeeNahradniVolnoFilterParameters();
        params.kodUzivatele = this.applicationService.kodUzivatele;

        this.dochazkaService.getEmployeeNahradniVolno( params, data => this.nahradniVolno = data );
    }

}
