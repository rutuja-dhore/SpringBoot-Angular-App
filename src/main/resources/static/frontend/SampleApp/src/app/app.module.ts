import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule, Http } from '@angular/http';

import { AppComponent } from './app.component';

import { UserService } from './user.service';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
