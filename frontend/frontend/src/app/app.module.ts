import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductListComponent } from './product-list/product-list.component';
import { BasketComponent } from './basket/basket.component';
import { ProductComponent } from './product/product.component';
import { CategoryListComponent } from './category-list/category-list.component';
import { OrderComponent } from './order/order.component';
import { HeaderComponent } from './header/header.component';
import { ProductBuyButtonComponent } from './product-buy-button/product-buy-button.component';
import { ProductDeleteButtonComponent } from './product-delete-button/product-delete-button.component';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    BasketComponent,
    ProductComponent,
    CategoryListComponent,
    OrderComponent,
    HeaderComponent,
    ProductBuyButtonComponent,
    ProductDeleteButtonComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    CommonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
