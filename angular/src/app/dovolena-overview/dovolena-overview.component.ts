import {Component, OnInit} from '@angular/core';
import {Dovolena} from '../model/dovolena';
import {DovolenaFilterParameters} from '../model/dovolena-filter-parameters';
import {DochazkaService} from '../services/dochazka.service';
import {ApplicationService} from '../services/application.service';
import {Observable, Subscription} from 'rxjs/Rx';
import {GlobalRefreshService} from "../services/global-refresh.service";
import {RefreshService} from "../services/refresh.service";

@Component({
  selector: 'app-dovolena-overview',
  templateUrl: './dovolena-overview.component.html',
  styleUrls: ['./dovolena-overview.component.css'],
  providers: [DochazkaService, RefreshService]
})
export class DovolenaOverviewComponent implements OnInit {

  dovolena: Dovolena;

  constructor(private dochazkaService: DochazkaService,
              private applicationService: ApplicationService,
              private refreshService: RefreshService) {
    this.refreshService.init(() => {
      this.readDovolena();
    }, 60 * 60000)

  }

  ngOnInit() {
  }

  readDovolena() {
    console.log('DovolenaOverviewComponent refresh')
    let params = new DovolenaFilterParameters();
    params.kodUzivatele = this.applicationService.kodUzivatele;

    this.dochazkaService.getDovolena(params,
      data => this.dovolena = data,
      success => this.refreshService.refreshFinished());
  }


}
