import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { RequestService } from '../request.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
	userForm:any;
  doctorList: any;
  customerList: any;
  medicareList: any;
  requestList: any;
  deleteCustomer: any;
  deleteDoctor: any;
  doctorStatus: boolean = false;
  customerStatus: boolean = false;
  notificationStatus: boolean = false;
  medicareStatus: boolean = false;
  status: boolean = false;
  status1: boolean = false;
  status2: boolean = false;
  
  constructor(private adminService: AdminService, private requestService:RequestService ) { }

  ngOnInit() {
	  this.adminService.getAllDoctorsList()
    .subscribe((response)=>{
        this.doctorList = response;
         this.deleteDoctor = this.doctorList;
       
       console.log(this.doctorList);
});

 this.adminService.getAllCustomersList()
    .subscribe((response)=>{
        this.customerList = response;
         this.deleteCustomer = this.customerList;
        
       console.log(this.customerList);
});

this.adminService.getAllMedicare()
    .subscribe((response)=>{
        this.medicareList = response;
       console.log(this.medicareList);
});

 
  }
  rejectCustomer(username){
    console.log(username)
      this.deleteCustomer = this.customerList;
this.adminService.deleteCustomer(username)
    .subscribe((response)=>{       
        console.log(response)
       this.deleteCustomer =response;
         let length = this.deleteCustomer.length;
         console.log(length)
         if(length == 0) {
            this.status = true;
         }
});
}

rejectDoctor(userName){
     console.log(userName)
      this.deleteDoctor = this.doctorList;
this.adminService.deleteDoctor(userName)
    .subscribe((response)=>{
          this.deleteDoctor = response;
         let length = this.deleteDoctor.length;

         if(length == 0) {
            this.status1 = true;
         }
         console.log(length)
          console.log(response)
      
       
});
}
  notification() {
      this.requestService.adminViewRequest()
      .subscribe((response) => {
           this.doctorStatus = false;
          this.customerStatus = false;
          this.notificationStatus = true;
          this.medicareStatus = false;
          this.requestList = response;
          console.log(this.requestList);
      })
  }

  doctor() {
      this.doctorStatus = true;
      this.customerStatus = false;
      this.notificationStatus = false;
       this.medicareStatus = false;
      return this.doctorList;
  }

  customer() {
      this.doctorStatus = false;
      this.customerStatus = true;
      this.notificationStatus = false;
      this.medicareStatus = false;
    return this.customerList ;
  }
  medicare() {
     this.doctorStatus = false;
      this.customerStatus = false;
      this.notificationStatus = false;
      this.medicareStatus = true;
      return this.medicareList;
  }

}
