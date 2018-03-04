import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Headers, RequestOptions } from '@angular/http';

import {Message} from './message';


@Injectable()
export class MessageService {
  messages: string[] = [];

  add(message: string) {
    this.messages.push(message);
  }

  clear() {
    this.messages = [];
  }


    private userMessageUrl = 'http://localhost:9003/messageFromUser/';
    private circleMessageUrl = 'http://localhost:9003/messageFromCircle/';
    private sendMessageUrl='http://localhost:9003/sendMessageToUser';

      // URL to web api

    constructor(private http: HttpClient) { }

    /** GET heroes from the server */
    getMessageFromUser(emailId:string): Observable <Message[]> {
  //  this.messageService.add('UserService: fetched users');
console.log("in msg service..."+emailId)

        return this.http.get<Message[]>(this.userMessageUrl+emailId+"/")

    }

    sendMessage(message:Message) {
  //  this.messageService.add('UserService: fetched users');
//  message="hello";

console.log("in msg service send...",message)
      return  this.http.post(this.sendMessageUrl,message)

    }

    getMessageFromCircle(circleId:string): Observable <Message[]> {
  //  this.messageService.add('UserService: fetched users');
console.log("in msg service"+circleId)
        return this.http.get<Message[]>(this.circleMessageUrl+circleId)

    }
}
