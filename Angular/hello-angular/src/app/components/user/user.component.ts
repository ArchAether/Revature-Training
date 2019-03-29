import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import{ User} from '../../models/user.models';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  users: User[];
  test: string;
  constructor(private uService: UserService) {
    console.log("in User component constructor. Instantiating.");
    console.log(uService.name);
   }

  ngOnInit() {
    console.log("in User component ngOnInit");
    this.test = this.uService.test();
    this.loadUsers();
  }

  loadUsers(){
    this.uService.getUsers().subscribe(
      myRespBody => {                     //give it a name
        if(myRespBody != null && myRespBody.length >0){
            // We know we have users
            this.users = myRespBody;
            console.log("You got: Http Response!");
        }
        else {
          console.log("user list not populated");
        }
      },
      error => console.log("error")
    );
  }
}
