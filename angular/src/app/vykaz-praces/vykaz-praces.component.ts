import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { VykazPraceService } from '../services/vykaz-prace.service';
import { KalendarService } from '../services/kalendar.service';
import { ApplicationService } from '../services/application.service';
import { ToasterService } from 'angular2-toaster';
import { VykazPrace } from '../model/vykaz-prace';
import { Observable, Subscription } from 'rxjs/Rx';
import { MenuItem } from 'primeng/primeng';
import { VykazPraceFilterParameters } from '../model/vykaz-prace-filter-parameters';
import { Den } from '../model/den';
import { DensFilterParameters } from '../model/dens-filter-parameters';
import { VykazPraceEditorComponent } from '../vykaz-prace-editor/vykaz-prace-editor.component';
import { DatePipe } from '@angular/common';
import { VykazPraceDayMoverComponent } from '../vykaz-prace-day-mover/vykaz-prace-day-mover.component';
import { NextPracovniDenFilterParameters } from '../model/next-pracovni-den-filter-parameters';


@Component( {
    selector: 'app-vykaz-praces',
    templateUrl: './vykaz-praces.component.html',
    styleUrls: ['./vykaz-praces.component.css'],
    providers: [VykazPraceService, KalendarService, DatePipe]
} )
export class VykazPracesComponent implements OnInit {

    fromDate: Date = new Date();
    toDate: Date = new Date();
    vykazPraces: VykazPrace[] = [];
    readingData: boolean = false;
    dens: Den[] = [];
    selectedDay: Den;
    unsolvedDaysOnly: boolean = true;
    kalendarObdobidialogVisible: boolean = false;
    nextPracovniDen: Den;

    kalendarMenuItems: MenuItem[];

    @ViewChild( 'vykazPraceEditor' ) vykazPraceEditor: VykazPraceEditorComponent;
    @ViewChild( 'vykazPraceDayMover' ) vykazPraceDayMover: VykazPraceDayMoverComponent;

    private autoRefreshSubscription: Subscription;

    constructor(
        private vykazPraceService: VykazPraceService,
        private kalendarService: KalendarService,
        private toasterService: ToasterService,
        public applicationService: ApplicationService,
        private datePipe: DatePipe ) {

        this.fromDate = new Date();
        this.fromDate.setDate( this.fromDate.getDate() - 30 );

        this.toDate = new Date();
        this.toDate.setDate( this.toDate.getDate() + 30 );
    }

    ngOnInit() {
        this.kalendarMenuItems = [
            { label: 'Potvrdit výkazy', icon: 'fa-check', command: ( event ) => this.confirmVykazPraces( this.selectedDay ) },
            { label: 'Nový výkaz', icon: 'fa-asterisk', command: ( event ) => this.newVykazPrace( this.selectedDay ) },
            { label: 'Posunout výkazy', icon: 'fa-forward', command: ( event ) => this.moveDayVykazPraces( this.selectedDay ) },
            { separator: true },
            { label: 'Refresh', icon: 'fa-refresh', command: ( event ) => this.readDens() },
            {
                label: 'Jen nevyřešené dny', icon: 'fa-check-circle-o', command: ( event ) => this.switchUnsolvedDaysOnly(),
                styleClass: 'mojeCcaMenuUnsolvedDaysOnly'
            },
            {
                label: this.getMenuObdobiText(), icon: 'fa-calendar', command: ( event ) => this.kalendarObdobidialogVisible = true,
                styleClass: 'mojeCcaMenuPeriod'
            }
        ];

        this.readDens();
    }

    getMenuObdobiText(): string {
        var result;

        if ( this.fromDate ) {
            result = this.datePipe.transform( this.fromDate, 'ddMM.yy' );
        } else {
            result = '...';
        }
        result += ' - ';
        if ( this.toDate ) {
            result += this.datePipe.transform( this.toDate, 'ddMM.yy' );
        } else {
            result += '...';
        }

        return result;
    }

    readDens() {
        this.readingData = true;
        this.unsubscribeAutoRefreshSubscription();

        let params = new DensFilterParameters();
        params.kodUzivatele = this.applicationService.kodUzivatele;
        
        params.unsolvedDaysOnly = this.unsolvedDaysOnly;
        if (!this.unsolvedDaysOnly) {
            params.fromDate = this.fromDate.getTime();
            params.toDate = this.toDate.getTime();
        }

        this.kalendarService.getDens( params,
            data => {
                this.dens = data;

                var selectedDate: number;
                if ( this.selectedDay ) {
                    selectedDate = this.selectedDay.datum;
                }
                if ( this.dens.length > 0 ) {
                    this.selectedDay = this.dens[0];
                    this.dens.forEach( value => {
                        if ( ( selectedDate && selectedDate === value.datum ) ||
                            ( !selectedDate && this.isToday( value.datum ) ) ) {
                            this.selectedDay = value;
                        }
                    } );
                }
                
                var lastUnsolvedDay: Den;
                this.dens.forEach(value => {
                    if (value.imisDen.unsolved) {
                        lastUnsolvedDay = value;
                    }
                });
                if (lastUnsolvedDay) {
                    let ps = new NextPracovniDenFilterParameters();
                    ps.day = lastUnsolvedDay.datum;
                    ps.kodUzivatele = this.applicationService.kodUzivatele;
                    this.kalendarService.getNextPracovniDen(ps, data => this.nextPracovniDen = data);
                }

                this.readVykazPraces();
            }
        );
    }

