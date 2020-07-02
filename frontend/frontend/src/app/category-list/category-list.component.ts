import { Component, OnInit } from '@angular/core';
import {ProductService} from '../product.service'
import { Category } from '../dto/Category';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {

  constructor(private productService: ProductService) { }

  categories: Category[]
  
  selectedCategoryId:number

  ngOnInit(): void {
    this.productService.getAllCategories().subscribe(
      (categories: Category[]) => this.categories = categories
    )
  }

  selectCategory(id: number) {
    this.selectedCategoryId = id;
  }


}
