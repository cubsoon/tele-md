import { Component, Input, OnInit } from '@angular/core';

import { Consultation } from './consultation';
import { ConsultationService } from './consultation.service';

@Component({
	selector: `consultation-list`,

	styles: [`
	  .consultations {
	    margin: 0 0 2em 0;
	    list-style-type: none;
	    padding: 0;
	    width: 50%;
	  }
	  .consultations li {
	    cursor: pointer;
	    position: relative;
	    left: 0;
	    background-color: #EEE;
	    margin: .5em;
	    padding: .3em .3em .3em;
	    height: 5%
	    border-radius: 4px;
	  }
	  .consultations li.selected:hover {
	    background-color: #BBD8DC !important;
	    color: white;
	  }
	  .consultations li:hover {
	    color: #607D8B;
	    background-color: #DDD;
	    left: .1em;
	  }
	  .consultations .text {
	    position: relative;
	    top: -3px;
	  }
	  .consultations .title {
	    display: inline-block;
	    font-size: 20px;
	    color: white;
	    padding: 0.8em 0.7em 0 0.7em;
	    background-color: #607D8B;
	    line-height: 1em;
	    position: relative;
	    left: -1px;
	    top: -4px;
	    height: 1.8em;
	    margin-right: .8em;
	    margin-top: .2em;
	    border-radius: 4px 4px 4px 4px;
	  }
	  .consultations .creator{
	  	display: inline-block;
	    font-size: 10px;
	    color: white;
	    padding: 0.8em 0.7em 0 0.7em;
	    background-color: #607D8B;
	    line-height: 1em;
	    position: relative;
	    left: -1px;
	    top: -4px;
	    height: 1.8em;
	    margin-right: .8em;
	    border-radius: 4px 4px 4px 4px;
	  }
	  .consultations .description{
	  	word-break: normal;
	  	display: block;
	  	margin: .5em .5em .8em .5em;
	  }
	  .consultations .date{
	  	display: inline-block;
	  	float: right;
	    font-size: 10px;
	    color: white;
	    padding: 0.8em 0.7em 0 0.7em;
	    background-color: #607D8B;
	    line-height: 1em;
	    position: relative;
	    left: -1px;
	    top: -4px;
	    height: 1.8em;
	    border-radius: 4px 4px 4px 4px;
	  }
	  .consultations .lockpad{
	  	float: right;
	  	display: inline-block;
	  	width:124px;
	  	height:72px;
	  }
	`],

	template: `
	<h2>Lista konsultacji</h2>
	  	<ul class="consultations">
	  		<li *ngFor= "let consultation of consultations">
	  			<span class="title">{{consultation.title}}</span>
	  			<img class="lockpad" src="{{consultation.lock}}.png" alt={{consultation.lock}}>
	  			<span class="description">Opis: {{consultation.desc}}</span>
	  			<span class="creator">Założył: {{consultation.creator_id}}</span>
	  			<span class="date">Data utworzenia: {{consultation.date_of_creation}}</span>
	  		</li>
	  	</ul>
	`
	})

export class ConsultationListComponent implements OnInit {
	consultations: Consultation[];

	constructor(private consultationService: ConsultationService) { }

	getConsultations(): void {
    	this.consultationService.getConsultations().then(consultations => this.consultations = consultations);
  	}

  	ngOnInit(): void {
    	this.getConsultations();
  	}
}