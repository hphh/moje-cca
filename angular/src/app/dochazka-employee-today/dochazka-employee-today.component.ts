import { Component, OnInit } from '@angular/core';
import { DochazkaService } from '../services/dochazka.service';
import { ApplicationService } from '../services/application.service';
import { EmployeeDayPrichodOdchodsFilterParameters } from '../model/employee-day-prichod-odchods-filter-parameters';
import { EmployeeDayPrichodOdchods } from '../model/employee-day-prichod-odchods';
import { Observable, Subscription } from 'rxjs/Rx';

@Component( {
    selector: 'app-dochazka-employee-today',
    templateUrl: './dochazka-employee-today.component.html',
    styleUrls: ['./dochazka-employee-today.component.css'],
    providers: [DochazkaService]
} )
export class DochazkaEmployeeTodayComponent implements OnInit {

    prichodOdchods: EmployeeDayPrichodOdchods;

    constructor(
        private dochazkaService: DochazkaService,
        private applicationService: ApplicationService ) { }

    ngOnInit() {
        this.readPrichodOdchods();
        Observable.interval( 30000 ).subscribe(() => this.readPrichodOdchods());
    }

    readPrichodOdchods() {
        let params = new EmployeeDayPrichodOdchodsFilterParameters();
        params.date = new Date().getTime();
        params.kodUzivatele = this.applicationService.kodUzivatele;

        this.dochazkaService.getEmployeeDayPrichodOdchods( params,
            data => {
                this.prichodOdchods = data;
            } );
    }


}
