import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { AuthserviceService } from '../site/authservice.service';
import { RequestService } from '../request.service';
import { UserService } from '../site/user.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
doctorList: any;
medicareList: any;
user: string;
  constructor(private customerService: CustomerService,  
              private requestService: RequestService,
              private userService : UserService) { }

  ngOnInit() {
	  this.customerService.getAllDoctorsList()
    .subscribe((response)=>{
        this.doctorList = response;
       console.log(this.doctorList);
});

this.customerService.getAllMedicare()
    .subscribe((response)=>{
        this.medicareList = response;
       console.log(this.medicareList);
});
  }
  request(id){
    let request = {
      "customerName":this.userService.getUserName,
	    "mediServiceId ": id,
	    "active" : 0
    }
    this.requestService.addRequest(request);
  }
}
