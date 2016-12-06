import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';

import { AppComponent }  from './app.component';
import { ConsultationListComponent } from './consultation-list.component';
import { LoginViewComponent } from './login.component';

import { ConsultationService } from './consultation.service';

@NgModule({
  imports:      [ BrowserModule, FormsModule ],
  declarations: [ AppComponent, ConsultationListComponent, LoginViewComponent],
  bootstrap:    [ AppComponent ],
  providers: 	[ ConsultationService ]
})
export class AppModule { }
