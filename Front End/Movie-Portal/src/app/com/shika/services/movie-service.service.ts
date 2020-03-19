import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Movie } from '../models/Movie';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MovieServiceService {

  private userId: string = "2121";
  
  constructor(private httpClient: HttpClient) { console.log("MovieServiceService cons");}

  getMovies(): Observable<Movie>{
    return this.httpClient.get<Movie>(`http://localhost:8081/catalog/${this.userId}`);
  }

}
