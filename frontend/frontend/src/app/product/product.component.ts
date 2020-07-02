import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import {Product} from '../dto/Product'
import { from } from 'rxjs';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  @Input()
  product: Product
  
  @Input()
  btnType:string

  @Output() onDelete = new EventEmitter()

  constructor() { }

  ngOnInit(): void {
    console.log(this.btnType)
  }

  delete() {
    this.onDelete.emit();
  }
}
