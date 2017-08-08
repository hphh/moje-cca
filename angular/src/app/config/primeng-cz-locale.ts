import { LocaleSettings } from 'primeng/primeng';

export class PrimengCzLocale implements LocaleSettings {
    
    static readonly INSTANCE = new PrimengCzLocale(); 
    
    firstDayOfWeek = 1;
    dayNames = ['neděle', 'pondělí', 'úterý', 'středa', 'čtvrtek', 'pátek', 'sobota'];
    dayNamesShort = ['ne', 'po', 'út', 'st', 'čt', 'pá', 'so'];
    dayNamesMin = ['ne', 'po', 'út', 'st', 'čt', 'pá', 'so'];
    monthNames = ['leden', 'únor', 'březen', 'duben', 'květen', 'červen', 'červenec', 'srpen', 'září', 'říjen', 'listopad', 'prosinec'];
    monthNamesShort = ['led', 'úno', 'bře', 'dub', 'kvě', 'čer', 'čvc', 'srp', 'zář', 'říj', 'lis', 'pro'];
    
}