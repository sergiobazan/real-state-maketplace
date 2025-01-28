import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PropertyDetailsService } from './property-details.service';
import { Property } from '../home/models/Property';

@Component({
  selector: 'app-property-details',
  templateUrl: './property-details.component.html'
})
export class PropertyDetailsComponent implements OnInit {
  id: string | null = '';
  property: Property | null = null;

  constructor(private service: PropertyDetailsService, private router: ActivatedRoute) {}
  
  ngOnInit(): void {
    this.id = this.router.snapshot.paramMap.get("id");
    this.getPropertyDetails();
  }

  private getPropertyDetails() {
    if (!this.id) return;

    this.service.getPropertyDetails(this.id).subscribe({
      next: (response) => {
        this.property = response;
      },
      error: ({ error }) => console.error(error)
    })
  }
}
