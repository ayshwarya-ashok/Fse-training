import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../site/user.service';


@Component({
  selector: 'app-customer-signup',
  templateUrl: './customer-signup.component.html',
  styleUrls: ['./customer-signup.component.css']
})
export class CustomerSignupComponent implements OnInit {

  signupFormCustomer: FormGroup;
  userName: any;
  firstName: any;
  lastName: any;
  age: any;
  gender: any;
  dateOfBirth: any;
  contactNumber: any;
  altContactNumber:any;
  emailId:any;
  password: any;
  addressLine_1: any;
  addressLine_2: any;
  city: any;
  state: any;
  zipCode:any;
  existingUserStatus: boolean=false;
  roleType: any="customer";
  constructor(private userService : UserService,
              private router : Router) { }

  ngOnInit() {
    this.signupFormCustomer = new FormGroup({
      'userName': new FormControl(this.userName, [Validators.required, Validators.minLength(3), Validators.maxLength(10)]),
      'firstName': new FormControl(this.firstName, [Validators.required, Validators.minLength(3), Validators.maxLength(10)]),
      'lastName': new FormControl(this.lastName, [Validators.required, Validators.minLength(3), Validators.maxLength(20)]),
      'age': new FormControl(this.age, [Validators.required, Validators.minLength(2)]),
      'division': new FormGroup({
        'gender': new FormControl(this.gender, [Validators.required]),
      }),
      'dateOfBirth': new FormControl(this.dateOfBirth, [Validators.required, Validators.minLength(10)]),
      'contactNumber': new FormControl(this.contactNumber, [Validators.required, Validators.minLength(10)]),
      'altContactNumber': new FormControl(this.altContactNumber, [Validators.required, Validators.minLength(10)]),
      'emailId': new FormControl(this.emailId, [Validators.required, Validators.minLength(3), Validators.maxLength(50)]),
      'password': new FormControl(this.password, [Validators.required, Validators.minLength(3), Validators.minLength(5)]),
      'addressLine_1': new FormControl(this.addressLine_1, [Validators.required, Validators.minLength(3), Validators.maxLength(100)]),
      'addressLine_2': new FormControl(this.addressLine_2, [Validators.required, Validators.minLength(3), Validators.maxLength(100)]),
      'city': new FormControl(this.city, [Validators.required, Validators.minLength(3), Validators.maxLength(50)]),
      'state': new FormControl(this.state, [Validators.required, Validators.minLength(3), Validators.maxLength(50)]),
      'zipCode': new FormControl(this.zipCode, [Validators.required,  Validators.minLength(3), Validators.maxLength(10)]),
    });
  }
  signup(signupFormCustomer){
    let customer = {
      userName: signupFormCustomer.value.userName,
      firstName: signupFormCustomer.value.firstName,
      lastName: signupFormCustomer.value.lastName,
      age: signupFormCustomer.value.age,
      gender: signupFormCustomer.value.division.gender,
      dateOfBirth: signupFormCustomer.value.dateOfBirth,
      contactNumber: signupFormCustomer.value.contactNumber,
      altContactNumber: signupFormCustomer.value.altContatcNumber,
      emailId: signupFormCustomer.value.emailId,
      password: signupFormCustomer.value.password,
      addressLine_1: signupFormCustomer.value.addressLine_1,
      addressLine_2: signupFormCustomer.value.addressLine_2,
      city: signupFormCustomer.value.city,
      state: signupFormCustomer.value.state,
      zipCode: signupFormCustomer.value.zipCode
    };
    this.userService.setCustomerUser(customer)
      .subscribe((response) => {
        this.router.navigate(['/login',this.roleType]);
      },
        (responseError) => {
          if(responseError.error.mssg == "Existing user!"){
            this.existingUserStatus = true;
          }
      });
  }
}
