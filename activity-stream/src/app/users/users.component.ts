import { Component, Input,Output,EventEmitter } from '@angular/core';
import {User} from '../user';
import { MessageService } from '../message.service';
import {Message} from '../message';

@Component({
  selector: 'app-users',

  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent {

@Input()
users : User[] = [];

@Output() messages = new EventEmitter<Message[]>();

@Output() receiverId = new EventEmitter<string>();


msgs: Message[];

selectedUserID:string;

  constructor(public messageservice: MessageService) { }



  userMessage(emailId :string ):void{
    this.selectedUserID=emailId;
    console.log("ng oninit of usercomponent receiver id is "+this.selectedUserID);
this.selectedUser();
     this.messageservice.getMessageFromUser(emailId).subscribe(data => {
       this.msgs = data;
       this.messages.emit( this.msgs);
     })

  }

selectedUser():void{

this.receiverId.emit(this.selectedUserID);


}


}
