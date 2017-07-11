import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { AppComponent } from './app.component';

import {
    DataTableModule, 
    SharedModule, 
    InputTextModule,
    DialogModule,
    ButtonModule,
    TooltipModule
    } from 'primeng/primeng';
    
import { ToasterModule, ToasterService } from 'angular2-toaster';   


@NgModule({
  declarations: [
    AppComponent
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
    TooltipModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
