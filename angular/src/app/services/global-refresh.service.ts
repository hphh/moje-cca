import { Injectable } from '@angular/core';
import {Subject} from "rxjs/Subject";

@Injectable()
export class GlobalRefreshService {

  private refresher = new Subject();
  private activeRefreshers = new Set<any>();

  constructor() { }

  register(refreshFnc: () => void) {
    this.refresher.subscribe(refreshFnc);
  }

  globalRefresh() {
    this.refresher.next();
  }

  refreshStart(refresher) {
    this.activeRefreshers.add(refresher);
  }

  refreshStop(refresher) {
    this.activeRefreshers.delete(refresher);
  }

  isRefresing() {
    return this.activeRefreshers.size > 0;
  }
}
