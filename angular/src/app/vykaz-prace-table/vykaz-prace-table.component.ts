import { Component, OnInit, Input, ViewChild } from '@angular/core';
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

    @Input()
    vykazPraces: VykazPrace[] = [];

    constructor() { }

    ngOnInit() {
        this.vykazMenuItems = [
            { label: 'Upravit', icon: 'fa-pencil-square-o', command: ( event ) => this.editVykazPrace( this.selectedVykazPrace ) },
            { label: 'Rozdělit', icon: 'fa-scissors', command: ( event ) => this.splitVykazPrace( this.selectedVykazPrace ) }
        ];

    }

    private editVykazPrace( vykaz: VykazPrace ) {
        this.vykazPraceEditor.show( vykaz );
    }

    private splitVykazPrace( vykaz: VykazPrace ) {
        this.vykazPraceSplitter.show( vykaz );
    }

}
