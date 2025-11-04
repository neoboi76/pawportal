// app.ts
import { Component } from '@angular/core';
import { Router, RouterOutlet, NavigationEnd } from '@angular/router';
import { CommonModule } from '@angular/common';
import { filter } from 'rxjs/operators';
import { NavbarComponent } from './components/navbar.component/navbar.component';
import { FooterComponent } from './components/footer.component/footer.component';


@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CommonModule, NavbarComponent, FooterComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  showNavbarFooter = true;

  constructor(private router: Router) {
    this.router.events.pipe(
      filter(event => event instanceof NavigationEnd)
    ).subscribe((event: any) => {
      const authRoutes = ['/login', '/register', '/reset-password', '/forgot-password'];
      this.showNavbarFooter = !authRoutes.some(route => event.url.includes(route));
    });
  }
}
