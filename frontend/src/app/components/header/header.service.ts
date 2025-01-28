import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from 'src/app/pages/home/models/User';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class HeaderService {
  private apiUrl = `${environment.apiUrl}`

  constructor(private http: HttpClient) { }

  getUser() {
    return this.http.get<User | null>(`${this.apiUrl}/me`);
  }
}
