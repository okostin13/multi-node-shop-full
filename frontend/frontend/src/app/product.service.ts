import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { Category } from "./dto/Category";


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private productUrl = 'http://localhost:8080/'

  constructor(private http: HttpClient) { }

  public getAllCategories() {
    return this.http.get(`${this.productUrl}category`);
  }

  public getProductsByCategoryId(id: number) {
    return this.http.get(`${this.productUrl}product?categoryId=${id}`);
  }

  public getById(id: number) {
    return this.http.get(`${this.productUrl}product/${id}`);
  }
}
