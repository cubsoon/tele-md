import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Params }   from '@angular/router';
import { Location }                 from '@angular/common';

import { Consultation } from './consultation';
import { ConsultationService } from './consultation.service';

import 'rxjs/add/operator/switchMap';

@Component({
	selector: `consultation`,

	styles: [`

	`],

	template: `
    <div *ngIf= "consultation">
      <h2>{{consultation.title}}</h2>
      <div>
        <label>id: </label>{{consultation.id}}
        <label>Data utworzenia: </label>{{consultation.date_of_creation}}
      </div>
      <button (click)="goBack()">Wróć</button>
    </div>
	`
	})

export class ConsultationComponent implements OnInit {
	@Input() consultation: Consultation;

	constructor(
		private consultationService: ConsultationService,
		private route: ActivatedRoute,
  		private location: Location
		) { }

  	ngOnInit(): void {
    	this.route.params
    		.switchMap((params: Params) => this.consultationService.getConsultation(+params['id']))
    		.subscribe(consultation => this.consultation = consultation);
  	}

  	goBack(): void {
  		this.location.back();
}
}