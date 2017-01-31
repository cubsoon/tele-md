import { Component, Input, OnInit } from '@angular/core';
import { Router }   from '@angular/router';

import { Consultation } from './consultation';
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
      <input #consultationTitle type="text" name="title"><td>
      <label>Opis:</label></td>
      <textarea #consultationDesc rows="5" cols="60" name="content"></textarea><td>
      <button (click)="add(consultationTitle.value, consultationDesc.value); consultationTitle.value=''; consultationDesc.value=''">Stwórz sesję</button>
    </div>
  	`
})

export class NewConsultationComponent implements OnInit {
  consultations: Consultation[];

  constructor(
    private consultationService: ConsultationService,
    ) { }

  getConsultations(): void {
      this.consultationService.getConsultations().then(consultations => this.consultations = consultations);
    }

  ngOnInit(): void {
    this.getConsultations();
  }

  add(title: string, desc: string): void {
    title = title.trim();
    desc = desc.trim();
    if (!title) { return; }

    this.consultationService.createConsultation(title, desc)
      .then(consultation => {
        this.consultations.push(consultation);
    });
  }
}