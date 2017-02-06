import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Params }   from '@angular/router';
import { Location }                 from '@angular/common';

import { ConsultationDto } from './interface/consultation-dto';
import { PostDto } from './interface/post-dto';
import { ImageDto } from './interface/image-dto';
import { ConsultationService } from './consultation.service';
import { AttachmentService } from './attachment.service';

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
        <label>Dodano dnia: </label>{{consultation.created.timestamp}}
        <label> przez: </label>{{consultation.created.user?.username}}
		{{consultation.description}}
      </div>

      <ul class="posts">
	  		<li *ngFor="let post of consultation.posts">
		  		<span class="content">{{post.content}}</span>
		  		<span *ngIf="!!post.image" class="image"><img [src]="getPostImageUrl(post)"/></span><td>
		  		<span class="creator">{{post.added.user?.username}}</span>
	  		</li>
	  </ul>

	  <div class="posts">
	  	<label>Nowy post</label><td>
	  	<textarea #postContent rows="5" cols="60" name="content"></textarea></td>
	  	<input (change)="onImageSelected($event)" type="file" name="img" accept="image/*">
	  </div>

	  <button (click)="add(postContent.value); postContent.value=''">Dodaj post</button>
      <button (click)="goBack()">Wróć</button>
    </div>
	`
})
export class ConsultationComponent implements OnInit {

  private consultation: ConsultationDto;

  private image: ImageDto;

	constructor(
		private consultationService: ConsultationService,
		private attachmentService: AttachmentService,
		private route: ActivatedRoute,
    	private location: Location
		) { }

  	ngOnInit(): void {
    	this.route.params
    		.switchMap((params: Params) => this.consultationService.getConsultation(params['id']))
    		.subscribe(consultation => this.consultation = consultation);
		this.image = new ImageDto();
  	}

	getPosts() {
		this.consultationService.getPosts(this.consultation.id).then(result => this.consultation.posts = result)
	}

	getPostImageUrl(post: PostDto) {
		return this.attachmentService.getAttachmentUrl(post.image.attachmentId);
	}

  	goBack(): void {
  		this.location.back();
	}

	onImageSelected(event) {
		console.debug("Image selection changed.", event);
		let files = event.target.files;
		if (!!files && !!files[0]) {
			this.attachmentService.postAttachment(files[0]).then(result => {
				this.image.attachmentId = result.id;
				this.image.title = files[0].name;
				console.debug("Image uploaded.", this.image);
			});
		} else {
			this.image = new ImageDto();
			console.debug("Image removed.", this.image);
		}
	}

	add(content: string): void {
		var newPost = new PostDto();
		newPost.content = content;
		newPost.image = new ImageDto();
		newPost.image.attachmentId = this.image.attachmentId;
		newPost.image.title = this.image.title;

	  	this.consultationService.createPost(this.consultation.id, newPost).then(() => this.getPosts());
	}
}
