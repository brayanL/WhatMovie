package creapption.com.whatmovie.apps.movies.ui.detaiMovie;

public interface DetailMoviePresenter {

    /**
     * Get Detail Movie specifying  a movie id.
     * @param movieID id of movie.
     * */
    void getDetailMovie(Long movieID);

    /**
     * Cancel the connection to Observable.
     * */
    void onDestroy();
}
