package creapption.com.whatmovie.data;

import creapption.com.whatmovie.data.remote.WhatMovieService;
import creapption.com.whatmovie.data.remote.api.MovieResponseModel;
import io.reactivex.Observable;

/**
 * It keeps a reference to every helper class and uses
 * them to satisfy the requests coming from the presenters. Its methods make extensive use
 * of Rx operators to combine, transform or filter the output coming from the helpers in order
 * to generate the desired output ready for the Presenters. It returns observables that emit
 * data models.
 * */
public class DataManager {

    private WhatMovieService mWhatMovieService;

    public DataManager(WhatMovieService mWhatMovieService) {
        this.mWhatMovieService = mWhatMovieService;
    }

    public Observable<MovieResponseModel> getMovies(String movieCategory) {
        return mWhatMovieService.getMovies(movieCategory);
    }
}
