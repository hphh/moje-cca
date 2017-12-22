import { Component, OnInit, Input, Output, ViewChild, EventEmitter } from '@angular/core';
import { VykazPrace } from '../model/vykaz-prace';
import { MenuItem } from 'primeng/primeng';
import { VykazPracesOverviewComponent } from '../vykaz-praces-overview/vykaz-praces-overview.component';
import { VykazPraceFilterParameters } from '../model/vykaz-prace-filter-parameters';
import { VykazPraceService } from '../services/vykaz-prace.service';
import { ToasterService } from 'angular2-toaster';
import { ConfirmationService } from 'primeng/primeng';
import { MnozstviHodPipe } from '../converts/mnozstvi-hod.pipe';
import { ZakazkaPipe } from '../converts/zakazka.pipe';
import { GlobalRefreshService } from "../services/global-refresh.service";


@Component( {
    selector: 'app-vykaz-prace-table',
    templateUrl: './vykaz-prace-table.component.html',
    styleUrls: ['./vykaz-prace-table.component.css'],
    providers: [ MnozstviHodPipe, ZakazkaPipe ]
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


    constructor(
            private vykazPraceService: VykazPraceService,
            private toasterService: ToasterService,
            private confirmationService: ConfirmationService,
            private mnozstviHodPipe: MnozstviHodPipe,
            private zakazkaPipe: ZakazkaPipe,
            public globalRefreshService: GlobalRefreshService) { }

    ngOnInit() {
    }

    private refreshMenuItems( vykaz: VykazPrace ) {
        this.vykazMenuItems = [];
        if ( !this.disableEdit ) {
            this.vykazMenuItems.push(
                { label: 'Upravit', icon: 'fa-pencil-square-o', command: ( event ) => this.editVykazPrace( this.selectedVykazPrace ) },
                { label: 'Rozdělit', icon: 'fa-scissors', command: ( event ) => this.splitVykazPrace( this.selectedVykazPrace ) },
                { label: 'Smazat', icon: 'fa-times', command: ( event ) => this.deleteVykazPrace( this.selectedVykazPrace ) } 
            );
        }

        if ( !this.disableVykazyNaUkol ) {
            if ( !this.disableEdit ) {
                this.vykazMenuItems.push( { separator: true } );
            }
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

    private deleteVykazPrace( vykaz: VykazPrace ) {
        this.confirmationService.confirm({
            header: 'Opravdu smazat tento výkaz?',
            message: this.prepareVykazDescription(vykaz),
            icon: 'fa fa-exclamation-triangle',
            accept: () => {
                this.vykazPraceService.deleteVykazPraces([vykaz], () => {
                    this.toasterService.pop( 'info', 'Výkaz odmazán', null );
                },
                success => {
                    this.globalRefreshService.globalRefresh();
                }); 
            }
        });        
    }
    
    private prepareVykazDescription( vykaz: VykazPrace ): string {
        return this.mnozstviHodPipe.transform(vykaz.mnozstviOdvedenePrace) +
            ' hod - ' +
            this.zakazkaPipe.transform(vykaz) + 
            '<br>' + 
            vykaz.popisPrace;
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
