import { Component, signal } from '@angular/core';
import { Property } from '../home/models/Property';
import { BuyerService } from './buyer.service';

@Component({
  selector: 'app-buyer',
  templateUrl: './buyer.component.html'
})
export class BuyerComponent {
  properties = signal<Property[]>([]);

  constructor(private service: BuyerService) {}
  
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
