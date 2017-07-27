import { Injectable } from '@angular/core';
import { UkolFilterParameters } from '../model/ukol-filter-parameters';
import { CallBackendService } from './call-backend.service';
import { Ukol } from '../model/ukol';

@Injectable()
export class UkolService {

    private readonly ROOT_PATH = '/isza/ukol';

    constructor( private callBackendService: CallBackendService ) { }

    getUkols( params: UkolFilterParameters,
        successCallback?: ( data: Ukol[] ) => void,
        finishCallback?: ( success: boolean ) => void ): void {

        this.callBackendService.post(
            this.ROOT_PATH + '/ukols',
            params,
            successCallback,
            finishCallback );

    }
}
