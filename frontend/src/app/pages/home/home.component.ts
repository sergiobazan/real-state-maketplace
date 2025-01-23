import { Component, OnInit, signal } from '@angular/core';
import { Property } from './models/Property';
import { HomeService } from './home.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html'
})
export class HomeComponent implements OnInit {
  properties = signal<Property[]>([]);

  constructor(private service: HomeService) {}
  
  ngOnInit(): void {
    this.getProperties();
  }

  private getProperties() {
    this.service.getAllProperties().subscribe({
      next: (response) => {
        this.properties.update((_) => response);
      },
      error: ({error}) => console.error(error)
    })
  }
}
