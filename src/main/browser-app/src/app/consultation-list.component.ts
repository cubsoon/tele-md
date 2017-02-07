import { Component, Input, OnInit, AfterContentInit } from '@angular/core';

import { ConsultationListItemDto } from './interface/consultation-list-item-dto';
import { ConsultationService } from './consultation.service';

import { ConsultationListItemComponent } from './consultation-list-item.component'

@Component({
	selector: `consultation-list`,

	styles: [`
	  h2 {
	  	background-color: #b4c3cb;
	  	border-radius: 4px 4px 4px 4px;
		width: 50%;
	  }
	  a {
	  	color: black;
		text-decoration: none;
	  }
	  .consultations {
	    margin: 0 0 2em 0;
	    list-style-type: none;
	    padding: 0;
	    width: 50%;
	  }
	`],

	template: `
		<h2>Lista konsultacji</h2>
		<ul class="consultations">
			<consultation-list-item *ngFor="let consultation of consultations" [item]="consultation">
			</consultation-list-item>
		</ul>
	`
	})
export class ConsultationListComponent implements AfterContentInit {
	
	private consultations: ConsultationListItemDto[] = [];

	constructor(private consultationService: ConsultationService) { }

	getConsultations(): void {
			this.consultationService.getConsultations().then(result => {
				console.log("Response: ", result);
				this.consultations = result;
			});
  	}

	ngAfterContentInit(): void {
		this.getConsultations();
	}
}
