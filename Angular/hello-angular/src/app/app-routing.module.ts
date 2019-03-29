import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { DatabindingComponent } from './components/databinding/databinding.component';
import { DirectivesComponent } from './components/directives/directives.component';
import { UserService } from './services/user.service';

const routes: Routes = [
  //list of route objects
  {path: "", redirectTo: '/home', pathMatch: 'full'}, //Must be first. if no endpoint, goes here
  {path: 'home', component: HomeComponent},
  {path: 'binding', component: DatabindingComponent},
  {path: 'directives', component: DirectivesComponent},
  {path: 'users', component: UserService}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
