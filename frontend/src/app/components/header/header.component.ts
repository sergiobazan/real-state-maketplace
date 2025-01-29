import { Component, OnInit } from '@angular/core';
import { HeaderService } from './header.service';
import { User } from 'src/app/pages/home/models/User';
import { AuthService } from 'src/app/pages/auth/auth.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html'
})
export class HeaderComponent implements OnInit {
  user: User | null = null;
  private authSubscription!: Subscription;

  constructor(private service: HeaderService, private auth: AuthService) {}
 
  ngOnInit(): void {
    this.getUser();
    this.authSubscription = this.auth.isAuthenticated$.subscribe(isAuthenticated => {
      if (isAuthenticated) {
        this.getUser(); // Obtener el usuario si está autenticado
      } else {
        this.user = null; // Limpiar el usuario si no está autenticado
      }
    });
  }

  private getUser() {
    this.service.getUser().subscribe({
      next: (response) => {
        this.user = response;
      },
      error: ({ error }) => console.error(error)
    })
  }

  logout() {
    this.auth.logout();
    this.user = null;
  }

  ngOnDestroy(): void {
    if (this.authSubscription) {
      this.authSubscription.unsubscribe();
    }
  }
}
