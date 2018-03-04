  import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { UsersComponent } from './users/users.component';
import { CircleComponent } from './circle/circle.component';
import { MessageComponent } from './message/message.component';

import { MessageService } from './message.service';
import { UserService } from './user.service';
import { CircleService } from './circle.service';
import { HttpClientModule }    from '@angular/common/http';
import { CirclecreationComponent } from './circlecreation/circlecreation.component';

@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    CircleComponent,
    MessageComponent,
    CirclecreationComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,HttpClientModule
  ],
  providers: [ UserService, MessageService, CircleService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
