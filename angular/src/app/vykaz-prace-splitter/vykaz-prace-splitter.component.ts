import { Component, OnInit, Input, Output, EventEmitter, ViewChild } from '@angular/core';
import { VykazPrace } from '../model/vykaz-prace';
import { VykazPraceService } from '../services/vykaz-prace.service';
import { ToasterService } from 'angular2-toaster';
import { DataConvertor } from '../converts/data-convertor';
import { VykazPraceEditFormComponent } from '../vykaz-prace-edit-form/vykaz-prace-edit-form.component';
import { KalendarService } from '../services/kalendar.service';
import { NextPracovniDenFilterParameters } from '../model/next-pracovni-den-filter-parameters';
import { Den } from '../model/den';
import { ApplicationService } from '../services/application.service';
import { GlobalRefreshService } from "../services/global-refresh.service";


@Component( {
    selector: 'app-vykaz-prace-splitter',
    templateUrl: './vykaz-prace-splitter.component.html',
    styleUrls: ['./vykaz-prace-splitter.component.css']
} )
export class VykazPraceSplitterComponent implements OnInit {

    dialogVisible: boolean = false;
    connectedMonozstviOdevedenPrace: boolean = true;
    baseMnozstviOdvedenePrace: number;

    @ViewChild( 'oldEditForm' ) oldEditForm: VykazPraceEditFormComponent;
    @ViewChild( 'newEditForm' ) newEditForm: VykazPraceEditFormComponent;

    @Output() onSave: EventEmitter<any> = new EventEmitter();

    constructor(
        private vykazPraceService: VykazPraceService,
        private kalendarService: KalendarService,
        private toasterService: ToasterService,
        public applicationService: ApplicationService,
        public globalRefreshService: GlobalRefreshService ) { }

    ngOnInit() {
    }

    @Input()
    show( vykazPrace: VykazPrace ) {
        if ( vykazPrace == null ) {
            return;
        }

        this.baseMnozstviOdvedenePrace = vykazPrace.mnozstviOdvedenePrace;
        this.oldEditForm.showWithBaseMnozstviOdvedenePrace( vykazPrace, this.baseMnozstviOdvedenePrace );

        let newVykazPrace = Object.assign( {}, vykazPrace );
        newVykazPrace.mnozstviOdvedenePrace = 0;

        let ps = new NextPracovniDenFilterParameters();
        ps.day = newVykazPrace.datum;
        ps.kodUzivatele = this.applicationService.kodUzivatele;
        this.kalendarService.getNextPracovniDen( ps, data => {
            if ( data != null ) {
                newVykazPrace.datum = data.datum;
            } else {
                newVykazPrace.datum = vykazPrace.datum;
            }

            this.newEditForm.showWithBaseMnozstviOdvedenePrace( newVykazPrace, this.baseMnozstviOdvedenePrace );
            this.dialogVisible = true;
        } );

    }

    onOk() {
        let oldVykazPrace = this.oldEditForm.getVykazPrace();
        let newVykazPrace = this.newEditForm.getVykazPrace();

        this.vykazPraceService.splitVykazPrace(
            oldVykazPrace, newVykazPrace,
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

    onChangeOldMnozstviOdvedenePrace( event: number ) {
        if ( !this.connectedMonozstviOdevedenPrace ) {
            return;
        }
        this.newEditForm.setMnozstviOdvedenePraceLoss( event );
    }

    onChangeNewMnozstviOdvedenePrace( event: number ) {
        if ( !this.connectedMonozstviOdevedenPrace ) {
            return;
        }
        this.oldEditForm.setMnozstviOdvedenePraceLoss( event );
    }

}
