import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { LoginRequest, LoginResponse, RegisterRequest } from './models/AuthRequest';
import { jwtDecode } from "jwt-decode";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) { }

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
}
