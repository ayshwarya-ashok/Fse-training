import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  role: string="";
  userName: string="anonymous";
  constructor(private httpClient: HttpClient) { }

  setCustomerUser(customer){
    return this.httpClient.post(environment.basicUrl+"signup-service/users/customer-signup",customer);
   }
  setDoctorUser(doctor){
    console.log(doctor);
    return this.httpClient.post(environment.basicUrl+"signup-service/users/doctor-signup",doctor);
  } 
  setAdminUser(admin){
    return this.httpClient.post(environment.basicUrl+"signup-service/users/admin-signup",admin);
  }
   setRole(role){
    this.role = role;
   }

   getRole(){
    return this.role;
   }

   setUserName(userName){
    this.userName = userName;
   }

   getUserName(){
    return this.userName;
   }

}
