import { Component, Input } from '@angular/core';

@Component({
  	selector: 'login-view',

  	styles: [`
  		form {
  			margin: 50px 0 0 12%;
  		}
  	`],

  	template: `
  		<form name="loginForm" action="/consultations" method="get" ng-controller="LoginController" ng-submit="login(credentials)" novalidate>

  			<label for="username">Login:</label>
  			<input type="text" id="username" ng-model="credentials.username">

  			<label for="password">Hasło:</label>
  			<input type="password" id="password" ng-model="credentials.password">
			
			<button type="submit">Zaloguj</button>

		</form>
  	`
})

export class LoginViewComponent {
}