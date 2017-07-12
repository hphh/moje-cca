import { Component, Input } from '@angular/core';
import { ApplicationService } from './services/application.service';
import { ToasterService, ToasterConfig } from 'angular2-toaster';


@Component( {
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css'],
    providers: [ApplicationService]
} )
export class AppComponent {
    
    @Input()
    backendServicesUrl: string;
    
    toasterconfig: ToasterConfig = new ToasterConfig( { animation: 'flyRight' } );
    

    constructor(applicationService: ApplicationService) {

        if ((this.backendServicesUrl != null) && (!this.backendServicesUrl.startsWith('<%'))) {
            applicationService.backendServicesUrl = this.backendServicesUrl;
        }

        console.log('URL backend služeb: ' + applicationService.backendServicesUrl);
        
    }


}
