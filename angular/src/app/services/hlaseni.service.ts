import { Injectable } from '@angular/core';
import { HlaseniFilterParameters } from '../model/hlaseni-filter-parameters';
import { CallBackendService } from './call-backend.service';
import { Hlaseni } from '../model/hlaseni';

@Injectable()
export class HlaseniService {

    private readonly ROOT_PATH = '/isza/hlaseni';

    constructor( private callBackendService: CallBackendService ) { }

    getHlasenis( params: HlaseniFilterParameters,
        successCallback?: ( data: Hlaseni[] ) => void,
        finishCallback?: ( success: boolean ) => void ): void {

        this.callBackendService.post(
            this.ROOT_PATH + '/hlasenis',
            params,
            successCallback,
            finishCallback );

    }
}
