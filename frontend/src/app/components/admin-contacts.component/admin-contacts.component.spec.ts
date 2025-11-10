import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminContactsComponent } from './admin-contacts.component';

/* Developed by Group 6:
    Kenji Mark Alan Arceo
    Carl Norbi Felonia
    Ryonan Owen Ferrer
    Dino Alfred Timbol
    Mike Emil Vocal */ 

describe('AdminContactsComponent', () => {
  let component: AdminContactsComponent;
  let fixture: ComponentFixture<AdminContactsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AdminContactsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminContactsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
