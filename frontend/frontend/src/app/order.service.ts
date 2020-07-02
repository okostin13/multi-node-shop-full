import { Injectable } from '@angular/core';
import { Product } from './dto/Product';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { empty, of } from "rxjs";
import { Order } from './dto/Order';
import { Item } from './dto/Item';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private orderUrl = 'http://localhost:8080/order'

  constructor(private http: HttpClient) { }

  addToBucket(product: Product) {
    const productsJson = localStorage.getItem('products') ? localStorage.getItem('products') : '[]'
    const products = JSON.parse(productsJson)
    products.push(product)
    localStorage.setItem('products', JSON.stringify(products))
  }

  getCurrentOrder(): Product[] {
    const productsJson = localStorage.getItem('products') ? localStorage.getItem('products') : '[]'
    return JSON.parse(productsJson)
  }

  deleteFromBucket(product: Product) {
    const productsJson = localStorage.getItem('products') ? localStorage.getItem('products') : '[]'
    let products: Product[] = JSON.parse(productsJson)
    products = products.filter(item => item.id != product.id)
    localStorage.setItem('products', JSON.stringify(products))
  }

  buy(name:string) {
    const productsJson = localStorage.getItem('products') ? localStorage.getItem('products') : '[]'
    const products:Product[] = JSON.parse(productsJson)
    const order: Order = new Order()
    order.purchaserName = name
    order.items = products.map(product => {
      const item: Item = new Item();
      item.productId = product.id
      return item
    })
    return this.http.post(this.orderUrl, order)
  }

  getOrdersByPurchaserName(name:string) {
      return this.http.get(`${this.orderUrl}?purchaserName=${name}`)
  }
}
