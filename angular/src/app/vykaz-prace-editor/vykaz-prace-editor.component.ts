import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { VykazPrace } from '../model/vykaz-prace';
import { VykazPraceService } from '../services/vykaz-prace.service';
import { ToasterService } from 'angular2-toaster';

@Component( {
    selector: 'app-vykaz-prace-editor',
    templateUrl: './vykaz-prace-editor.component.html',
    styleUrls: ['./vykaz-prace-editor.component.css'],
    providers: [VykazPraceService]
} )
export class VykazPraceEditorComponent implements OnInit {

    dialogVisible: boolean = false;

    vykazPrace: VykazPrace = new VykazPrace();
    vykazPraceDatum: Date;
    vykazPraceMnozstviOdvedenePrace: Date;

    vykazPraceOriginal: VykazPrace;
    
    @Output() onSave: EventEmitter<any> = new EventEmitter();
    
    constructor(
        private vykazPraceService: VykazPraceService,
        private toasterService: ToasterService) { }

    ngOnInit() {
    }

    

    @Input()
    show( vykazPrace: VykazPrace ) {
        if ( vykazPrace == null ) {
            return;
        }

        this.dialogVisible = true;
        this.vykazPrace = Object.assign( {}, vykazPrace );
        this.vykazPraceDatum = new Date(this.vykazPrace.datum);
        
        this.vykazPraceMnozstviOdvedenePrace = new Date();
        this.vykazPraceMnozstviOdvedenePrace.setHours(this.vykazPrace.mnozstviOdvedenePrace, (this.vykazPrace.mnozstviOdvedenePrace % 1) * 60, 0, 0);
                
        this.vykazPraceOriginal = vykazPrace;

    }

    onOk() {
        this.vykazPrace.datum = this.vykazPraceDatum.getTime();
        this.vykazPrace.mnozstviOdvedenePrace = this.vykazPraceMnozstviOdvedenePrace.getHours() + 
            (this.vykazPraceMnozstviOdvedenePrace.getMinutes() / 60);
        
        if ( this.vykazPraceOriginal === this.vykazPrace ) {
            return;
        }

        let vykazPraces = [this.vykazPrace];

        this.vykazPraceService.updateVykazPraces( vykazPraces ).subscribe(
            data => {
                this.dialogVisible = false;
                this.onSave.emit();
            },
            err => {
                console.log( 'chyba při změně výkazu' );
                console.log( err );
                this.toasterService.pop( 'error', 'Nedaří se zpracovat požadavek', null );
            }
        );

    }
    
}
