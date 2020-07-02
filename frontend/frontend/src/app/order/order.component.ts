import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  @Input()
  products

  @Input()
  orderId: number

  @Input()
  btnType:string

  @Output() onDelete = new EventEmitter()
  
  constructor() { }

  ngOnInit(): void {
  }


  delete() {
    this.onDelete.emit()
  }

}
