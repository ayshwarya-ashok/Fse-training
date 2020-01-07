import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

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

      getAllCustomersList():Observable<any>{

    
        let token = 'Bearer '+this.authService.getToken();
        const httpOptions ={
          headers: new HttpHeaders({
            'Content-Type': 'application/json',
            'Authorization': token
          })
        };
        
        return this.httpClient.get("http://localhost:8088/customers", httpOptions);
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

  deleteDoctor(userName):Observable<any>{

    
        let token = 'Bearer '+this.authService.getToken();
        const httpOptions ={
          headers: new HttpHeaders({
            'Content-Type': 'application/json',
            'Authorization': token
          })
        };
        
        return this.httpClient.delete("http://localhost:8088/removeDoctor-signup/"+userName, httpOptions);
  }

   deleteCustomer(username):Observable<any>{

    
        let token = 'Bearer '+this.authService.getToken();
        const httpOptions ={
          headers: new HttpHeaders({
            'Content-Type': 'application/json',
            'Authorization': token
          })
        };
        
        return this.httpClient.delete("http://localhost:8088/removePatient-signup/"+username, httpOptions);
  }
}
