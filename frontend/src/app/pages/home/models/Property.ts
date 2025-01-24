export interface Property {
  id: string
  title: string
  description: string
  price: number
  address: Address
  measures: string
  imageUrl: string
  type: PropertyType
  status: PropertyStatus
  category: Category
  seller: Seller
}

export type PropertyRequest = Omit<Property, 'id' | 'category' | 'seller' | 'imageUrl'> & {
  categoryId: string
  sellerId: string
};

export interface Address {
  city: string
  street: string
  zipCode: string
}

export interface Category {
  id: string
  name: string
  description: string
}

export interface Seller {
  id: string
  name: string
  email: string
}

export enum PropertyType {
  DEPARTMENT = 'DEPARTMENT',
  HOUSE = 'HOUSE'
}

export enum PropertyStatus {
  AVAILABLE = 'AVAILABLE',
  SOLD = 'SOLD'
}