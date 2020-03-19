import { Component, OnInit, OnChanges, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-movie-dashboard',
  templateUrl: './movie-dashboard.component.html',
  styleUrls: ['./movie-dashboard.component.css']
})
export class MovieDashboardComponent implements OnInit, OnChanges, OnDestroy  {

  constructor() {
    console.log("constructor");
  }

  ngOnInit() {
    console.log("ngOnInit");
  }

  ngDoCheck() {
    console.log("ngDoCheck");  
  }
  
  ngOnChanges(changes: import("@angular/core").SimpleChanges): void {
    console.log("ngOnChanges");
  }

  ngOnDestroy(): void {
    console.log("ngOnDestroy");
  }
  
}
