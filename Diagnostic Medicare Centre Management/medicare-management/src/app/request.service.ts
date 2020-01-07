import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthserviceService } from './site/authservice.service';


@Injectable({
  providedIn: 'root'
})
export class RequestService {

  constructor(private httpClient:HttpClient,private authService:AuthserviceService) { }
  addRequest(request):Observable<any>{
            let token = 'Bearer '+this.authService.getToken();
            const httpOptions ={
              headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': token
              })
            };
            
            return this.httpClient.post("http://localhost:8088/request",request, httpOptions);
      }

       adminViewRequest():Observable<any>{
            let token = 'Bearer '+this.authService.getToken();
            const httpOptions ={
              headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': token
              })
            };
            
            return this.httpClient.get("http://localhost:8088/adminViewRequest", httpOptions);
      }
}
