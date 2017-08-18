import { Injectable } from '@angular/core';
import { CallBackendService } from './call-backend.service';
import { EmployeeDayPrichodOdchodsFilterParameters } from '../model/employee-day-prichod-odchods-filter-parameters';
import { EmployeeDayPrichodOdchods } from '../model/employee-day-prichod-odchods';
import { EmployeeNahradniVolnoFilterParameters } from '../model/employee-nahradni-volno-filter-parameters';
import { EmployeeNahradniVolno } from '../model/employee-nahradni-volno';
import { Dovolena } from '../model/dovolena';
import { DovolenaFilterParameters } from '../model/dovolena-filter-parameters';

@Injectable()
export class DochazkaService {

    private readonly ROOT_PATH = '/imis/dochazka';

    constructor( private callBackendService: CallBackendService ) { }

    getEmployeeDayPrichodOdchods(
        params: EmployeeDayPrichodOdchodsFilterParameters,
        successCallback?: ( data: EmployeeDayPrichodOdchods ) => void,
        finishCallback?: ( success: boolean ) => void ): void {

        this.callBackendService.post(
            this.ROOT_PATH + '/employeeDayPrichodOdchods',
            params,
            successCallback,
            finishCallback );
    }


    getEmployeeNahradniVolno( params: EmployeeNahradniVolnoFilterParameters,
        successCallback?: ( data: EmployeeNahradniVolno ) => void,
        finishCallback?: ( success: boolean ) => void ): void {

        this.callBackendService.post(
            this.ROOT_PATH + '/employeeNahradniVolno',
            params,
            successCallback,
            finishCallback );
    }

    getDovolena( params: DovolenaFilterParameters,
        successCallback?: ( data: Dovolena ) => void,
        finishCallback?: ( success: boolean ) => void ): void {

        this.callBackendService.post(
            this.ROOT_PATH + '/employeeDovolena',
            params,
            successCallback,
            finishCallback );
    }
}
