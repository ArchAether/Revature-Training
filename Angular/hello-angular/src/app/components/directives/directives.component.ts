import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directives',
  templateUrl: './directives.component.html',
  styleUrls: ['./directives.component.css']
})
export class DirectivesComponent implements OnInit {

  items = ['wine', 'steak', 'travel', 'other things that are expensive'];
  employees = [
    {
      name: 'Genesis',
      role: 'Trainer'
    },
    {
      name: 'Pushpinder',
      role: 'Trainer'
    },
    {
      name: 'Patrick',
      role: 'Trainer'
    },
    {
      name: 'David',
      role: 'Associate'
    },
    {
      name: 'Tiffany',
      role: 'Associate'
    },
    {
      name: 'Stephen',
      role: 'Associate'
    },
   ]

   games = [
     {
      name: "Mario Bros.",
      releaseYear: 1980
     },
     {
      name: "Portal",
      releaseYear: 2005
     },
     {
      name: "Legend of Zelda",
      releaseYear: 1998
     },
     {
      name: "Final Fantasy",
      releaseYear: 1992
     },
   ]

   bool: boolean = false;

  constructor() { }

  ngOnInit() {
  }
  toggle(){
    this.bool = !this.bool;
  }
}
