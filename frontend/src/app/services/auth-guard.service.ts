import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import { TokenStorageService } from './token-storage.service';
import { Router } from '@angular/router';

/**
 * Developed by Group 6:
    Kenji Mark Alan Arceo
    Carl Norbi Felonia
    Ryonan Owen Ferrer
    Dino Alfred Timbol
    Mike Emil Vocal
 */

/**
 * Service class for auth guard operations (prohibits non-logged users from accessing a page)
 */

@Injectable({
  providedIn: 'root'
})
export class AuthGuard {

  constructor(
    private authService: AuthService,
    private router: Router,
    private tokenStorageService: TokenStorageService
  ) {}

  canActivate(): boolean {
    if (this.tokenStorageService.getToken()) {
      return true;
    }
    else {
      this.router.navigate(['/login']);
      return false;
    }
  }

}
