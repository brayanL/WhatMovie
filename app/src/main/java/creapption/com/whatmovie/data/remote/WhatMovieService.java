package creapption.com.whatmovie.data.remote;

import creapption.com.whatmovie.data.remote.api.MovieResponseModel;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Make all the request of the application
 * */
public interface WhatMovieService {

    @GET("movie/{movie_category}")
    Observable<MovieResponseModel> getMovies(@Path(value = "movie_category", encoded = true) String movieCategory);
}
