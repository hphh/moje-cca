import { Injectable } from '@angular/core';
import { ApplicationService } from './application.service';
import { DensFilterParameters } from '../model/dens-filter-parameters';
import { CallBackendService } from './call-backend.service';
import { Den } from '../model/den';


@Injectable()
export class KalendarService {

    private readonly ROOT_PATH = '/kalendar';


    constructor( private callBackendService: CallBackendService ) {
    }

    getImisDays(
        params: DensFilterParameters,
        successCallback?: ( data: Den[] ) => void,
        finishCallback?: ( success: boolean ) => void ): void {

        this.callBackendService.post(
            this.ROOT_PATH + '/dens',
            params,
            successCallback,
            finishCallback );
    }
}
