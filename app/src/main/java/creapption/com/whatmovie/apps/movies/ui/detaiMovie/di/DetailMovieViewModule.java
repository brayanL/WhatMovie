package creapption.com.whatmovie.apps.movies.ui.detaiMovie.di;

import creapption.com.whatmovie.apps.movies.ui.detaiMovie.ui.DetailMovieActivity;
import creapption.com.whatmovie.apps.movies.ui.detaiMovie.ui.DetailMovieView;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class DetailMovieViewModule {

    @Binds
    public abstract DetailMovieView bindDetailMovieView(DetailMovieActivity detailMovieActivity);
}
