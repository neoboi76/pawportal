// admin.guard.ts
import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';
import { TokenStorageService } from './token-storage-service';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminGuard implements CanActivate {

  constructor(
    private tokenStorageService: TokenStorageService,
    private router: Router
  ) {}

  canActivate(): Observable<boolean> {
    const user$ = this.tokenStorageService.getUser();
    
    return user$.pipe(
      map((user: any) => {
        if (user && user.role === 'ADMIN') {
          return true;
        } else {
          this.router.navigate(['/home']);
          return false;
        }
      })
    );
  }
}