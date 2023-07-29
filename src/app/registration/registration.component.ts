import { Component,OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from '../user';
import { RegistrationService } from '../registration.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
user=new User();
msg='';

constructor(private _service: RegistrationService,private _router:Router)
{


}
currentuser:string;

ngOnInit(){
  this.currentuser=localStorage.getItem('currentuser')?.toString();
                                                                       
}
registerUser(){
  this._service.registerUserFromRemote(this.user).subscribe
(
  data=>{

  //   this._service.loginRegisterUserFromRemote(this.user).subscribe
  //   (
  //     data=>{
        
  //   console.log("response received");},
  //   error =>{
  //     console.log("exception occured");
  //     this.msg="user with this EmailID is already exist";
  //   }
  // )

    
console.log("response received");



this.msg="Registration Successsful";
alert("Registered Succesfully");
this._router.navigate(['/healthasyst/userlist']);
                                                   
  },
  error =>{
    console.log("exception occured");
    this.msg="user with this EmailID is already exist";
  }
)}
goTohome(){
  this._router.navigate(['/healthasyst/adminhome']);
}
}
