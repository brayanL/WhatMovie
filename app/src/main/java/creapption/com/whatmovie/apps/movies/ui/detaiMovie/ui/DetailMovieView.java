package creapption.com.whatmovie.apps.movies.ui.detaiMovie.ui;

import creapption.com.whatmovie.data.remote.api.MovieByIdResponseModel;

public interface DetailMovieView {

    /**
     * Retrieve movie details from service.
     * */
    void showDetailMovie(MovieByIdResponseModel movieByIdResponseModel);
}
