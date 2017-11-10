import {Component, ElementRef, OnInit} from '@angular/core';
import {ApplicationService} from './services/application.service';
import {ToasterConfig} from 'angular2-toaster';
import {CallBackendService} from './services/call-backend.service';
import {GlobalRefreshService} from "./services/global-refresh.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ApplicationService, CallBackendService, GlobalRefreshService]
})
export class AppComponent implements OnInit {

  toasterconfig: ToasterConfig = new ToasterConfig({animation: 'flyRight'});


  constructor(private elm: ElementRef,
              private applicationService: ApplicationService,
              public globalRefreshService: GlobalRefreshService) {

    this.getParam('backendServicesUrl', value => applicationService.backendServicesUrl = value);
    this.getParam('kodUzivatele', value => applicationService.kodUzivatele = value);


    console.log('uživatel: ' + applicationService.kodUzivatele);
    console.log('URL backend služeb: ' + applicationService.backendServicesUrl);

  }

  ngOnInit() {
    this.refreshAll();
  }


  private getParam(name: string, manageFnc: (value: string) => void) {
    let value = this.elm.nativeElement.getAttribute(name);
    if ((value != null) && (!value.startsWith('<%'))) {
      manageFnc(value);
    }
  }


  refreshAll() {
    this.globalRefreshService.globalRefresh();
  }
}
