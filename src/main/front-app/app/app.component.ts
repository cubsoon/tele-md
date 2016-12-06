import { Component } from '@angular/core';

import { Consultation } from './consultation';

@Component({
  	selector: 'my-app',
  	
  	styles: [`
	  .selected {
	    background-color: #CFD8DC !important;
	    color: white;
	  }
	  .top {
	    display: block;
	    font-size: 25px;
	    color: white;
	    padding: 0.8em 0.7em 0 0.7em;
	    background-color: #607D8B;
	    line-height: 1em;
	    height: 1.8em;
	    margin: -.31em;
	    width: 50%;
	  }
	  .logout {
	  	height: 35px;
	  	width: 35px;
	  	float: right;
	  }
`],

  	template: `
  	<span class="top">{{appname}}
  	<img class="logout" src="logout.png" alt="Wyloguj"></span>
  	<consultation-list></consultation-list>
  	`,

  	
})

export class AppComponent {
	appname = 'Telekonsultacje medyczne';
	
}
//<login-view></login-view>