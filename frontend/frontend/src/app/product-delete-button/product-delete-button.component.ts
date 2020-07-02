import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { OrderService } from '../order.service';
import { Product } from '../dto/Product';

@Component({
  selector: 'app-product-delete-button',
  templateUrl: './product-delete-button.component.html',
  styleUrls: ['./product-delete-button.component.css']
})
export class ProductDeleteButtonComponent implements OnInit {

  @Input()
  product: Product
  
  @Output() onDelete = new EventEmitter()

  constructor(private orderService:OrderService) { }

  ngOnInit(): void {
  }

  delete() {
    this.orderService.deleteFromBucket(this.product)
    this.onDelete.emit();
  }

}
