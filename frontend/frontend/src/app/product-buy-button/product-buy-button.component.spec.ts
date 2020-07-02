import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductBuyButtonComponent } from './product-buy-button.component';

describe('ProductBuyButtonComponent', () => {
  let component: ProductBuyButtonComponent;
  let fixture: ComponentFixture<ProductBuyButtonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductBuyButtonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductBuyButtonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
