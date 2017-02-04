import { Component } from '@angular/core';
import { Auth } from './auth.service';

@Component({
  	selector: 'my-app',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private auth: Auth) {}
	title = 'Telekonsultacje medyczne';
}
