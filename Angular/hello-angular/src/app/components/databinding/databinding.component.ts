import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-databinding',
  templateUrl: './databinding.component.html',
  styleUrls: ['./databinding.component.css']
})
export class DatabindingComponent implements OnInit {

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
    
  ngOnInit() {
  }

  increment(){
    this.count++;
  }


}
