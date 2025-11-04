import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OurPawlsComponent } from './our-pawls.component';

describe('OurPawlsComponent', () => {
  let component: OurPawlsComponent;
  let fixture: ComponentFixture<OurPawlsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OurPawlsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OurPawlsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
