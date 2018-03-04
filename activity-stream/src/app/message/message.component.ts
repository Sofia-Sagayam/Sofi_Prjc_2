import { HttpClient, HttpHeaders } from '@angular/common/http';
import {User} from '../user';

import { Component,Input} from '@angular/core';
import {Message} from '../message';
import { MessageService } from '../message.service';
import { UsersComponent } from '../users/users.component';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class MessageComponent   {

  @Input()
  messages : Message[] = [];

  @Input()
  receiverId : string;

status:string;

message : Message;
ngOnInit() {

}

constructor(public messageservice: MessageService) {
  console.log("in msg component..."+this.receiverId)

 }

  sendMessage(messageContent :string){
    console.log("sending"+messageContent+""+this.receiverId)
    this.message=new Message();
    this.message.messageContent=messageContent;
    this.message.receiverId=this.receiverId;
  //  this.message.receiverId=this.userComponent.selectedUser();
     this.messageservice.sendMessage(this.message).subscribe(data => {
      alert('status : ' + this.status);
     }   )

  }
  clearFeilds(){
    (<HTMLInputElement>document.getElementById('msgbox')).value = "";
  }

}
