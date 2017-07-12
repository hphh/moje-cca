import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { AppComponent } from './app.component';
import { DatePipe, DecimalPipe } from '@angular/common';

import {
    DataTableModule, 
    SharedModule, 
    InputTextModule,
    DialogModule,
    ButtonModule,
    TooltipModule,
    CalendarModule
    } from 'primeng/primeng';
    
import { ToasterModule, ToasterService } from 'angular2-toaster';   

import { EmployeeVykazPraceOverviewComponent } from './employee-vykaz-prace-overview/employee-vykaz-prace-overview.component';
import { MnozstviHodPipe } from './converts/mnozstvi-hod.pipe';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeVykazPraceOverviewComponent,
    MnozstviHodPipe
  ],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    FormsModule,
    HttpModule,
    DataTableModule,
    SharedModule,
    InputTextModule,
    ReactiveFormsModule,
    DialogModule,
    ButtonModule,
    ToasterModule,
    TooltipModule,
    CalendarModule
  ],
  providers: [DatePipe, DecimalPipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
