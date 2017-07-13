import { Injectable } from '@angular/core';
import { DatePipe } from '@angular/common';
import { Http, Response, Headers, RequestOptions, URLSearchParams } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import { ApplicationService } from './application.service';
import { VykazPrace } from '../model/vykaz-prace';


@Injectable()
export class VykazPraceService {

    private readonly serviceUrl: string;

    constructor( 
            private http: Http, 
            private applicationService: ApplicationService,
            private datePipe: DatePipe) {
        this.serviceUrl = applicationService.backendServicesUrl + '/imis/vykazPrace';
    }

    getEmployeeVykazPracesOverview( fromDate: Date, toDate: Date ) {
        let params: URLSearchParams = new URLSearchParams();
        params.set( 'kodUzivatele', this.applicationService.kodUzivatele );
        params.set( 'fromDate', this.datePipe.transform(fromDate, 'MM/dd/yyyy'));
        params.set( 'toDate', this.datePipe.transform(toDate, 'MM/dd/yyyy'));

        return this.http.get( this.serviceUrl + "/employeeVykazPraces", { params: params } ).map( res => res.json() );
    }
    
    updateVykazPraces(vykazPraces: VykazPrace[]) {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        
        return this.http.post(this.serviceUrl + "/updateVykazPraces", vykazPraces, options).map(res => res.json() );
    } 

}
