import { Component, ElementRef } from '@angular/core';
import { ApplicationService } from './services/application.service';
import { ToasterService, ToasterConfig } from 'angular2-toaster';
import { CallBackendService } from './services/call-backend.service';


@Component( {
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css'],
    providers: [ApplicationService, CallBackendService]
} )
export class AppComponent {
    
    toasterconfig: ToasterConfig = new ToasterConfig( { animation: 'flyRight' } );
    

    constructor(
            private elm: ElementRef, 
            private applicationService: ApplicationService) {
        
        this.getParam('backendServicesUrl', value => applicationService.backendServicesUrl = value);
        this.getParam('kodUzivatele', value => applicationService.kodUzivatele = value);
        

        console.log('uživatel: ' + applicationService.kodUzivatele);
        console.log('URL backend služeb: ' + applicationService.backendServicesUrl);
        
    }
    
    private getParam(name: string, manageFnc: (value: string) => void) {
        let value = this.elm.nativeElement.getAttribute(name);
        if ((value != null) && (!value.startsWith('<%'))) {
            manageFnc(value);
        }
    }


}
