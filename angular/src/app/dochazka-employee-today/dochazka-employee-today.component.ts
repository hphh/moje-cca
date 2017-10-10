import {Component, OnInit} from '@angular/core';
import {DochazkaService} from '../services/dochazka.service';
import {ApplicationService} from '../services/application.service';
import {EmployeeDayPrichodOdchodsFilterParameters} from '../model/employee-day-prichod-odchods-filter-parameters';
import {EmployeeDayPrichodOdchods} from '../model/employee-day-prichod-odchods';
import {NotificationService} from '../services/notification.service';
import {MnozstviHodPipe} from '../converts/mnozstvi-hod.pipe';
import {RefreshService} from "../services/refresh.service";

@Component({
  selector: 'app-dochazka-employee-today',
  templateUrl: './dochazka-employee-today.component.html',
  styleUrls: ['./dochazka-employee-today.component.css'],
  providers: [DochazkaService, MnozstviHodPipe, RefreshService]
})
export class DochazkaEmployeeTodayComponent implements OnInit {

  prichodOdchods: EmployeeDayPrichodOdchods;

  private leaveInfoShowDate: Date = null;
  private leaveInfoNVShowDate: Date = null;

  constructor(private dochazkaService: DochazkaService,
              private applicationService: ApplicationService,
              private notificationService: NotificationService,
              private mnozstviHodPipe: MnozstviHodPipe,
              private refreshService: RefreshService) {

    this.refreshService.init(() => {
      this.readPrichodOdchods();
    }, 30000);

  }

  ngOnInit() {
  }

  readPrichodOdchods() {
    console.log('DochazkaEmployeeTodayComponent refresh');
    let params = new EmployeeDayPrichodOdchodsFilterParameters();
    params.date = new Date().getTime();
    params.kodUzivatele = this.applicationService.kodUzivatele;

    this.dochazkaService.getEmployeeDayPrichodOdchods(params,
      data => {
        this.prichodOdchods = data;
        this.showLeaveInfo();
      },
      success => this.refreshService.refreshFinished());
  }


  private showLeaveInfo() {
    if (!this.prichodOdchods) {
      return;
    }

    let now = new Date();
    let nowTime = now.getHours() + now.getMinutes() / 60;

    if (this.prichodOdchods.odchodPlan &&
      !this.leaveInfoShownToday(this.leaveInfoShowDate) &&
      nowTime >= this.prichodOdchods.odchodPlan - 2 / 60) {
      this.notificationService.notify('Běž domů (' + this.mnozstviHodPipe.transform(this.prichodOdchods.odchodPlan) + ')');
      this.leaveInfoShowDate = now;
      this.leaveInfoNVShowDate = now;
    } else if (this.prichodOdchods.odchodPlanWithNV &&
      !this.leaveInfoShownToday(this.leaveInfoNVShowDate) &&
      nowTime >= this.prichodOdchods.odchodPlanWithNV - 2 / 60) {
      this.notificationService.notify('Běž domů NV (' + this.mnozstviHodPipe.transform(this.prichodOdchods.odchodPlanWithNV) + ')');
      this.leaveInfoNVShowDate = now;
    }

  }

  private leaveInfoShownToday(date: Date): boolean {
    if (!date) {
      return;
    }

    let now = new Date();
    let comparedDate = new Date(date);
    now.setHours(0, 0, 0, 0);
    comparedDate.setHours(0, 0, 0, 0);

    return now.getTime() == comparedDate.getTime();
  }


}
