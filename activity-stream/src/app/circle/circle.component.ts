import { Component, Input,Output,EventEmitter } from '@angular/core';
import {Circle} from '../circle';
import { MessageService } from '../message.service';

import {Message} from '../message';

@Component({
  selector: 'app-circle',
  templateUrl: './circle.component.html',
  styleUrls: ['./circle.component.css']
})
export class CircleComponent  {
  @Input()
  circles : Circle[] = [];

  @Output() messages = new EventEmitter<Message[]>();
  msgs: Message[];

  constructor(public messageservice: MessageService) { }



  circleMessage(circleId :string ):void{
    console.log("circle .ts ng oninit");
     this.messageservice.getMessageFromCircle(circleId).subscribe(data => {
       this.msgs = data;
       this.messages.emit( this.msgs);
     })

  }

}
