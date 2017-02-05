import { Component, Input, OnInit } from '@angular/core';
import { Router }   from '@angular/router';

import { ConsultationCreationDto } from './interface/consultation-creation-dto';
import { ConsultationService } from './consultation.service';

@Component({
  	selector: 'new-consultation',

  	styles: [`
    div {
      display: inline-block;
      margin-top: 5%;
      margin-left: 15%;
      background-color: #EEE;
      border-radius: 4px 4px 4px 4px;
      padding: .5em .5em .5em .5em;
    }
  	`],

  	template: `
    <div>
      <label>Tytuł:</label>
      <input [(ngModel)]="consultation.title" type="text" required><td>
      <label>Opis:</label></td>
      <textarea [(ngModel)]="consultation.description" rows="5" cols="60" name="content"></textarea><td>
      <button (click)="add()">Stwórz sesję</button>
    </div>
  	`
})

export class NewConsultationComponent {

  constructor(private consultationService: ConsultationService) { }

  private consultation: ConsultationCreationDto = new ConsultationCreationDto();
  private working: boolean = false;

  add(): void {
       
    if (!this.consultation.title || this.working) { 
      return; 
    }

    this.working = true;

    this.consultationService.createConsultation(this.consultation)
      .then(() => this.working = false);
  }
}