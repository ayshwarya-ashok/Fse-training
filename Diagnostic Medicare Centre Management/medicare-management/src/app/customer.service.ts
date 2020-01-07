import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private httpClient:HttpClient,private authService:AuthService) { }
  getAllDoctorsList():Observable<any>{

    
            let token = 'Bearer '+this.authService.getToken();
            const httpOptions ={
              headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': token
              })
            };
            
            return this.httpClient.get("http://localhost:8088/doctors", httpOptions);
      }

    getAllMedicare():Observable<any>{

    
        let token = 'Bearer '+this.authService.getToken();
        const httpOptions ={
          headers: new HttpHeaders({
            'Content-Type': 'application/json',
            'Authorization': token
          })
        };
        
        return this.httpClient.get("http://localhost:8088/medicare-services", httpOptions);
  }
}
