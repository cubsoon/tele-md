import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { tokenNotExpired } from 'angular2-jwt';

declare var Auth0Lock: any;

@Injectable()
export class Auth {
	
		lock = new Auth0Lock('ewlp50CvDGJ2odNKSstDKWhIbNBVVCcw', 'jakub-k.eu.auth0.com', {});

		constructor(private router: Router) {
		this.lock.on("authenticated", (authResult) => {
			localStorage.setItem('id_token', authResult.idToken);
			this.redirect();
		});
	}

		public login() {
			this.lock.show();
		}

		public authenticated() {
			return tokenNotExpired();
		}

		public logout() {
			localStorage.removeItem('id_token');
		}

	  	private redirect() {
			let REDIRECT_URL_KEY = 'redirect_url';
			if (!!localStorage.getItem(REDIRECT_URL_KEY)) {
				this.router.navigateByUrl(localStorage.getItem(REDIRECT_URL_KEY))
					.then(result => localStorage.removeItem(REDIRECT_URL_KEY));
			}
		}
}