import { Component } from '@angular/core';

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
	  	padding: 1.5em 0.3em 0.9em 0.5em;
	  	margin-right: -1.0em;
	  	margin-top: -1.8em;
	  }
	  .logout:hover {
	  	background-color: #34444b
	  }
	  a {
	  	color: white;
	  	text-decoration: none;
	  	font-size: 17px;
	  }
	  .nav {
	  	padding: 1.5em 0.3em 1.15em 0.3em;
	  	margin-left: 1.5em;
	  }
	  .nav:hover {
	  	background-color: #34444b;
	  }
`],

  	template: `
  	<span class="top">{{title}}
  	<a class="nav" routerLink="/consultations">Lista konsultacji</a>
  	<a class="nav" routerLink="/new">Nowa konsultacja</a>
  	<a routerLink="/"><img class="logout" src="logout.png" alt="Wyloguj"></a></span>
    <router-outlet></router-outlet>
  	`,

  	
})

export class AppComponent {
	title = 'Telekonsultacje medyczne';
}
