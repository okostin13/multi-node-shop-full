import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BasketComponent } from './basket/basket.component';
import { CategoryListComponent } from './category-list/category-list.component';


const routes: Routes = [
  {path:'',component:CategoryListComponent},
  {path:'basket',component:BasketComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
