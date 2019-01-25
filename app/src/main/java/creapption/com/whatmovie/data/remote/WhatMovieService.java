package creapption.com.whatmovie.data.remote;

import creapption.com.whatmovie.data.remote.api.MovieByIdResponseModel;
import creapption.com.whatmovie.data.remote.api.MovieResponseModel;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author bomar24
 * Make all the request of the application
 * */
public interface WhatMovieService {

    /**
     * Get movies for Popular and Top Rated categories.
     * @param movieCategory the movie categories
     * @return main object response
     * */
    @GET("movie/{movie_category}")
    Observable<MovieResponseModel> getMovies(
            @Path(value = "movie_category", encoded = true) String movieCategory);

    /**
     * Get movies for Upcoming category.
     * @param movieCategory the movie categories
     * @param releaseType static value for upcoming movies
     * @param region if this parameter is not specified, no corrected results will be obtained.
     * @return main object response
     * */
    @GET("movie/{movie_category}")
    Observable<MovieResponseModel> getUpcomingMovies(
            @Path(value = "movie_category", encoded = true) String movieCategory,
            @Query(encoded = true, value = "with_release_type") String releaseType,
            @Query(encoded = true, value = "region") String region);

    /**
     * Get movie detail by id.
     * @param movieID ID movie to be searched.
     * @param append additional information
     * */
    @GET("movie/{movie_id}")
    Observable<MovieByIdResponseModel> getDetailMovie(
            @Path(value = "movie_id", encoded = true) Long movieID,
            @Query(value = "append_to_response", encoded = true) String append);
}
