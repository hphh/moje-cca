import { Injectable } from '@angular/core';
import { KrokFilterParameters } from '../model/krok-filter-parameters';
import { CallBackendService } from './call-backend.service';
import { Krok } from '../model/krok';

@Injectable()
export class KrokService {

    private readonly ROOT_PATH = '/isza/krok';

    constructor( private callBackendService: CallBackendService ) { }

    getKroks( params: KrokFilterParameters,
        successCallback?: ( data: Krok[] ) => void,
        finishCallback?: ( success: boolean ) => void ): void {

        this.callBackendService.post(
            this.ROOT_PATH + '/kroks',
            params,
            successCallback,
            finishCallback );

    }
}
