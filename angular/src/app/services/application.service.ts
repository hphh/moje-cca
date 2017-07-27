import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';

@Injectable()
export class ApplicationService {
    
  backendServicesUrl: string = environment.backendServicesUrl;  

  kodUzivatele: string = 'HER';

  constructor() { }

}
