import { Component, OnInit, Input, Output, EventEmitter, ViewChild } from '@angular/core';
import { VykazPrace } from '../model/vykaz-prace';
import { VykazPraceService } from '../services/vykaz-prace.service';
import { ToasterService } from 'angular2-toaster';
import { DataConvertor } from '../converts/data-convertor';
import { VykazPraceFilterParameters } from '../model/vykaz-prace-filter-parameters';
import { ApplicationService } from '../services/application.service';
import { ImisKalendarService } from '../services/imis-kalendar.service';
import { ImisDaysFilterParameters } from '../model/imis-days-filter-parameters';
import { ImisDay } from '../model/imis-day';
import { VykazPraceEditFormComponent } from '../vykaz-prace-edit-form/vykaz-prace-edit-form.component';


@Component( {
    selector: 'app-vykaz-prace-editor',
    templateUrl: './vykaz-prace-editor.component.html',
    styleUrls: ['./vykaz-prace-editor.component.css'],
    providers: [VykazPraceService]
} )
export class VykazPraceEditorComponent implements OnInit {

    dialogVisible: boolean = false;

    @ViewChild( 'editForm' ) editForm: VykazPraceEditFormComponent;

    @Output() onSave: EventEmitter<any> = new EventEmitter();
    
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
        
        this.editForm.show(vykazPrace);
        this.dialogVisible = true;
    }

    onOk() {
        let vykazPrace = this.editForm.getVykazPrace();

        this.vykazPraceService.saveOrUpdateVykazPraces( [vykazPrace],
            () => { },
            success => {
                if ( success ) {
                    this.dialogVisible = false;
                    this.onSave.emit();
                }
            }
        );

    }

}
