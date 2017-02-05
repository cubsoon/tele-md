import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule, Http, RequestOptions } from '@angular/http';
import { MaterialModule } from '@angular/material'
import { provideAuth, AuthHttp, AuthConfig }      from 'angular2-jwt';

import { AppComponent } from './app.component';

import { ConsultationListComponent } from './consultation-list.component';
import { ConsultationListItemComponent } from './consultation-list-item.component';
import { ConsultationComponent } from './consultation.component'
import { LoginViewComponent } from './login.component';
import { NewConsultationComponent } from './new-consultation.component'
import { PlayareaComponent } from './playarea/playarea.component'

import { ConsultationService } from './consultation.service';
import { PlayareaService } from './playarea/playarea.service';

import { Auth } from './auth.service';

import { AppRoutingModule } from './app-routing.module';

//import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
//import { InMemoryDataService }  from './in-memory-data.service';

export function authHttpServiceFactory(http: Http, options: RequestOptions) {
  return new AuthHttp( new AuthConfig({}), http, options);
}

@NgModule({
  declarations: [
    AppComponent,
    ConsultationListComponent,
    ConsultationListItemComponent,
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
    //InMemoryWebApiModule.forRoot(InMemoryDataService)
  ],
  providers: [
    Auth,
    ConsultationService,
    PlayareaService,
    {
      provide: AuthHttp,
      useFactory: authHttpServiceFactory,
      deps: [ Http, RequestOptions ]
    }
   ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
