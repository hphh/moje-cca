import { Routes } from '@angular/router';
import { PageEmployeeOverviewComponent } from './page-employee-overview/page-employee-overview.component';
import { PageVykazPracesListComponent } from './page-vykaz-praces-list/page-vykaz-praces-list.component';

export const routes: Routes = [
    { path: '', component: PageEmployeeOverviewComponent },
    { path: 'pageVykazPracesList', component: PageVykazPracesListComponent }
];