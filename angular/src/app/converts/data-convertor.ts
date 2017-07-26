import { CisloRok } from '../model/cislo-rok';

export class DataConvertor {
    
    static mnozstviHodToDate(mnozstviHod: number): Date {
        var result =  new Date();
        result.setHours(mnozstviHod, Math.round((Math.abs(mnozstviHod) % 1) * 60), 0, 0);
        return result;
    }
    
    static dateToMnozstviHodToDate(date: Date): number {
        return date.getHours() + (date.getMinutes() / 60);
    }
    
    static toCisloRok(text: string): CisloRok {
        if (text == null) {
            return null;
        }
        
        let i = text.indexOf('/');
        
        if (i < 0) {
            return null;
        }
        
        let result = new CisloRok();
        
        result.cislo = +text.substr(0, i);
        result.rok = +text.substr(i + 1);
        
        return result;
    }
    
}