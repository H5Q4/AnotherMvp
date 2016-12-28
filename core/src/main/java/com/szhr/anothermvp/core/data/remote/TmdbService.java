package com.szhr.anothermvp.core.data.remote;

import com.szhr.anothermvp.core.data.model.Movie;
import com.szhr.anothermvp.core.data.model.RawResponse;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface TmdbService {

  @GET("/movie/popular")
  Observable<RawResponse<Movie>> getPopularMovies(@Query("page") int page);

  @GET("/movie/{movieId}")
  Observable<Movie> getMovieDetails(@Path("movieId") long movieId);

}
