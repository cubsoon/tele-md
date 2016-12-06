import { Component, Input } from '@angular/core';

@Component({
  	selector: 'login-view',

  	styles: [`
  		form {
  			margin: 50px 0 0 20%;
  		}
  	`],

  	template: `
  		<form>
  	  	<label>Login:</label>
  	  	<input placeholder="Login"/>
  	  	<input type="submit" value="Zaloguj">
  	  	</form>
  	`
})

export class LoginViewComponent {
}