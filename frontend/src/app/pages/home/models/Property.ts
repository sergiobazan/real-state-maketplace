export interface Property {
  id: string
  title: string
  description: string
  price: number
  address: Address
  measures: string
  imageUrl: string
  type: string
  status: string
  category: Category
  seller: Seller
}

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
