import { Component, ElementRef } from '@angular/core';
import { ApplicationService } from './services/application.service';
import { ToasterService, ToasterConfig } from 'angular2-toaster';


@Component( {
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css'],
    providers: [ApplicationService]
} )
export class AppComponent {
    
    toasterconfig: ToasterConfig = new ToasterConfig( { animation: 'flyRight' } );
    

    constructor(elm: ElementRef, applicationService: ApplicationService) {
        const backendServicesUrl = elm.nativeElement.getAttribute('backendServicesUrl');
        
        if ((backendServicesUrl != null) && (!backendServicesUrl.startsWith('<%'))) {
            applicationService.backendServicesUrl = backendServicesUrl;
        }

        console.log('URL backend služeb: ' + applicationService.backendServicesUrl);
        
    }


}
