import { Component, OnInit } from '@angular/core';
import { UserDTO } from './dtos/userDTO';
import { UserService } from './user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  private users: UserDTO[];

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.userService.findAll().subscribe(data => {
      this.users = data;
    }, error => {
      console.log('error' + error);
    });
  }
}
