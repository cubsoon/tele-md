import { NgModule }      from '@angular/core';
import { RouterModule, Routes }   from '@angular/router';

import { ConsultationListComponent } from './consultation-list.component';
import { ConsultationComponent } from './consultation.component'
import { LoginViewComponent } from './login.component';
import { NewConsultationComponent } from './new-consultation.component'
import { PlayareaComponent } from './playarea/playarea.component';

const routes: Routes = [
  { path: '', component: LoginViewComponent },
  { path: 'consultations', component: ConsultationListComponent },
  { path: 'detail/:id', component: ConsultationComponent },
  { path: 'playarea/:id', component: PlayareaComponent },
  { path: 'new', component: NewConsultationComponent}
]

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],

  exports: [ RouterModule ]
})

export class AppRoutingModule { }
