import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../site/user.service';

@Component({
  selector: 'app-admin-signup',
  templateUrl: './admin-signup.component.html',
  styleUrls: ['./admin-signup.component.css']
})
export class AdminSignupComponent implements OnInit {

  signupFormAdmin: FormGroup;
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
  roleType: any="admin";
  existingUserStatus: boolean=false;
  constructor(private router: Router,
              private userService: UserService) { }

  ngOnInit() {

    this.signupFormAdmin = new FormGroup({
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
      'password': new FormControl(this.password, [Validators.required, Validators.minLength(3), Validators.minLength(5)])
    });
  }
  signup(signupFormAdmin){
    let admin = {
      userName: signupFormAdmin.value.userName,
      firstName: signupFormAdmin.value.firstName,
      lastName: signupFormAdmin.value.lastName,
      age: signupFormAdmin.value.age,
      gender: signupFormAdmin.value.division.gender,
      dateOfBirth: signupFormAdmin.value.dateOfBirth,
      contactNumber: signupFormAdmin.value.contactNumber,
      altContactNumber: signupFormAdmin.value.altContatcNumber,
      emailId: signupFormAdmin.value.emailId,
      password: signupFormAdmin.value.password
    };
    this.userService.setAdminUser(admin)
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
