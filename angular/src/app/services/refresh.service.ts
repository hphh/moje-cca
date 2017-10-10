import {Inject, Injectable} from '@angular/core';
import {GlobalRefreshService} from "./global-refresh.service";
import 'rxjs/Rx';
import {Observable} from "rxjs/Observable";
import {Subscription} from "rxjs/Subscription";


@Injectable()
export class RefreshService {

  private refreshMethod: () => void;
  private refreshInterval: number;
  private refreshSubscription: Subscription;

  constructor(@Inject(GlobalRefreshService) private globalRefreshService: GlobalRefreshService) {
  }

  init(refreshMethod: () => void, refreshInterval: number) {
    this.refreshMethod = refreshMethod;
    this.refreshInterval = refreshInterval;

    this.subscribe();

    if (this.refreshMethod) {
      this.globalRefreshService.register(() => {
        this.refresh();
      });
    }
  }

  refresh() {
    this.unsubscribe();
    this.globalRefreshService.refreshStart(this);
    this.refreshMethod();
  }

  refreshFinished() {
    this.subscribe();
    this.globalRefreshService.refreshStop(this);
  }

  private subscribe() {
    if (!this.refreshMethod || !this.refreshInterval) {
      return;
    }

    this.unsubscribe();
    this.refreshSubscription = Observable.interval(this.refreshInterval).subscribe(() => {
      this.refresh();
    });
  }

  private unsubscribe() {
    if (this.refreshSubscription) {
      this.refreshSubscription.unsubscribe();
      this.refreshSubscription = null;
    }
  }

}
