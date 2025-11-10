import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';
import { TokenStorageService } from './token-storage.service';

/**
 * Developed by Group 6:
    Kenji Mark Alan Arceo
    Carl Norbi Felonia
    Ryonan Owen Ferrer
    Dino Alfred Timbol
    Mike Emil Vocal
 */

/**
 * Service class for admin guard operations (prohibits users that are not admin from accessing a page)
 */

@Injectable({
  providedIn: 'root'
})
export class AdminGuard implements CanActivate {

  constructor(
    private tokenStorageService: TokenStorageService,
    private router: Router
  ) {}

  canActivate(): boolean {
    const token = this.tokenStorageService.getToken();
    const role = this.tokenStorageService.getUserRole();
    
    if (token && role === 'ADMIN') {
      return true;
    } else {
      this.router.navigate(['/home']);
      return false;
    }
  }
}