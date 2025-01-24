import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Property } from '../home/models/Property';

@Injectable({
  providedIn: 'root'
})
export class BuyerService {
  private url = `${environment.apiUrl}/properties`

  constructor(private http: HttpClient) { }

  getAllProperties() {
    return this.http.get<Property[]>(this.url);
  }
}