    readVykazPraces() {
        if ( !this.selectedDay || !this.selectedDay.datum ) {
            this.vykazPraces = [];
            this.readingData = false;
            this.refreshAutoRefreshSubscription();
            return;
        }

        this.readingData = true;
        this.unsubscribeAutoRefreshSubscription();

        let params = new VykazPraceFilterParameters();
        params.kodUzivatele = this.applicationService.kodUzivatele;
        params.fromDate = this.selectedDay.datum;
        params.toDate = this.selectedDay.datum;

        this.vykazPraceService.getVykazPraces( params,
            data => {
                this.vykazPraces = data;
            },
            success => {
                this.readingData = false;
                this.refreshAutoRefreshSubscription();
            } )
    }


    celkemOdvedenePrace( date: number ): number {
        var sum = 0;

        this.vykazPraces.forEach( value => {
            if ( value.datum === date ) {
                sum += value.mnozstviOdvedenePrace;
            }
        } );
        return sum;
    }

    private unsubscribeAutoRefreshSubscription() {
        if ( this.autoRefreshSubscription != null ) {
            this.autoRefreshSubscription.unsubscribe();
        }
    }

    private refreshAutoRefreshSubscription() {
        this.unsubscribeAutoRefreshSubscription();
        this.autoRefreshSubscription = Observable.interval( 60000 ).subscribe(() => {
            this.readDens()
        } );
    }

    isToday( date: number ): boolean {
        let today = new Date();
        today.setHours( 0, 0, 0, 0 );
        return date === today.getTime();
    }
    
    isPast( date: number ): boolean {
        let today = new Date();
        today.setHours( 0, 0, 0, 0 );
        return date < today.getTime();
    }
    
    
    dayStyle( day: Den ): any {
        if (day && day.iszaDen && day.iszaDen.druhDne !== 'P') {
            return {'color': 'lightgrey'};
        } 
        
        return {};
    }
    
    warningDay(den : Den): boolean {
        let isPast = this.isPast(den.datum);
        
        if (isPast && den.imisDen.unsolved) {
            return true;
        }
        
        if (!isPast && den.imisDen.unsolved && den.iszaDen.druhDne !== 'P'){
            return true;
        }
                
        return false;
    }

    onDateSelect() {
        this.readVykazPraces();
    }

    private confirmVykazPraces( den: Den ) {
        this.vykazPraceService.confirmVykazPraces( den.datum, den.datum,
            () => {
                this.readDens();
            } )
    }

    newVykazPrace( den: Den ) {
        let vykazPrace = new VykazPrace();
        vykazPrace.datum = den.datum;
        vykazPrace.kodUzivatele = this.applicationService.kodUzivatele;
        this.vykazPraceEditor.show( vykazPrace );
    }

    switchUnsolvedDaysOnly() {
        this.unsolvedDaysOnly = !this.unsolvedDaysOnly;
        this.kalendarMenuItems.find( value => value.styleClass === 'mojeCcaMenuUnsolvedDaysOnly' ).icon = this.unsolvedDaysOnly ? 'fa-check-circle-o' : 'fa-circle-o';
        this.readDens();
    }
    
    kalendarObdobidialogOk() {
        this.unsolvedDaysOnly = false;
        this.kalendarObdobidialogVisible = false;
        this.kalendarMenuItems.find( value => value.styleClass === 'mojeCcaMenuPeriod' ).label = this.getMenuObdobiText();
        this.readDens();
    }
    
    kalendarObdobidialogTentoMesic() {
        let now = new Date();
        this.fromDate = new Date(now.getFullYear(), now.getMonth(), 1);
        this.toDate = new Date(now.getFullYear(), now.getMonth() + 1, 0);
        this.kalendarObdobidialogOk()
    }
    
    kalendarObdobidialogTentoAMinulyMesic() {
        let now = new Date();
        this.fromDate = new Date(now.getFullYear(), now.getMonth() - 1, 1);
        this.toDate = new Date(now.getFullYear(), now.getMonth() + 1, 0);
        this.kalendarObdobidialogOk()
    }

    kalendarObdobidialogTentoAPristiMesic() {
        let now = new Date();
        this.fromDate = new Date(now.getFullYear(), now.getMonth(), 1);
        this.toDate = new Date(now.getFullYear(), now.getMonth() + 2, 0);
        this.kalendarObdobidialogOk()
    }
    
    
    moveDayVykazPraces( den: Den): void {
        this.vykazPraceDayMover.show(new Date(den.datum));
    }

}
