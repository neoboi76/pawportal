import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminDogsComponent } from './admin-dogs.component';

/* Developed by Group 6:
    Kenji Mark Alan Arceo
    Carl Norbi Felonia
    Ryonan Owen Ferrer
    Dino Alfred Timbol
    Mike Emil Vocal */ 

describe('AdminDogsComponent', () => {
  let component: AdminDogsComponent;
  let fixture: ComponentFixture<AdminDogsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AdminDogsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminDogsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
