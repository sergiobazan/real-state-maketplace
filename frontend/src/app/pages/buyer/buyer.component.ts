import { Component, signal } from '@angular/core';
import { Property } from '../home/models/Property';
import { BuyerService } from './buyer.service';
import { Buyer } from './models/Buyer';

@Component({
  selector: 'app-buyer',
  templateUrl: './buyer.component.html'
})
export class BuyerComponent {
  buyer: Buyer | null = null;

  properties = signal<Property[]>([]);

  constructor(private service: BuyerService) {}
  
  ngOnInit(): void {
    this.getBuyer();
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

  private getBuyer() {
    this.service.getBuyerData().subscribe({
      next: (response) => {
        this.buyer = response;
      },
      error: ({ error }) => console.error(error)
    })
  }
}
