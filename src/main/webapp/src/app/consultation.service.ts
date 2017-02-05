import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';
import { AuthHttp } from 'angular2-jwt';

import 'rxjs/add/operator/toPromise';

import { Consultation } from './consultation'
import { ConsultationListItemDto } from './interface/consultation-list-item-dto';

class consultationDTO {
  title: string;
  description: string;
  privacy: string;
}

@Injectable()
export class ConsultationService {
  private consultationsUrl = '/api/consultation';
  private headers = new Headers({ 'Content-Type': 'application/json' });

  private consult = new consultationDTO();

  constructor(private http: AuthHttp) { }

  getConsultations(): Promise<Consultation[]> {
    return this.http.get(this.consultationsUrl)
      .toPromise()
      .then(response => (response.json().data as ConsultationListItemDto[]).map(dto => dto.toConsultation()))
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
    this.consult.description = desc;
    this.consult.title = title;
    this.consult.privacy = 'privacy';
    return this.http
      //.put(this.consultationsUrl, JSON.stringify({title: title, description: desc, lock: 'unlocked', date_of_creation: this.getCurrentDate()}), {headers: this.headers})
      .put(this.consultationsUrl, this.consult)
      .toPromise()
      .then(res => res.json().data)
      .catch(this.handleError);
  }

  createPost(consultation: Consultation): Promise<Consultation> {
    const url = `${this.consultationsUrl}/${consultation.id}`;
    return this.http
      .put(url, JSON.stringify(consultation), { headers: this.headers })
      .toPromise()
      .then(() => consultation)
      .catch(this.handleError);
  }

  getCurrentDate() {
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1;
    var yyyy = today.getFullYear();
    var now = dd + '/' + mm + '/' + yyyy;
    return now;
  }

  private handleError(error: any): Promise<any> {
    return Promise.reject(error.message || error);
  }
}