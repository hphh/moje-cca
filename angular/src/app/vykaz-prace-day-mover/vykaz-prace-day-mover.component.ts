import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { MoveDayVykazPracesParameters } from '../model/move-day-vykaz-praces-parameters';
import { VykazPraceService } from '../services/vykaz-prace.service';
import { ApplicationService } from '../services/application.service';

@Component( {
    selector: 'app-vykaz-prace-day-mover',
    templateUrl: './vykaz-prace-day-mover.component.html',
    styleUrls: ['./vykaz-prace-day-mover.component.css']
} )
export class VykazPraceDayMoverComponent implements OnInit {

    dialogVisible: boolean = false;
    oldDate: Date;
    newDate: Date;
    allNextDays: boolean = true;

    @Output() onSave: EventEmitter<any> = new EventEmitter();


    constructor( private vykazPraceService: VykazPraceService,
            public applicationService: ApplicationService) { }

    ngOnInit() {
    }

    @Input()
    show( oldDate: Date ) {
        this.oldDate = oldDate;
        this.newDate = new Date( oldDate.getTime() + ( 1000 * 60 * 60 * 24 ) );
        this.allNextDays = true;
        this.dialogVisible = true;
    }


    onOk() {
        let params = new MoveDayVykazPracesParameters();
        params.kodUzivatele = this.applicationService.kodUzivatele;
        params.allNextDays = this.allNextDays;
        params.oldDate = this.oldDate.getTime();
        params.newDate = this.newDate.getTime();
        
        this.vykazPraceService.moveDayVykazPraces( params, 
                () => { }, 
                ( success ) => {
            if ( success ) {
                this.dialogVisible = false;
                this.onSave.emit();
            }
        } );
    }
}
