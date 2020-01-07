import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InitialComponent } from './initial/initial.component';
import { CustomerSignupComponent } from './customer-signup/customer-signup.component';
import { LoginComponent } from './login/login.component';
import { DoctorSignupComponent } from './doctor-signup/doctor-signup.component';
import { AdminSignupComponent } from './admin-signup/admin-signup.component';



const routes: Routes = [
  {path: '', component: InitialComponent},
  {path: 'customer-signup', component: CustomerSignupComponent},
  {path: 'doctor-signup', component: DoctorSignupComponent},
  {path: 'admin-signup', component: AdminSignupComponent},
  {path: 'login/:initialRole', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
