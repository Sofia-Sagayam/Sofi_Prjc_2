import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';


import {Circle} from './circle';

import { MessageService } from './message.service';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class CircleService {

  private circleUrl = 'http://localhost:9002/allCircles';  // URL to web api

  constructor(private http: HttpClient,private messageService: MessageService) { }

  /** GET heroes from the server */
  getCircles(): Observable <Circle[]> {
//  this.messageService.add('CircleService: fetched circles');

      return this.http.get<Circle[]>(this.circleUrl)

  }

}
