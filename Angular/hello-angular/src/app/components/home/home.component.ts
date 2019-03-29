import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  //template: `<h1>Hey! this is my Home component!</h1>`,
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  name = 'Genesis';
  time;
  count: number = 0;
  colorProp = 'blue';

  /*
  Standard TS constructor to instantiate classes
  */

  constructor() {
    setInterval(
      ()=>{
        this.time = new Date();
      }, 1000);
    }
    
  /*
  This is Angular's method that executes once the template and component have been
  fully loaded
  */

  ngOnInit() {
  }
  increment(){
    this.count++;
  }

}
