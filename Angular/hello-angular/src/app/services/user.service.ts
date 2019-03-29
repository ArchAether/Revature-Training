import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import{ Observable} from 'rxjs';
import { User } from '../models/user.models';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  name: string="This is my sington user service";

  API_URL: string = "http://localhost:3000/users";

  constructor(private http: HttpClient) { }

  public test(){
    return "properly injected service!";

  }
  public getUsers(): Observable<User[]>{
    return this.http.get<User[]>(this.API_URL);   //Let's you get it as an array of User
    //Http requests need to be of observables. then you need to subscribe
  }
}
