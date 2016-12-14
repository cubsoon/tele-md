import { NgModule }      from '@angular/core';
import { RouterModule, Routes }   from '@angular/router';

import { ConsultationListComponent } from './consultation-list.component';
import { ConsultationComponent } from './consultation.component'
import { LoginViewComponent } from './login.component';

const routes: Routes = [
  { path: 'consultations', component: ConsultationListComponent },
  { path: 'detail/:id', component: ConsultationComponent }
]

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  
  exports: [ RouterModule ]
})

export class AppRoutingModule { }
