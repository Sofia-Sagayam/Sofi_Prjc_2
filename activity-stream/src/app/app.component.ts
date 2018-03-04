import { Component} from '@angular/core';
import {User} from './user';
import{UserService} from './user.service';
import {Circle} from './circle';
import {Message} from './message';

import{CircleService} from './circle.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],

})
export class AppComponent {
  title = 'activity stream app';

  users: User[];
  circles:Circle[];
messages:Message[];

receiverId:string;

  constructor(private userservice: UserService,private circleservice:CircleService){}

  ngOnInit() {

this.getUsers();
this.getCircles();
  }
receiverIdOnSelect(receiverId:string){
    console.log("in app comp ts.."+receiverId);
  this.receiverId=receiverId;
}
  onMessages(messages: Message[]) {
     this.messages = messages;

   }

  getUsers():void{
    console.log("ng oninit");
      this.userservice.getUsers().subscribe(users => this.users = users);
  }

  getCircles():void{
    console.log("ng oninit");
      this.circleservice.getCircles().subscribe(circles => this.circles = circles);
  }

}
