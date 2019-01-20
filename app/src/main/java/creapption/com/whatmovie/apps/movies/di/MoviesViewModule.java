package creapption.com.whatmovie.apps.movies.di;

import creapption.com.whatmovie.apps.movies.ui.MoviesView;
import creapption.com.whatmovie.apps.movies.ui.PopularMovieFragment;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class MoviesViewModule {

    @Binds
    public abstract MoviesView bindPopularMovies(PopularMovieFragment popularMovieFragment);

}
