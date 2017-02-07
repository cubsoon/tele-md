import { NgModule }      from '@angular/core';
import { RouterModule, Routes }   from '@angular/router';

import { ConsultationListComponent } from './consultation-list.component';
import { ConsultationComponent } from './consultation.component'
import { LoginViewComponent } from './login.component';
import { NewConsultationComponent } from './new-consultation.component'
import { PlayareaComponent } from './playarea/playarea.component';

import { AuthGuard } from './auth.guard';

const routes: Routes = [
  { path: '', component: LoginViewComponent },
  { path: 'consultations', component: ConsultationListComponent, canActivate: [AuthGuard] },
  { path: 'detail/:id', component: ConsultationComponent, canActivate: [AuthGuard] },
  { path: 'playarea/:id', component: PlayareaComponent, canActivate: [AuthGuard] },
  { path: 'new', component: NewConsultationComponent, canActivate: [AuthGuard] },
  { path: '**', redirectTo: '' }
]

export const appRoutingProviders: any[] = [
  AuthGuard
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }


