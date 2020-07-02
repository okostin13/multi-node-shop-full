import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductDeleteButtonComponent } from './product-delete-button.component';

describe('ProductDeleteButtonComponent', () => {
  let component: ProductDeleteButtonComponent;
  let fixture: ComponentFixture<ProductDeleteButtonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductDeleteButtonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductDeleteButtonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
