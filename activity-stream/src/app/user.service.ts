import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';


import {User} from './user';

import { MessageService } from './message.service';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class UserService {

  private usersUrl = 'http://localhost:9001/alluser';
    // URL to web api

  constructor(private http: HttpClient) { }

  /** GET heroes from the server */
  getUsers(): Observable <User[]> {
//  this.messageService.add('UserService: fetched users');

      return this.http.get<User[]>(this.usersUrl)

  }



}
