import {Component, OnInit} from '@angular/core';
import {VykazPraceService} from '../services/vykaz-prace.service';
import {ApplicationService} from '../services/application.service';
import {RefreshService} from "../services/refresh.service";

@Component({
  selector: 'app-napracovano-overview',
  templateUrl: './napracovano-overview.component.html',
  styleUrls: ['./napracovano-overview.component.css'],
  providers: [VykazPraceService, RefreshService]
})
export class NapracovanoOverviewComponent implements OnInit {

  napracovanoHod: number = 0;

  constructor(private vykazPraceService: VykazPraceService,
              private applicationService: ApplicationService,
              private refreshService: RefreshService) {

    this.refreshService.init(() => {
      this.readNapracovano();
    }, 59000)
  }

  ngOnInit() {
  }

  readNapracovano() {
    this.vykazPraceService.napracovanoHodin(
      this.applicationService.kodUzivatele,
      data => this.napracovanoHod = data,
      success => this.refreshService.refreshFinished());
  }


}
