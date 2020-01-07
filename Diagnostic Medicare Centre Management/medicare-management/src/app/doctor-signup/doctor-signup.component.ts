import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../site/user.service';


@Component({
  selector: 'app-doctor-signup',
  templateUrl: './doctor-signup.component.html',
  styleUrls: ['./doctor-signup.component.css']
})
export class DoctorSignupComponent implements OnInit {

  signupFormDoctor: FormGroup;
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
  degree: any;
  speciality: any;
  workHours: any;
  hospitalName: any;
  medicareServiceId: any;
  medicareSericesArray: any;
  existingUserStatus: boolean=false;
  roleType: any="doctor";
  constructor(private router: Router,
              private userService: UserService) { }

  ngOnInit() {
    this.signupFormDoctor = new FormGroup({
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
      'degree': new FormControl(this.degree, [Validators.required,  Validators.minLength(3), Validators.maxLength(10)]),
      'speciality': new FormControl(this.speciality, [Validators.required,  Validators.minLength(3), Validators.maxLength(10)]),
      'divWorkHrs': new FormGroup({
        'workHours': new FormControl(this.workHours, [Validators.required])
      }),
      'hospitalName': new FormControl(this.hospitalName, [Validators.required,  Validators.minLength(3), Validators.maxLength(50)])
    });
  }
  signup(signupFormDoctor){
    let doctor = {
      userName: signupFormDoctor.value.userName,
      firstName: signupFormDoctor.value.firstName,
      lastName: signupFormDoctor.value.lastName,
      age: signupFormDoctor.value.age,
      gender: signupFormDoctor.value.division.gender,
      dateOfBirth: signupFormDoctor.value.dateOfBirth,
      contactNumber: signupFormDoctor.value.contactNumber,
      altContactNumber: signupFormDoctor.value.altContatcNumber,
      emailId: signupFormDoctor.value.emailId,
      password: signupFormDoctor.value.password,
      addressLine_1: signupFormDoctor.value.addressLine_1,
      addressLine_2: signupFormDoctor.value.addressLine_2,
      city: signupFormDoctor.value.city,
      state: signupFormDoctor.value.state,
      zipCode: signupFormDoctor.value.zipCode,
      degree: signupFormDoctor.value.degree,
      speciality: signupFormDoctor.value.speciality,
      workHours: signupFormDoctor.value.divWorkHrs.workHours,
      hospitalName: signupFormDoctor.value.hospitalName
    };
   
    this.userService.setDoctorUser(doctor)
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
