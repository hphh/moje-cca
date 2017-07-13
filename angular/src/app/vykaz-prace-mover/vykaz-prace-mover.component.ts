import { Component, OnInit, Input } from '@angular/core';
import { VykazPrace } from '../model/vykaz-prace';
import { VykazPraceService } from '../services/vykaz-prace.service';
import { ToasterService } from 'angular2-toaster';

@Component( {
    selector: 'app-vykaz-prace-mover',
    templateUrl: './vykaz-prace-mover.component.html',
    styleUrls: ['./vykaz-prace-mover.component.css'],
    providers: [VykazPraceService]
} )
export class VykazPraceMoverComponent implements OnInit {

    dialogVisible: boolean = false;
    vykazPrace: VykazPrace = new VykazPrace();
    newDate: Date = new Date();

    constructor(
            private vykazPraceService: VykazPraceService,
            private toasterService: ToasterService) { }

    ngOnInit() {
    }
    
    
    @Input()
    show(vykazPrace: VykazPrace) {
      if (vykazPrace == null) {
        return;
      }
      
      this.dialogVisible = true;
      this.vykazPrace = vykazPrace;
      this.newDate = new Date(vykazPrace.datum);

    }
    
    onOk() {
        if (this.newDate.getDate() === this.vykazPrace.datum) {
            return;
        }
        
        let vykazPrace = Object.assign({}, this.vykazPrace);
        vykazPrace.datum = this.newDate.getTime();
        let vykazPraces = [vykazPrace];
        
        this.vykazPraceService.updateVykazPraces(vykazPraces).subscribe(
                data => {
                    this.dialogVisible = false;
                },
                err => {
                    console.log( 'chyba při změně výkazu' );
                    console.log( err );
                    this.toasterService.pop( 'error', 'Nedaří se zpracovat požadavek', null );
                } 
        );
        
    }
     
}
