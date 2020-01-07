import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { environment } from 'src/environments/environment';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class AuthserviceService {
  loginStatus: boolean= false;
  private authenticationApiUrl = environment.basicUrl+'authentication-service/authenticate';
  private token: string;

  constructor(private httpClient: HttpClient,
              private userService: UserService) { }

  authenticate(user: string, password: string): Observable<any>{
    let credentials = btoa(user+":"+password);
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Basic '+credentials);
    return this.httpClient.get(this.authenticationApiUrl, {headers});
  }

  public setToken(token){
    this.token = token;
  }

  public getToken(){
    return this.token;
  }

  login(){
    this.loginStatus = true;
   }
   
   logout(){
     this.userService.setRole('ananymous');
     this.loginStatus = false;
     this.setToken(null);
   }
  }
