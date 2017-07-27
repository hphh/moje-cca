import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { VykazPrace } from '../model/vykaz-prace';
import { VykazPraceService } from '../services/vykaz-prace.service';
import { ToasterService } from 'angular2-toaster';
import { DataConvertor } from '../converts/data-convertor';
import { VykazPraceFilterParameters } from '../model/vykaz-prace-filter-parameters';
import { ApplicationService } from '../services/application.service';
import { ImisKalendarService } from '../services/imis-kalendar.service';
import { ImisDaysFilterParameters } from '../model/imis-days-filter-parameters';
import { ImisDay } from '../model/imis-day';

@Component( {
    selector: 'app-vykaz-prace-edit-form',
    templateUrl: './vykaz-prace-edit-form.component.html',
    styleUrls: ['./vykaz-prace-edit-form.component.css']
} )
export class VykazPraceEditFormComponent implements OnInit {

    vykazPrace: VykazPrace = new VykazPrace();
    vykazPraceDatum: Date;
    vykazPraceMnozstviOdvedenePrace: Date;
    vykazPraceOriginal: VykazPrace;


    constructor(
        private vykazPraceService: VykazPraceService,
        private toasterService: ToasterService,
        private applicationService: ApplicationService,
        private imisKalendarService: ImisKalendarService ) { }

    ngOnInit() {
    }

    @Input()
    show( vykazPrace: VykazPrace ) {
        if ( vykazPrace == null ) {
            return;
        }

        this.vykazPrace = Object.assign( {}, vykazPrace );
        this.vykazPraceDatum = new Date( this.vykazPrace.datum );
        this.vykazPraceMnozstviOdvedenePrace = DataConvertor.mnozstviHodToDate( this.vykazPrace.mnozstviOdvedenePrace );
        this.vykazPraceOriginal = vykazPrace;

    }

}
