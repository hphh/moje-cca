import { Pipe, PipeTransform } from '@angular/core';
import { DecimalPipe } from '@angular/common';

@Pipe( {
    name: 'mnozstviHod'
} )
export class MnozstviHodPipe implements PipeTransform {

    constructor(private decimalPipe: DecimalPipe) {
        
    }

    transform( value: number, args?: any ): string {
        return this.decimalPipe.transform(Math.trunc(value), '2.0-0') + ':' + 
            this.decimalPipe.transform(60 * ( value % 1 ), '2.0-0');
    }

}
