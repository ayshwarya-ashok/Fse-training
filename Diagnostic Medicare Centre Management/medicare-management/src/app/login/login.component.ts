import { Component, OnInit } from '@angular/core';
import { UserService } from '../site/user.service';

import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AuthserviceService } from '../site/authservice.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  username: any;
  password: any;
  loginStatus: boolean = false;
  signupStatus:boolean= false;
  isNotCustomer: boolean = false;
  anonymousMovieId: any;
  roleType: any;
  constructor(private userService: UserService, 
              private authService: AuthserviceService,
              private router: Router,
              private actRouter: ActivatedRoute) { }

  ngOnInit() {
    
    this.actRouter.paramMap.subscribe(params => {
      this.roleType = params.get('initialRole');
      this.loginForm=new FormGroup({
        'userName': new FormControl(this.username, [Validators.required]),
        'password': new FormControl(this.password, [Validators.required]),
      });
    });
  }
  login(loginForm){
    // this.loginStatus = this.loginService.checkCustomer(loginForm);
    // if(this.loginStatus){
    //   this.router.navigate(['movies-menu']);
    // }else{
    //   this.signupStatus = true;
    // }
    this.authService.authenticate(loginForm.value.userName, loginForm.value.password)
      .subscribe((response) => {
                                this.authService.setToken(response.token);
                                this.userService.setUserName(response.user);
                                this.userService.setRole(response.role);
                                this.authService.login();
                                if(this.roleType="doctor"){
                                  this.router.navigate(['doctor']);
                                }else if(this.roleType="customer"){
                                  this.router.navigate(['customer']);
                                }else{
                                  this.router.navigate(['admin']);
                                }
                              },
        (responseError) => {
                            this.isNotCustomer = true;
                           }
       );
   
  }
}
