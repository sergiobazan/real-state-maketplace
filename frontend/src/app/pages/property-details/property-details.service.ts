import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Property } from '../home/models/Property';

@Injectable({
  providedIn: 'root'
})
export class PropertyDetailsService {
  private apiUrl = `${environment.apiUrl}/properties`;

  constructor(private http: HttpClient) { }

  getPropertyDetails(id: string) {
    return this.http.get<Property | null>(`${this.apiUrl}/${id}`)
  }
}
