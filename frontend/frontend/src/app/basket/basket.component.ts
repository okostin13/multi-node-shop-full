import { Component, OnInit } from '@angular/core';
import { OrderService } from '../order.service';
import { Product } from '../dto/Product';
import { Order } from '../dto/Order';
import { ProductService } from '../product.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';


@Component({
  selector: 'app-basket',
  templateUrl: './basket.component.html',
  styleUrls: ['./basket.component.css']
})
export class BasketComponent implements OnInit {

  name: string
  
  address: string

  currentProducts:Product[]

  orders: Order[]
  
  productsForOrder:Map<number,Product[]> = new Map()

  constructor(private orderService: OrderService,
    private productService: ProductService,
    private modalService: NgbModal) { }

  ngOnInit(): void {
    this.refreshInfo()
  }

  getProductsForOrder(order:Order) {
    return order.items.forEach(item => {
      this.productService.getById(item.productId).subscribe(
        (product: Product) => {
          const productArr:Product[]= this.productsForOrder.get(order.id)
          if (productArr) {
            productArr.push(product)
            console.log(productArr)
          }else{
            this.productsForOrder.set(order.id,[product])
          }
          this.productsForOrder = this.productsForOrder
        }
      )
    })
  }

  refreshInfo() {
    console.log('here')
    this.currentProducts = this.orderService.getCurrentOrder()
    this.name = localStorage.getItem('name');
    if (this.name) {
      this.orderService.getOrdersByPurchaserName(this.name).subscribe((orders: []) => {
        this.orders = orders
        this.productsForOrder = new Map()
        orders.forEach(order => this.getProductsForOrder(order))
      })
    }
  }

  buy(name:string) {
    this.name = name
    localStorage.setItem('name',name)
    this.orderService.buy(name).subscribe(response => {
      localStorage.setItem('products','[]')
      this.refreshInfo()
    })
  }

  openModal(content) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      if (result != 'Cancel') {
        this.buy(result)
      }
    }, (reason) => {
      
    });
  }

}
