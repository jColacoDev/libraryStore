import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.scss']
})
export class NavBarComponent implements OnInit {

  loggedIn = false;

  constructor(){}

  toggleDisplay(){
    this.loggedIn = !this.loggedIn;
  }

  ngOnInit(): void {
      
  }
  
}
