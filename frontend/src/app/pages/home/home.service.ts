import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Property } from './models/Property';

@Injectable({
  providedIn: 'root'
})
export class HomeService {
  private url = `${environment.apiUrl}/properties`

  constructor(private http: HttpClient) { }

  getAllProperties() {
    return this.http.get<Property[]>(this.url);
  }
}
