import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions, URLSearchParams } from '@angular/http';
import { UkolFilterParameters } from '../model/ukol-filter-parameters';
import { ApplicationService } from './application.service';

@Injectable()
export class UkolService {

    constructor(
        private http: Http,
        private applicationService: ApplicationService ) { }

    private getServiceUrl() {
        return this.applicationService.backendServicesUrl + '/isza/ukol';
    }

    getUkols( params: UkolFilterParameters ) {
        let headers = new Headers( { 'Content-Type': 'application/json' } );
        let options = new RequestOptions( { headers: headers } );
        return this.http.post( this.getServiceUrl() + "/ukols", params, options ).map( res => res.json() );
    }
}
