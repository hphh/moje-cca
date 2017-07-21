import { Injectable } from '@angular/core';
import { DatePipe } from '@angular/common';
import { Http, Response, Headers, RequestOptions, URLSearchParams } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import { ApplicationService } from './application.service';
import { VykazPrace } from '../model/vykaz-prace';
import { SplittingVykazPrace } from '../model/splitting-vykaz-prace';
import { VykazPraceFilterParameters } from '../model/vykaz-prace-filter-parameters';


@Injectable()
export class VykazPraceService {

    constructor(
        private http: Http,
        private applicationService: ApplicationService,
        private datePipe: DatePipe ) {
    }

    private getServiceUrl() {
        return this.applicationService.backendServicesUrl + '/imis/vykazPrace';
    }

    getVykazPraces( params: VykazPraceFilterParameters ) {
        let headers = new Headers( { 'Content-Type': 'application/json' } );
        let options = new RequestOptions( { headers: headers } );

        return this.http.post( this.getServiceUrl() + "/vykazPraces", params, options ).map( res => res.json() );
    }

    updateVykazPraces( vykazPraces: VykazPrace[] ) {
        let headers = new Headers( { 'Content-Type': 'application/json' } );
        let options = new RequestOptions( { headers: headers } );

        return this.http.post( this.getServiceUrl() + "/updateVykazPraces", vykazPraces, options ).map( res => res.json() );
    }
    
    splitVykazPrace( oldVykazPrace: VykazPrace, newVykazPrace: VykazPrace ) {
        let headers = new Headers( { 'Content-Type': 'application/json' } );
        let options = new RequestOptions( { headers: headers } );
        
        let splittingVykazPrace = new SplittingVykazPrace();
        splittingVykazPrace.oldVykazPrace = oldVykazPrace;
        splittingVykazPrace.newVykazPrace = newVykazPrace;

        return this.http.post( this.getServiceUrl() + "/splitVykazPrace", splittingVykazPrace, options ).map( res => res.json() );
    }

}
