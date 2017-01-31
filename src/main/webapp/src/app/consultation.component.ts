import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Params }   from '@angular/router';
import { Location }                 from '@angular/common';

import { Consultation } from './consultation';
import { Post } from './post';
import { ConsultationService } from './consultation.service';

import 'rxjs/add/operator/switchMap';

@Component({
	selector: `consultation`,

	styles: [`
	.title {
		background-color: #EEE;
		border-radius: 4px 4px 4px 4px;
		width: 50%;
	}
	.title h2 {
		margin-bottom: 0;
		background-color: #b4c3cb;
		border-radius: 4px 4px 4px 4px;
	}
	.posts {
	    margin: 0 0 2em 0;
	    list-style-type: none;
	    padding: 0;
	    width: 50%;
	}
	.posts li {
	    position: relative;
	    left: 0;
	    background-color: #EEE;
	    margin: .5em;
	    padding: .3em .3em .3em;
	    height: 5%;
	    border-radius: 4px;
	}
	.posts .creator {
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
	.posts .content {
		word-break: normal;
	  	display: inline-block;
	  	margin: .5em .5em .8em .5em;
	}
	.posts .image {
		display: inline-block;
	  	float: right;
	    padding: 0.2em 0.2em 0.2em 0.2em;
	    background-color: #607D8B;
	    position: relative;
	    border-radius: 4px 4px 4px 4px;
	}
	`],

	template: `
    <div *ngIf= "consultation">
      <div class="title">
      	<h2>{{consultation.title}}</h2>
        <label>Dodano dnia: </label>{{consultation.date_of_creation}}
        <label> przez: </label>{{consultation.creator_id}}
      </div>

      <ul class="posts">
	  		<li *ngFor="let post of consultation.posts">
		  		<span class="content">{{post.content}}</span>
		  		<span class="image">TU BEDZIE ZDJECIE</span><td>
		  		<span class="creator">{{post.creator_id}}</span>
	  		</li>
	  </ul>

	  <div class="posts">
	  	<label>Nowy post</label><td>
	  	<textarea #postContent rows="5" cols="60" name="content"></textarea></td>
	  	<input type="file" name="img" accept="image/*">
	  </div>

	  <button (click)="add(postContent.value); postContent.value=''">Dodaj post</button>
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

	add(content: string): void {
	  	content = content.trim();
	 	if (!content) { return; }
	 	var newPost = new Post;
	 	newPost.content = content;
	 	this.consultation.posts.push(newPost);
	  	this.consultationService.createPost(this.consultation);
	}
}
