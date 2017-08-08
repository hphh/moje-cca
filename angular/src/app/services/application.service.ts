import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { PrimengCzLocale } from '../config/primeng-cz-locale';

@Injectable()
export class ApplicationService {
    
  backendServicesUrl: string = environment.backendServicesUrl;  
  kodUzivatele: string = environment.kodUzivatele;

  primengCzLocale = PrimengCzLocale.INSTANCE;

  constructor() { }

}
