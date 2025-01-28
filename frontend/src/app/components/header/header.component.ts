import { Component, OnInit } from '@angular/core';
import { HeaderService } from './header.service';
import { User } from 'src/app/pages/home/models/User';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html'
})
export class HeaderComponent implements OnInit {
  user: User | null = null;

  constructor(private service: HeaderService) {}
 
  ngOnInit(): void {
    this.getUser();
  }

  private getUser() {
    this.service.getUser().subscribe({
      next: (response) => {
        this.user = response;
      },
      error: ({ error }) => console.error(error)
    })
  }
}
