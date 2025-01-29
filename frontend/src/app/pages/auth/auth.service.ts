import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { LoginRequest, LoginResponse, RegisterRequest } from './models/AuthRequest';
import { jwtDecode } from "jwt-decode";
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = environment.apiUrl;
  private isAuthenticatedSubject = new BehaviorSubject<boolean>(this.hasToken());
  isAuthenticated$ = this.isAuthenticatedSubject.asObservable();

  constructor(private http: HttpClient, private router: Router) { }

  login(request: LoginRequest) {
    return this.http.post<LoginResponse>(`${this.apiUrl}/login`, request);
  }

  register(request: RegisterRequest) {
    return this.http.post<RegisterRequest>(`${this.apiUrl}/register`, request);
  }

  userRoles() {
    const token = localStorage.getItem('token');
    if (!token) throw new Error("Token not found");

    const decoded: any = jwtDecode(token);

    return decoded.ROLES;
  }

  logout() {
    localStorage.removeItem('token');
    this.isAuthenticatedSubject.next(false);
    this.router.navigate(['/login']);
  }

  private hasToken(): boolean {
    return !!localStorage.getItem('token');
  }

  notifyLogin() {
    this.isAuthenticatedSubject.next(true);
  }
}
