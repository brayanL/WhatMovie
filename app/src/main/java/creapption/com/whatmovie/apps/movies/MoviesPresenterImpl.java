package creapption.com.whatmovie.apps.movies;

import android.util.Log;

import creapption.com.whatmovie.apps.movies.ui.MoviesView;
import creapption.com.whatmovie.data.DataManager;

public class MoviesPresenterImpl implements MoviesPresenter {

    private static final String TAG = MoviesPresenterImpl.class.getSimpleName();

    private DataManager mDataManager;
    private MoviesView moviesView;

    public MoviesPresenterImpl(DataManager mDataManager, MoviesView moviesView) {
        this.mDataManager = mDataManager;
        this.moviesView = moviesView;
    }

    @Override
    public void getMovies(String movieCategory) {
        Log.i(TAG, "getMovies: MoviesPresenterImpl");
    }
}
