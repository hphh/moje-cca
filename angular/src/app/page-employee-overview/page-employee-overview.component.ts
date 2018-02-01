import { Component, OnInit } from '@angular/core';
import { GlobalRefreshService } from '../services/global-refresh.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-page-employee-overview',
  templateUrl: './page-employee-overview.component.html',
  styleUrls: ['./page-employee-overview.component.css']
})
export class PageEmployeeOverviewComponent implements OnInit {

  constructor(
          public globalRefreshService: GlobalRefreshService,
          private router: Router) { }

  ngOnInit() {
      this.globalRefreshService.globalRefresh();
  }

  showPageVykazPracesList() {
      this.router.navigate(['/pageVykazPracesList']);
  }
}
