import {Component, OnInit} from '@angular/core';
import {DochazkaService} from '../services/dochazka.service';
import {ApplicationService} from '../services/application.service';
import {EmployeeNahradniVolnoFilterParameters} from '../model/employee-nahradni-volno-filter-parameters';
import {EmployeeNahradniVolno} from '../model/employee-nahradni-volno';
import {RefreshService} from "../services/refresh.service";

@Component({
  selector: 'app-nahradni-volno-overview',
  templateUrl: './nahradni-volno-overview.component.html',
  styleUrls: ['./nahradni-volno-overview.component.css'],
  providers: [DochazkaService, RefreshService]
})
export class NahradniVolnoOverviewComponent implements OnInit {

  nahradniVolno: EmployeeNahradniVolno;

  constructor(private dochazkaService: DochazkaService,
              private applicationService: ApplicationService,
              private refreshService: RefreshService) {

    this.refreshService.init(() => {
      this.readNahradniVolno();
    }, 1000 * 60 * 60);

  }

  ngOnInit() {
  }

  readNahradniVolno() {
    console.log('NahradniVolnoOverviewComponent refresh');
    let params = new EmployeeNahradniVolnoFilterParameters();
    params.kodUzivatele = this.applicationService.kodUzivatele;

    this.dochazkaService.getEmployeeNahradniVolno(params,
      data => this.nahradniVolno = data,
      success => this.refreshService.refreshFinished());
  }

}
