package creapption.com.whatmovie.apps.movies.ui.detaiMovie.di;

import creapption.com.whatmovie.apps.movies.ui.detaiMovie.DetailMoviePresenter;
import creapption.com.whatmovie.apps.movies.ui.detaiMovie.DetailMoviePresenterImpl;
import creapption.com.whatmovie.apps.movies.ui.detaiMovie.ui.DetailMovieView;
import creapption.com.whatmovie.data.DataManager;
import dagger.Module;
import dagger.Provides;

@Module
public class DetailMovieModule {

    @Provides
    DetailMoviePresenter provideDetailMoviePresenter(DataManager dataManager,
                                                     DetailMovieView detailMovieView) {
        return new DetailMoviePresenterImpl(dataManager, detailMovieView);
    }

}
