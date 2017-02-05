import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';
import { AuthHttp } from 'angular2-jwt';

import 'rxjs/add/operator/toPromise';

import { ConsultationDto } from './interface/consultation-dto';
import { ConsultationListItemDto } from './interface/consultation-list-item-dto';
import { ConsultationCreationDto } from './interface/consultation-creation-dto';

import { PostDto } from './interface/post-dto';

@Injectable()
export class ConsultationService {
  private consultationsUrl = '/api/consultation';
  private headers = new Headers({ 'Content-Type': 'application/json' });

  constructor(private http: AuthHttp) { }

  getConsultations(): Promise<ConsultationListItemDto[]> {
    return this.http.get(this.consultationsUrl)
      .toPromise()
      .then(response => response.json() as ConsultationListItemDto[])
      .catch(this.handleError);
  }

  getConsultation(consultationId: string): Promise<ConsultationDto> {
    let url = `${this.consultationsUrl}/${consultationId}`;
    return this.http.get(url)
      .toPromise()
      .then(response => response.json() as ConsultationDto)
      .catch(this.handleError);
  }

  getPosts(consultationId: string): Promise<PostDto[]> {
    let url = `${this.consultationsUrl}/${consultationId}/post`;
    return this.http.get(url)
      .toPromise()
      .then(response => response.json() as PostDto[])
      .catch(this.handleError);
  }

  createConsultation(consultation: ConsultationCreationDto): Promise<void> {
    return this.http.put(this.consultationsUrl, consultation)
      .toPromise()
      .then(res => { })
      .catch(this.handleError);
  }

  createPost(consultationId: string, post: PostDto): Promise<void> {
    let url = `${this.consultationsUrl}/${consultationId}/post`;
    return this.http.put(url, post)
      .toPromise()
      .then(result => { })
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