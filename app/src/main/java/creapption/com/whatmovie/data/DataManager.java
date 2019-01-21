package creapption.com.whatmovie.data;

import creapption.com.whatmovie.data.remote.WhatMovieService;
import creapption.com.whatmovie.data.remote.api.MovieResponseModel;
import creapption.com.whatmovie.util.Constants;
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

    /**
     * Communicates with te service to obtain the movie list according to
     * the parameters provided.
     * @param movieCategory the movie categories
     * @return main object response like an {@link Observable}
     * */
    public Observable<MovieResponseModel> getMovies(String movieCategory) {
        if (movieCategory.equals(Constants.UPCOMING_MOVIE)) {
            return mWhatMovieService.getUpcomingMovies(movieCategory,
                    Constants.RELEASE_TYPE, Constants.REGION);
        } else {
            return mWhatMovieService.getMovies(movieCategory);
        }
    }
}
