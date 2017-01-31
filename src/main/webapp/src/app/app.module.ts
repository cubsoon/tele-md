import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';

import { ConsultationListComponent } from './consultation-list.component';
import { ConsultationComponent } from './consultation.component'
import { LoginViewComponent } from './login.component';
import { NewConsultationComponent } from './new-consultation.component'
import { PlayareaComponent } from './playarea/playarea.component'

import { ConsultationService } from './consultation.service';
import { PlayareaService } from './playarea/playarea.service';

import { AppRoutingModule } from './app-routing.module';

import { InMemoryWebApiModule } from 'angular-in-memory-web-api'; //fake http
import { InMemoryDataService }  from './in-memory-data.service';  //fake http

@NgModule({
  declarations: [
    AppComponent,
    ConsultationListComponent,
    ConsultationComponent,
    LoginViewComponent,
    NewConsultationComponent,
    PlayareaComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    InMemoryWebApiModule.forRoot(InMemoryDataService) //fake http
  ],
  providers: [
    ConsultationService,
    PlayareaService
   ],
  bootstrap: [
    AppComponent
  ]
})

export class AppModule { }
