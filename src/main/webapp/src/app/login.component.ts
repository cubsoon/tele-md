import { Component, Input } from '@angular/core';
import { Auth } from './auth.service';

@Component({
  	selector: 'login-view',

  	styles: [`
  		button {
  			margin: 50px 0 0 5%;
  		}
  	`],

  	template: `
  		<button class="btn btn-primary btn-margin" (click)="auth.login()" *ngIf="!auth.authenticated()">Log In</button>
  	`
})

export class LoginViewComponent {
	constructor(private auth: Auth) {}
}