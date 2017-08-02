import { Component, OnInit, Input, Output, ViewChild, EventEmitter } from '@angular/core';
import { VykazPrace } from '../model/vykaz-prace';
import { MenuItem } from 'primeng/primeng';
import { VykazPracesOverviewComponent } from '../vykaz-praces-overview/vykaz-praces-overview.component';
import { VykazPraceFilterParameters } from '../model/vykaz-prace-filter-parameters';

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
    @ViewChild( 'vykazPracesOverview' ) vykazPracesOverview: VykazPracesOverviewComponent;

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
    }

    private refreshMenuItems( vykaz: VykazPrace ) {
        this.vykazMenuItems = [];
        if ( !this.disableEdit ) {
            this.vykazMenuItems.push(
                { label: 'Upravit', icon: 'fa-pencil-square-o', command: ( event ) => this.editVykazPrace( this.selectedVykazPrace ) },
                { label: 'Rozdělit', icon: 'fa-scissors', command: ( event ) => this.splitVykazPrace( this.selectedVykazPrace ) }
            );
        }

        if ( !this.disableVykazyNaUkol ) {
            if ( vykaz.ukol ) {
                this.vykazMenuItems.push(
                    { label: 'Výkazy na úkol', icon: 'fa-list', command: ( event ) => this.showVykazPracesOverview( this.selectedVykazPrace, VykazPracesOverviewType.ukol ) }
                );
            }
            if ( vykaz.krok ) {
                this.vykazMenuItems.push(
                    { label: 'Výkazy na krok', icon: 'fa-list', command: ( event ) => this.showVykazPracesOverview( this.selectedVykazPrace, VykazPracesOverviewType.krok ) }
                );
            }
            if ( vykaz.hlaseni ) {
                this.vykazMenuItems.push(
                    { label: 'Výkazy na hlášení', icon: 'fa-list', command: ( event ) => this.showVykazPracesOverview( this.selectedVykazPrace, VykazPracesOverviewType.hlaseni ) }
                );
            }
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

    private showVykazPracesOverview( vykaz: VykazPrace, type: VykazPracesOverviewType ) {
        if ( !vykaz.ukol ) {
            return;
        }

        let params = new VykazPraceFilterParameters();

        switch ( type ) {
            case VykazPracesOverviewType.ukol:
                params.ukol = vykaz.ukol;
                break;
            case VykazPracesOverviewType.krok:
                params.krok = vykaz.krok;
                break;
            case VykazPracesOverviewType.hlaseni:
                params.hlaseni = vykaz.hlaseni;
                break;
        }
        this.vykazPracesOverview.show( params );
    }

    onContextMenuSelect( event ) {
        this.refreshMenuItems( event.data );
    }

}

enum VykazPracesOverviewType {
    ukol,
    krok,
    hlaseni
}
