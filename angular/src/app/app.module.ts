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
    CalendarModule,
    ContextMenuModule,
    CheckboxModule
    } from 'primeng/primeng';
    
import { ToasterModule, ToasterService } from 'angular2-toaster';   

import { EmployeeVykazPraceOverviewComponent } from './employee-vykaz-prace-overview/employee-vykaz-prace-overview.component';
import { VykazPraceEditorComponent } from './vykaz-prace-editor/vykaz-prace-editor.component';
import { MnozstviHodPipe } from './converts/mnozstvi-hod.pipe';
import { ZakazkaPipe } from './converts/zakazka.pipe';
import { VykazPraceSplitterComponent } from './vykaz-prace-splitter/vykaz-prace-splitter.component';
import { VykazPraceTableComponent } from './vykaz-prace-table/vykaz-prace-table.component';
import { VykazyNaUkolComponent } from './vykazy-na-ukol/vykazy-na-ukol.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeVykazPraceOverviewComponent,
    MnozstviHodPipe,
    VykazPraceEditorComponent,
    ZakazkaPipe,
    VykazPraceSplitterComponent,
    VykazPraceTableComponent,
    VykazyNaUkolComponent
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
    CalendarModule,
    ContextMenuModule,
    CheckboxModule
  ],
  providers: [DatePipe, DecimalPipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
