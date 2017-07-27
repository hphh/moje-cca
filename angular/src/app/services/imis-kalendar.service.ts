import { Injectable } from '@angular/core';
import { ApplicationService } from './application.service';
import { ImisDaysFilterParameters } from '../model/imis-days-filter-parameters';
import { CallBackendService } from './call-backend.service';
import { ImisDay } from '../model/imis-day';


@Injectable()
export class ImisKalendarService {

    private readonly ROOT_PATH = '/imis/kalendar';


    constructor( private callBackendService: CallBackendService ) {
    }

    getImisDays(
        params: ImisDaysFilterParameters,
        successCallback?: ( data: ImisDay[] ) => void,
        finishCallback?: ( success: boolean ) => void ): void {

        this.callBackendService.post(
            this.ROOT_PATH + '/imisDays',
            params,
            successCallback,
            finishCallback );
    }
}
