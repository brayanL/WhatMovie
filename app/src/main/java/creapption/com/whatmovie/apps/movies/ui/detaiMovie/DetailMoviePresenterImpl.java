package creapption.com.whatmovie.apps.movies.ui.detaiMovie;

import android.util.Log;

import creapption.com.whatmovie.apps.movies.ui.detaiMovie.ui.DetailMovieView;
import creapption.com.whatmovie.data.DataManager;
import creapption.com.whatmovie.data.remote.api.MovieByIdResponseModel;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DetailMoviePresenterImpl implements DetailMoviePresenter {

    private static final String TAG = DetailMoviePresenterImpl.class.getSimpleName();

    private Disposable mSubscription = null;

    private DataManager mDataManager;
    private DetailMovieView mDetailMovieView;

    public DetailMoviePresenterImpl(DataManager mDataManager,
                                    DetailMovieView detailMovieView) {
        this.mDataManager = mDataManager;
        this.mDetailMovieView = detailMovieView;
    }

    @Override
    public void getDetailMovie(Long movieID) {
        mDataManager.getDetailMovie(movieID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieByIdResponseModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mSubscription = d;
                    }

                    @Override
                    public void onNext(MovieByIdResponseModel movieByIdResponseModel) {
                        Log.i(TAG, "Movie Data: " + movieByIdResponseModel.getHomepage());
                        mDetailMovieView.showDetailMovie(movieByIdResponseModel);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mDetailMovieView.showDetailMovie(null);
                        Log.e(TAG, "onError DetailMovie: ", e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onDestroy() {
        mSubscription.dispose();
    }
}
