import { Injectable }    from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { Action } from './action';

@Injectable()
export class PlayareaService {

  constructor(private http: Http) { }

  fetchNewActions(consultationId: string, lastActions: Action[]): Promise<Action[]> {
    const url = `/consultation/${consultationId}/newActions`;
    return this.http.post(url, lastActions)
      .toPromise()
      .then(response => response.json().data as Action[])
      .catch(this.handleError);
  }

  sendNewAction(consultationId: string, action: Action): Promise<Action> {
    const url = `/consultation/${consultationId}/newActions`;
    return this.http.put(url, action)
      .toPromise()
      .then(response => response.json().data as Action)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    return Promise.reject(error.message || error);
  }
}
