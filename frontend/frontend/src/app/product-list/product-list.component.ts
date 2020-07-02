import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import {ProductService} from '../product.service'
import { Product } from '../dto/Product';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  @Input()
  btnType:string

  _categoryId: number

  @Input()
  products: Product[] = []
  
  @Output() onDelete = new EventEmitter()
  
  @Input() 
  set categoryId(id: number){
    this._categoryId = id;
    this.getProducts()
  }
  get categoryId(): number{
    return this._categoryId;
  }


  constructor(private productService:ProductService) { }

  ngOnInit(): void {
  }

  private getProducts() {
    this.productService.getProductsByCategoryId(this._categoryId)
      .subscribe((products: Product[]) => this.products = products)
  }

  delete() {
    this.onDelete.emit()
  }

}
