package creapption.com.whatmovie.apps.movies;

import android.util.Log;

import creapption.com.whatmovie.apps.movies.ui.MoviesView;
import creapption.com.whatmovie.data.DataManager;
import creapption.com.whatmovie.data.remote.api.MovieResponseModel;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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
        mDataManager.getMovies(movieCategory)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieResponseModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: Called");
                    }

                    @Override
                    public void onNext(MovieResponseModel movieResponseModel) {
                        Log.i(TAG, "onNext: " + movieResponseModel.getResults());
                        moviesView.showMovies(movieResponseModel);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: ", e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        Log.i(TAG, "getMovies: MoviesPresenterImpl");
    }
}
