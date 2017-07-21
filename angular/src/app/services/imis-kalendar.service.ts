import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions, URLSearchParams } from '@angular/http';
import { ApplicationService } from './application.service';
import { DatePipe } from '@angular/common';
import { ImisDaysFilterParameters } from '../model/imis-days-filter-parameters';

@Injectable()
export class ImisKalendarService {

    constructor(
        private http: Http,
        private applicationService: ApplicationService,
        private datePipe: DatePipe ) {
    }

    private getServiceUrl() {
        return this.applicationService.backendServicesUrl + '/imis/kalendar';
    }

    getImisDays( params: ImisDaysFilterParameters ) {
        let headers = new Headers( { 'Content-Type': 'application/json' } );
        let options = new RequestOptions( { headers: headers } );

        return this.http.post( this.getServiceUrl() + "/imisDays", params, options ).map( res => res.json() );
    }
}
