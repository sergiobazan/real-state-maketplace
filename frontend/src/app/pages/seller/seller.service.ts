import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Category, Property, Seller } from '../home/models/Property';

@Injectable({
  providedIn: 'root'
})
export class SellerService {
  private url = `${environment.apiUrl}/properties`

  constructor(private http: HttpClient) { }

  getAllCategories() {
    return this.http.get<Category[]>(this.url + '/categories');
  }

  createProperty(request: any) {
    return this.http.post<Property>(this.url, request);
  }

  getSeller() {
    return this.http.get<Seller | null>(`${environment.apiUrl}/sellers/me`)
  }
}
