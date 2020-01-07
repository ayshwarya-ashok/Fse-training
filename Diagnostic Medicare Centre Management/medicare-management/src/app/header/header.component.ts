import { Component, OnInit } from '@angular/core';
import { AuthserviceService } from '../site/authservice.service';
import { Router } from '@angular/router';
import { UserService } from '../site/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  userType: string;
  userName: string="";

  constructor(private authService: AuthserviceService, 
              private router: Router,
              private userService: UserService) { }

  ngOnInit() {
  }
  getUserName(){
    this.userName = this.userService.getUserName();
    return this.userName;
  }

  getUserType(){
    this.userType = this.userService.getRole();
    return this.userType;
  }
  
  logout(){
    this.authService.logout();
    this.router.navigate(['']);
  }
}
