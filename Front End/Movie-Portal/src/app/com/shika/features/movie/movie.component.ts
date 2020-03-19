import { Component, OnInit, OnDestroy } from '@angular/core';
import { Movie } from '../../models/Movie';
import { Subscription, Observable } from 'rxjs';
import { map, retry, catchError, toArray } from 'rxjs/operators';
import { MovieServiceService } from '../../services/movie-service.service';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit, OnDestroy {
  private movies$: Observable<Movie>;
  private subscription: Subscription;
  
  constructor(private movieServiceService: MovieServiceService) { console.log("MovieComponent cons");  }

  ngOnInit() {
    this.movies$ = this.movieServiceService.getMovies()
    .pipe(
      // map((data: Movie) => new Movie().deserialize(data))
      map(data => data)
    );
  }

  ngOnDestroy(): void {
    if(this.subscription){
      this.subscription.unsubscribe();
    }
  }
}