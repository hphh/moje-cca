import { Injectable } from '@angular/core';
import { CallBackendService } from './call-backend.service';
import { EmployeeDayPrichodOdchodsFilterParameters } from '../model/employee-day-prichod-odchods-filter-parameters';
import { EmployeeDayPrichodOdchods } from '../model/employee-day-prichod-odchods';

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
}
