import { TestBed } from '@angular/core/testing';

import { UserManagementService } from './user-management.service';

/**
 * Developed by Group 6:
    Kenji Mark Alan Arceo
    Carl Norbi Felonia
    Ryonan Owen Ferrer
    Dino Alfred Timbol
    Mike Emil Vocal
 */

describe('UserManagementService', () => {
  let service: UserManagementService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserManagementService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
