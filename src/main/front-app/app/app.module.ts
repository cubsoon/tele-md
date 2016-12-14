import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';

import { AppComponent }  from './app.component';
import { ConsultationListComponent } from './consultation-list.component';
import { ConsultationComponent } from './consultation.component'
import { LoginViewComponent } from './login.component';

import { ConsultationService } from './consultation.service';

import { AppRoutingModule } from './app-routing.module';

@NgModule({
  imports:      [
  BrowserModule, 
  FormsModule, 
  AppRoutingModule
  ],
  
  declarations: [
  AppComponent,
  ConsultationListComponent,
  ConsultationComponent,
  LoginViewComponent
  ],
  
  bootstrap:    [
  AppComponent
  ],
  
  providers: 	[
  ConsultationService
  ]
})

export class AppModule { }
