import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { VykazPrace } from '../model/vykaz-prace';
import { VykazPraceService } from '../services/vykaz-prace.service';
import { ToasterService } from 'angular2-toaster';
import { DataConvertor } from '../converts/data-convertor';


@Component( {
    selector: 'app-vykaz-prace-splitter',
    templateUrl: './vykaz-prace-splitter.component.html',
    styleUrls: ['./vykaz-prace-splitter.component.css']
} )
export class VykazPraceSplitterComponent implements OnInit {

    dialogVisible: boolean = false;

    oldVykazPrace: VykazPrace = new VykazPrace();
    oldVykazPraceDatum: Date;
    oldVykazPraceMnozstviOdvedenePrace: Date;

    newVykazPrace: VykazPrace = new VykazPrace();
    newVykazPraceDatum: Date;
    newVykazPraceMnozstviOdvedenePrace: Date;


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

        this.dialogVisible = true;

        this.oldVykazPrace = Object.assign( {}, vykazPrace );
        this.oldVykazPraceMnozstviOdvedenePrace = DataConvertor.mnozstviHodToDate( this.oldVykazPrace.mnozstviOdvedenePrace );
        this.oldVykazPraceDatum = new Date( this.oldVykazPrace.datum );

        this.newVykazPrace = Object.assign( {}, vykazPrace );
        this.newVykazPraceMnozstviOdvedenePrace = DataConvertor.mnozstviHodToDate( 0 );
        this.newVykazPraceDatum = new Date( this.newVykazPrace.datum );
    }

    onOk() {
        this.oldVykazPrace.datum = this.oldVykazPraceDatum.getTime();
        this.oldVykazPrace.mnozstviOdvedenePrace = DataConvertor.toMnozstviHod( this.oldVykazPraceMnozstviOdvedenePrace );

        this.newVykazPrace.datum = this.newVykazPraceDatum.getTime();
        this.newVykazPrace.mnozstviOdvedenePrace = DataConvertor.toMnozstviHod( this.newVykazPraceMnozstviOdvedenePrace );

        this.vykazPraceService.splitVykazPrace( this.oldVykazPrace, this.newVykazPrace,
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
