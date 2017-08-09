import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule, LOCALE_ID  } from '@angular/core';
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
    CheckboxModule,
    AutoCompleteModule,
    DropdownModule
} from 'primeng/primeng';

import { ToasterModule, ToasterService } from 'angular2-toaster';

import { VykazPracesComponent } from './vykaz-praces/vykaz-praces.component';
import { VykazPraceEditorComponent } from './vykaz-prace-editor/vykaz-prace-editor.component';
import { MnozstviHodPipe } from './converts/mnozstvi-hod.pipe';
import { ZakazkaPipe } from './converts/zakazka.pipe';
import { VykazPraceSplitterComponent } from './vykaz-prace-splitter/vykaz-prace-splitter.component';
import { VykazPraceTableComponent } from './vykaz-prace-table/vykaz-prace-table.component';
import { VykazPracesOverviewComponent } from './vykaz-praces-overview/vykaz-praces-overview.component';
import { VykazPraceEditFormComponent } from './vykaz-prace-edit-form/vykaz-prace-edit-form.component';
import { VykazPraceDayMoverComponent } from './vykaz-prace-day-mover/vykaz-prace-day-mover.component';
import { DochazkaEmployeeTodayComponent } from './dochazka-employee-today/dochazka-employee-today.component';

@NgModule( {
    declarations: [
        AppComponent,
        VykazPracesComponent,
        MnozstviHodPipe,
        VykazPraceEditorComponent,
        ZakazkaPipe,
        VykazPraceSplitterComponent,
        VykazPraceTableComponent,
        VykazPracesOverviewComponent,
        VykazPraceEditFormComponent,
        VykazPraceDayMoverComponent,
        DochazkaEmployeeTodayComponent
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
        CheckboxModule,
        AutoCompleteModule,
        DropdownModule
    ],
    providers: [
        DatePipe,
        DecimalPipe,
        { provide: LOCALE_ID, useValue: "cz-CS" }
    ],
    bootstrap: [AppComponent]
} )
export class AppModule { }
