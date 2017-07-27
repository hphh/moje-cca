import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions, URLSearchParams } from '@angular/http';
import { ApplicationService } from './application.service';
import { ToasterService } from 'angular2-toaster';

@Injectable()
export class CallBackendService {

    constructor(
        private http: Http,
        private applicationService: ApplicationService,
        private toasterService: ToasterService ) { }

    post( path: string, params: any, 
            successCallback?: (data) => any,
            finishCallback?: (success: boolean) => void ) {
        let headers = new Headers( { 'Content-Type': 'application/json' } );
        let options = new RequestOptions( { headers: headers } );

        return this.http.post( this.applicationService.backendServicesUrl + path, params, options )
            .map( res => res.json() )
            .subscribe(
                data => {
                    if (successCallback) {
                        successCallback(data);
                    }
                    if (finishCallback) {
                        finishCallback(true);
                    }
                },
                err => {
                    console.log( 'chyba při volání backend služby' );
                    console.log( err );
                    this.toasterService.pop( 'error', 'Problém v komunikaci se serverem', null );
                    if (finishCallback) {
                        finishCallback(false);
                    }
                }
            );
    }

}
