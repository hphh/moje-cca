import { Pipe, PipeTransform } from '@angular/core';
import { DecimalPipe } from '@angular/common';
import { VykazPrace } from '../model/vykaz-prace';

@Pipe( {
    name: 'zakazka'
} )
export class ZakazkaPipe implements PipeTransform {

    constructor(private decimalPipe: DecimalPipe) {
        
    }

    transform( value: VykazPrace, args?: any ): string {
        return value.zakazka + '/' + value.polozka + '/' + value.pozice;
    }

}
