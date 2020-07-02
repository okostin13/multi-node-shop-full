import { Component, OnInit, Input } from '@angular/core';
import { Product } from '../dto/Product';
import {OrderService} from '../order.service'
import { from } from 'rxjs';

@Component({
  selector: 'app-product-buy-button',
  templateUrl: './product-buy-button.component.html',
  styleUrls: ['./product-buy-button.component.css']
})
export class ProductBuyButtonComponent implements OnInit {

  @Input()
  product:Product

  constructor(private orderService:OrderService) { }

  ngOnInit(): void {
  }

  add() {
    this.orderService.addToBucket(this.product)
  }

}
