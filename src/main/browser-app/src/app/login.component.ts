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
	  	<div *ngIf="!auth.authenticated()">
		  	<p>Skorzystaj z przycisku aby się zalogować.</p>
			<p>
				<button class="btn btn-primary btn-margin" (click)="auth.login()">Zaloguj się</button>
			</p>
		</div>
		<p *ngIf="auth.authenticated()">Jesteś zalogowany, witaj!</p>
  	`
})

export class LoginViewComponent {
	constructor(private auth: Auth) {}
}