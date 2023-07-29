import { Component, OnInit } from '@angular/core';
import { RegistrationService } from '../registration.service';
import { Router } from '@angular/router';
import { User } from '../user';
@Component({
  selector: 'app-adminhome',
  templateUrl: './adminhome.component.html',
  styleUrls: ['./adminhome.component.css']
})
export class AdminhomeComponent implements OnInit{

  Date1 : Date = new Date();
  visible:boolean = false
  LocalDate : String = new Date().toLocaleString();
  

constructor(private _service:RegistrationService, private _router :Router){
  
}
lastlogintime:string;
currentuser:string;
uid:any;
ngOnInit(){
  this.currentuser=localStorage.getItem('currentuser')?.toString();
  this.lastlogintime=localStorage.getItem('lastlogintime')?.toString();
  this.uid=localStorage.getItem('uid')?.toString();
}

goToAddUser(){
  this._router.navigate(['/healthasyst/register']);
  
}
viewUser(){
  this._router.navigate(['/healthasyst/userlist']);
  
}
goToLogin(){
  this._router.navigate(['/healthasyst/login']); 
}
onclick(){
  this.visible = !this.visible
}
loginhistory(){
  this._router.navigate(['/healthasyst/loginhistory/'+this.uid]); 
  
}
}
