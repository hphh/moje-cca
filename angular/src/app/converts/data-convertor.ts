export class DataConvertor {
    
    static mnozstviHodToDate(mnozstviHod: number): Date {
        var result =  new Date();
        result.setHours(mnozstviHod, Math.round((Math.abs(mnozstviHod) % 1) * 60), 0, 0);
        return result;
    }
    
    static dateToMnozstviHodToDate(date: Date): number {
        return date.getHours() + (date.getMinutes() / 60);
    }
    
}