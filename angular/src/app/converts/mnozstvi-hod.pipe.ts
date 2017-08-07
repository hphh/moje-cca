import { Pipe, PipeTransform } from '@angular/core';
import { DecimalPipe } from '@angular/common';

@Pipe( {
    name: 'mnozstviHod'
} )
export class MnozstviHodPipe implements PipeTransform {

    constructor( private decimalPipe: DecimalPipe ) {

    }

    transform( value: number, args?: any ): string {
        let val = Math.round( value * 1000 ) / 1000;
        
        return this.decimalPipe.transform( Math.trunc( val ), '2.0-0' ) + ':' +
            this.decimalPipe.transform( 60 * ( Math.abs( val ) % 1 ), '2.0-0' );
    }

}
