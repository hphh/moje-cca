import { Component, OnInit, Input, Output, ViewChild, EventEmitter } from '@angular/core';
import { VykazPrace } from '../model/vykaz-prace';
import { MenuItem } from 'primeng/primeng';

@Component( {
    selector: 'app-vykaz-prace-table',
    templateUrl: './vykaz-prace-table.component.html',
    styleUrls: ['./vykaz-prace-table.component.css']
} )
export class VykazPraceTableComponent implements OnInit {

    vykazMenuItems: MenuItem[];
    selectedVykazPrace: VykazPrace;

    @ViewChild( 'vykazPraceEditor' ) vykazPraceEditor;
    @ViewChild( 'vykazPraceSplitter' ) vykazPraceSplitter;
    @ViewChild( 'vykazyNaUkol' ) vykazyNaUkol;

    @Input()
    vykazPraces: VykazPrace[] = [];

    @Input()
    disableVykazyNaUkol: boolean = false;

    @Input()
    showKodUzivatele: boolean = false;

    @Input()
    datumMode: string = 'group'; //group/show/hide

    @Input()
    hideUkol: boolean = false;

    @Input()
    hideKrok: boolean = false;

    @Input()
    hideHlaseni: boolean = false;

    @Input()
    disableEdit: boolean = false;

    @Output() onSave: EventEmitter<any> = new EventEmitter();


    constructor() { }

    ngOnInit() {
        this.vykazMenuItems = [];
        if ( !this.disableEdit ) {
            this.vykazMenuItems.push(
                { label: 'Upravit', icon: 'fa-pencil-square-o', command: ( event ) => this.editVykazPrace( this.selectedVykazPrace ) },
                { label: 'Rozdělit', icon: 'fa-scissors', command: ( event ) => this.splitVykazPrace( this.selectedVykazPrace ) }
            );
        }

        if ( !this.disableVykazyNaUkol ) {
            this.vykazMenuItems.push(
                { label: 'Výkazy na úkol', icon: 'fa-list', command: ( event ) => this.showVykazyNaUkol( this.selectedVykazPrace ) }
            );
        }
        
    }

    private editVykazPrace( vykaz: VykazPrace ) {
        this.vykazPraceEditor.show( vykaz );
    }

    private splitVykazPrace( vykaz: VykazPrace ) {
        this.vykazPraceSplitter.show( vykaz );
    }

    refreshData() {
        this.onSave.emit();
    }

    private showVykazyNaUkol( vykaz: VykazPrace ) {
        if ( vykaz.ukol == null ) {
            return;
        }

        this.vykazyNaUkol.show( vykaz.ukol );
    }

}
