import { Component, OnInit, Input, Output, EventEmitter, ViewChild } from '@angular/core';
import { VykazPrace } from '../model/vykaz-prace';
import { VykazPraceService } from '../services/vykaz-prace.service';
import { ToasterService } from 'angular2-toaster';
import { DataConvertor } from '../converts/data-convertor';
import { VykazPraceEditFormComponent } from '../vykaz-prace-edit-form/vykaz-prace-edit-form.component';


@Component( {
    selector: 'app-vykaz-prace-splitter',
    templateUrl: './vykaz-prace-splitter.component.html',
    styleUrls: ['./vykaz-prace-splitter.component.css']
} )
export class VykazPraceSplitterComponent implements OnInit {

    dialogVisible: boolean = false;

    @ViewChild( 'oldEditForm' ) oldEditForm: VykazPraceEditFormComponent;
    @ViewChild( 'newEditForm' ) newEditForm: VykazPraceEditFormComponent;

    @Output() onSave: EventEmitter<any> = new EventEmitter();

    constructor(
        private vykazPraceService: VykazPraceService,
        private toasterService: ToasterService ) { }

    ngOnInit() {
    }

    @Input()
    show( vykazPrace: VykazPrace ) {
        if ( vykazPrace == null ) {
            return;
        }

        this.oldEditForm.show( vykazPrace );

        let newVykazPrace = Object.assign( {}, vykazPrace );
        newVykazPrace.mnozstviOdvedenePrace = 0;
        this.newEditForm.show( newVykazPrace );

        this.dialogVisible = true;
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
                    this.onSave.emit();
                }
            }
        );
    }

}
