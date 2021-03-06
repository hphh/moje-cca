import { Component, OnInit, Input, Output, EventEmitter, ViewChild } from '@angular/core';
import { VykazPrace } from '../model/vykaz-prace';
import { VykazPraceService } from '../services/vykaz-prace.service';
import { ToasterService } from 'angular2-toaster';
import { DataConvertor } from '../converts/data-convertor';
import { VykazPraceFilterParameters } from '../model/vykaz-prace-filter-parameters';
import { ApplicationService } from '../services/application.service';
import { VykazPraceEditFormComponent } from '../vykaz-prace-edit-form/vykaz-prace-edit-form.component';
import { GlobalRefreshService } from "../services/global-refresh.service";


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
        public globalRefreshService: GlobalRefreshService ) { }

    ngOnInit() {
    }

    @Input()
    show( vykazPrace: VykazPrace ) {
        if ( vykazPrace == null ) {
            return;
        }

        this.editForm.show( vykazPrace );
        this.dialogVisible = true;
    }

    onOk() {
        let vykazPrace = this.editForm.getVykazPrace();

        this.vykazPraceService.saveOrUpdateVykazPraces( [vykazPrace],
            () => { },
            success => {
                if ( success ) {
                    this.dialogVisible = false;
                    this.globalRefreshService.globalRefresh();
                    this.onSave.emit();
                }
            }
        );

    }

}
