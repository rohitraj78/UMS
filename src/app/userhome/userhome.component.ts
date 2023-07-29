import { Component ,OnInit} from '@angular/core';
import { RegistrationService } from '../registration.service';
import { Router } from '@angular/router';
import { User } from '../user';

@Component({
  selector: 'app-userhome',
  templateUrl: './userhome.component.html',
  styleUrls: ['./userhome.component.css']
})
export class UserhomeComponent implements OnInit 
{
  uid:any;
  lastlogintime:string;
  Date1 : Date = new Date();
  visible:boolean = false
  LocalDate : String = new Date().toLocaleString();
  user : User[] | undefined;
  constructor(private _service:RegistrationService, private _router :Router ){}
  currentuser:String;
  users=new User();

 
ngOnInit(){
  this._service.fetchUserListFromRemote().subscribe(
    data=>{console.log("response received");
    this.user=data;

    
  },

    error=>console.log("exception occured")
  )
  this.currentuser=localStorage.getItem('currentuser')?.toString();
  this.lastlogintime=localStorage.getItem('lastlogintime')?.toString();
  this.uid=localStorage.getItem('uid')?.toString();
  

 


  
}
goToLogin(){
  this._router.navigate(['/healthasyst/login']); 
}
viewUser(){
  this._router.navigate(['/healthasyst/viewuser']); 
}
userProfile(){
  this._router.navigate(['/healthasyst/viewprofile']); 
}

onclick(){
  this.visible = !this.visible
}

loginhistory(){
  this._router.navigate(['/healthasyst/loginhistory/'+this.uid]); 
  
}

}
