import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { LoginRequest } from '../models/AuthRequest';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent {
  loginRequest: LoginRequest = {
    email: '',
    password: ''
  }

  constructor(private service: AuthService, private router: Router) {}

  onSubmit() {
    this.service.login(this.loginRequest).subscribe({
      next: (response) => {
        localStorage.setItem('token', response.token);
        this.router.navigate(['/']);
      },
      error: ({ error }) => console.error(error)
    })
  }
}
