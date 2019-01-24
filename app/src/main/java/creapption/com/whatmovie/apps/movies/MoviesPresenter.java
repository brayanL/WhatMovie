package creapption.com.whatmovie.apps.movies;

public interface MoviesPresenter {
    /**
     * Retrieve movies list from services.
     * @param movieCategory the movie categories
     * */
    void getMovies(String movieCategory);

    /**
     * Cancel the connection to Observable.
     * */
    void onDestroy();
}
