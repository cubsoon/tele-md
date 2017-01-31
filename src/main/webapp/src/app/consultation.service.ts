import { Injectable }    from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { Consultation } from './consultation';

@Injectable()
export class ConsultationService {
  private consultationsUrl = 'api/consultations';
  private headers = new Headers({'Content-Type': 'application/json'});

  constructor(private http: Http) { }

  getConsultations(): Promise<Consultation[]> {
    return this.http.get(this.consultationsUrl)
       .toPromise()
       .then(response => response.json().data as Consultation[])
       .catch(this.handleError);
  }

  getConsultation(id: number): Promise<Consultation> {
  	const url = `${this.consultationsUrl}/${id}`;
  	return this.http.get(url)
  		.toPromise()
    	.then(response => response.json().data as Consultation)
    	.catch(this.handleError);
  }

  createConsultation(title: string, desc: string): Promise<Consultation> {
    return this.http
      .post(this.consultationsUrl, JSON.stringify({title: title, desc: desc, lock: 'unlocked', date_of_creation: this.getCurrentDate()}), {headers: this.headers})
      .toPromise()
      .then(res => res.json().data)
      .catch(this.handleError);
  }

  createPost(consultation: Consultation): Promise<Consultation> {
  	const url = `${this.consultationsUrl}/${consultation.id}`;
    return this.http
      .put(url, JSON.stringify(consultation), {headers: this.headers})
      .toPromise()
      .then(() => consultation)
      .catch(this.handleError);
  }

  getCurrentDate() {
  	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1;
	var yyyy = today.getFullYear();
	var now = dd+'/'+mm+'/'+yyyy;
	return now;
  }

  private handleError(error: any): Promise<any> {
    return Promise.reject(error.message || error);
  }
}