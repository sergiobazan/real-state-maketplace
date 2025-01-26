import { Component, OnInit } from '@angular/core';
import { HomeService } from './home.service';
import { User } from './models/User';
import { AuthService } from '../auth/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html'
})
export class HomeComponent implements OnInit {
  user: User | null = null;
  roles: String[] = [];
  
  constructor(private service: HomeService, private auth: AuthService) {}
  
  ngOnInit(): void {
    this.getUserData();
    this.getUserRoles();
  }

  getUserData() {
    this.service.me().subscribe({
      next: (response) => {
        this.user = response;
      },
      error: ({ error }) => console.error(error)
    })
  }

  getUserRoles() {
    this.roles = this.auth.userRoles();
  }

  isSeller() {
    return this.roles.includes('SELLER');
  }

  isBuyer() {
    return this.roles.includes('BUYER');
  }
}
