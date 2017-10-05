import { Injectable } from '@angular/core';

declare const Notification: any;
export type Permission = 'denied' | 'granted' | 'default';

@Injectable()
export class NotificationService {

    constructor() { }

    private canNotify(): boolean {
        if ( !( 'Notification' in window ) ) {
            return false;
        }

        Notification.requestPermission();

        return Notification.permission !== 'denied';
    }

    notify( text: string ) {
        if ( !this.canNotify() ) {
            return;
        }

        const n = new Notification(
            'Moje CCA',
            {
                body: text,
                icon: 'favicon.png',
                requireInteraction: true
            } );

        n.onclick = ( e: any ) => {
            n.close();
        };
        n.onerror = ( e: any ) => {
            console.log( 'chyba při zobrazení notifikace ' );
            console.log( e );
        };
    }



}
