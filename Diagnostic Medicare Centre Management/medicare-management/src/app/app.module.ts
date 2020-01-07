import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { Pipe, PipeTransform } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { InitialComponent } from './initial/initial.component';
import { CustomerSignupComponent } from './customer-signup/customer-signup.component';
import { LoginComponent } from './login/login.component';
import { DoctorSignupComponent } from './doctor-signup/doctor-signup.component';
import { AdminSignupComponent } from './admin-signup/admin-signup.component';
import { HeaderComponent } from './header/header.component';
import { DoctorComponent } from './doctor/doctor.component';
import { AdminComponent } from './admin/admin.component';
import { CustomerComponent } from './customer/customer.component';



@NgModule({
  declarations: [
    AppComponent,
    InitialComponent,
    CustomerSignupComponent,
    LoginComponent,
    DoctorSignupComponent,
    AdminSignupComponent,
    HeaderComponent,
    DoctorComponent,
    AdminComponent,
    CustomerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
