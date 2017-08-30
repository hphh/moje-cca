import { Injectable } from '@angular/core';
import 'rxjs/add/operator/map';
import { ApplicationService } from './application.service';
import { VykazPrace } from '../model/vykaz-prace';
import { SplittingVykazPrace } from '../model/splitting-vykaz-prace';
import { VykazPraceFilterParameters } from '../model/vykaz-prace-filter-parameters';
import { ConfirmVykazPracesParameters } from '../model/confirm-vykaz-praces-parameters';
import { CallBackendService } from './call-backend.service';
import { ZakazkaFilterParameters } from '../model/zakazka-filter-parameters';
import { Zakazka } from '../model/zakazka';
import { ZakazkaPolozka } from '../model/zakazka-polozka';
import { ZakazkaPozice } from '../model/zakazka-pozice';
import { ZakazkaPozicesFilterParameters } from '../model/zakazka-pozices-filter-parameters';
import { ZakazkaPolozkasFilterParameters } from '../model/zakazka-polozkas-filter-parameters';
import { MoveDayVykazPracesParameters } from '../model/move-day-vykaz-praces-parameters';


@Injectable()
export class VykazPraceService {

    private readonly ROOT_PATH = '/imis/vykazPrace';

    constructor(
        private callBackendService: CallBackendService,
        private applicationService: ApplicationService ) {
    }

    getVykazPraces(
        params: VykazPraceFilterParameters,
        successCallback?: ( data: VykazPrace[] ) => void,
        finishCallback?: ( success: boolean ) => void ): void {

        this.callBackendService.post(
            this.ROOT_PATH + '/vykazPraces',
            params,
            successCallback,
            finishCallback );
    }

    saveOrUpdateVykazPraces( vykazPraces: VykazPrace[],
        successCallback?: () => void,
        finishCallback?: ( success: boolean ) => void ): void {

        this.callBackendService.post(
            this.ROOT_PATH + '/saveOrUpdateVykazPraces',
            vykazPraces,
            successCallback,
            finishCallback );

    }

    splitVykazPrace(
        oldVykazPrace: VykazPrace, newVykazPrace: VykazPrace,
        successCallback?: () => void,
        finishCallback?: ( success: boolean ) => void ): void {

        let splittingVykazPrace = new SplittingVykazPrace();
        splittingVykazPrace.oldVykazPrace = oldVykazPrace;
        splittingVykazPrace.newVykazPrace = newVykazPrace;

        this.callBackendService.post(
            this.ROOT_PATH + '/splitVykazPrace',
            splittingVykazPrace,
            successCallback,
            finishCallback );

    }

    confirmVykazPraces(
        fromDate: number, toDate: number,
        successCallback?: () => void,
        finishCallback?: ( success: boolean ) => void ): void {

        let params = new ConfirmVykazPracesParameters();
        params.fromDate = fromDate;
        params.toDate = toDate;
        params.kodUzivatele = this.applicationService.kodUzivatele;

        this.callBackendService.post(
            this.ROOT_PATH + '/confirmVykazPraces',
            params,
            successCallback,
            finishCallback );
    }

    getZakazkas(
        params: ZakazkaFilterParameters,
        successCallback?: ( data: Zakazka[] ) => void,
        finishCallback?: ( success: boolean ) => void ) {

        this.callBackendService.post(
            this.ROOT_PATH + '/zakazkas',
            params,
            successCallback,
            finishCallback );
    }

    getZakazkaPolozkas( params: ZakazkaPolozkasFilterParameters,
        successCallback?: ( data: ZakazkaPolozka[] ) => void,
        finishCallback?: ( success: boolean ) => void ) {

        this.callBackendService.post(
            this.ROOT_PATH + '/zakazkaPolozkas',
            params,
            successCallback,
            finishCallback );
    }

    getZakazkaPozices( params: ZakazkaPozicesFilterParameters,
        successCallback?: ( data: ZakazkaPozice[] ) => void,
        finishCallback?: ( success: boolean ) => void ) {

        this.callBackendService.post(
            this.ROOT_PATH + '/zakazkaPozices',
            params,
            successCallback,
            finishCallback );
    }

    moveDayVykazPraces( params: MoveDayVykazPracesParameters,
        successCallback?: () => void,
        finishCallback?: ( success: boolean ) => void ) {

        this.callBackendService.post(
            this.ROOT_PATH + '/moveDayVykazPraces',
            params,
            successCallback,
            finishCallback );
    }

    deleteVykazPraces( vykazPraces: VykazPrace[],
        successCallback?: () => void,
        finishCallback?: ( success: boolean ) => void ) {

        this.callBackendService.post(
            this.ROOT_PATH + '/deleteVykazPraces',
            vykazPraces,
            successCallback,
            finishCallback );
    }
}
