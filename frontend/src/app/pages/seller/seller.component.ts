import { Component, OnInit, signal } from '@angular/core';
import { SellerService } from './seller.service';
import { Category, PropertyRequest, PropertyStatus, PropertyType } from '../home/models/Property';
import { Seller } from './models/Seller';

@Component({
  selector: 'app-seller',
  templateUrl: './seller.component.html'
})
export class SellerComponent implements OnInit {
  seller: Seller | null = null;
  
  categories = signal<Category[]>([]);
  
  selectedFile: File | null = null;
  
  propertyRequest = signal<PropertyRequest>({
    title: '',
    description: '',
    address: {
      city: '',
      street: '',
      zipCode: ''
    },
    categoryId: '',
    measures: '',
    price: 0,
    sellerId: '',
    status: PropertyStatus.AVAILABLE,
    type: PropertyType.DEPARTMENT
  });

  constructor(private service: SellerService) {}
 
  ngOnInit(): void {
    this.getSeller();
    this.getAllCategories();
  }

  handleFile(event: Event) {
    const input = event.target as HTMLInputElement;
    if (input.files?.[0]) {
      this.selectedFile = input.files[0];
    }
  }

  onSubmit() {
    if (!this.seller) return;

    const formData = new FormData();
    formData.append('title', this.propertyRequest().title)
    formData.append('description', this.propertyRequest().description)
    formData.append('price', String(this.propertyRequest().price))
    formData.append('street', this.propertyRequest().address.street)
    formData.append('city', this.propertyRequest().address.city)
    formData.append('zipCode', this.propertyRequest().address.zipCode)
    formData.append('measures', this.propertyRequest().measures)
    formData.append('type', this.propertyRequest().type)
    formData.append('status', this.propertyRequest().status)
    formData.append('categoryId', this.propertyRequest().categoryId)
    formData.append('sellerId', this.seller.id)
    if (this.selectedFile) {
      formData.append('image', this.selectedFile)
    }
      

    this.service.createProperty(formData).subscribe({
      next: (response) => {
        this.propertyRequest.update(_ => ({
          title: '',
          description: '',
          address: {
            city: '',
            street: '',
            zipCode: ''
          },
          categoryId: '',
          measures: '',
          price: 0,
          sellerId: '',
          status: PropertyStatus.AVAILABLE,
          type: PropertyType.DEPARTMENT
        }))
      },
      error: ({ error }) => console.error(error)
    })
    
  }

  private getSeller() {
    this.service.getSeller().subscribe({
      next: (response) => {
        this.seller = response;
      },
      error: ({ error }) => console.error(error)
    })
  }

  private getAllCategories() {
    this.service.getAllCategories().subscribe({
      next: (response) => this.categories.update(_ => response),
      error: ({ error }) => console.error(error)
    })
  }
}
