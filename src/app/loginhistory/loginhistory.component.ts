import { Component,OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import { User } from '../user';
@Component({
  selector: 'app-loginhistory',
  templateUrl: './loginhistory.component.html',
  styleUrls: ['./loginhistory.component.css']
})
export class LoginhistoryComponent implements OnInit{
  id:any;
  loginhistory:any;
  user=new User();
  currentuser:string;
  usertype:any;
constructor(private _service: RegistrationService,private route:ActivatedRoute,private _route:Router,)
{

}
ngOnInit(){
  
  this.id=this.route.snapshot.params['id'];
  this.getOne();
  this.currentuser=localStorage.getItem('currentuser')?.toString();
  this.usertype=localStorage.getItem('usertype')?.toString();
}
getOne(){

  this._service.fetchLoginHistoryByIdFromRemote(this.id).subscribe
  (
    data=>{  
  console.log("response received");
  this.loginhistory=data;
 
  console.log(this.loginhistory);
    },
    error =>{
      console.log("exception occured");
      
    }
  )

}
goTohome(){
  


if(this.usertype=="Admin"){
  this._route.navigate(['/healthasyst/adminhome'])
}else if(this.usertype=="User"){
  this._route.navigate(['/healthasyst/userhome'])
}
}
}
