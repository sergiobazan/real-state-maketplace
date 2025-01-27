import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html'
})
export class HomeComponent implements OnInit {
  roles: String[] = [];
  
  constructor(private auth: AuthService) {}
  
  ngOnInit(): void {
    this.getUserRoles();
  }

  getUserRoles() {
    this.roles = this.auth.userRoles();
  }
}
