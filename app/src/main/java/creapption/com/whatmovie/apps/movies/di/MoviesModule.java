package creapption.com.whatmovie.apps.movies.di;

import creapption.com.whatmovie.apps.movies.MoviesPresenter;
import creapption.com.whatmovie.apps.movies.MoviesPresenterImpl;
import creapption.com.whatmovie.apps.movies.ui.MoviesView;
import creapption.com.whatmovie.data.DataManager;
import dagger.Module;
import dagger.Provides;

@Module
public class MoviesModule {

    @Provides
    MoviesPresenter provideMoviesPresenter(DataManager dataManager, MoviesView moviesView) {
        return new MoviesPresenterImpl(dataManager, moviesView);
    }
}
