package creapption.com.whatmovie.main.di;

import creapption.com.whatmovie.application.DomainModule;
import creapption.com.whatmovie.apps.movies.di.MoviesModule;
import creapption.com.whatmovie.apps.movies.di.MoviesViewModule;
import creapption.com.whatmovie.apps.movies.ui.PopularMovieFragment;
import creapption.com.whatmovie.apps.movies.ui.detaiMovie.di.DetailMovieModule;
import creapption.com.whatmovie.apps.movies.ui.detaiMovie.di.DetailMovieViewModule;
import creapption.com.whatmovie.apps.movies.ui.detaiMovie.ui.DetailMovieActivity;
import creapption.com.whatmovie.main.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Binds all sub-components within the app.
 * Specifying the dependencies that will be provided to Activities and Fragments.
 */

@Module
public abstract class BuildersModule {

    //Fixme: not used for this moment, in the future MainActivity could require dependents to be injected.
    @ContributesAndroidInjector(modules = {MoviesViewModule.class})
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = {DomainModule.class, MoviesModule.class, MoviesViewModule.class})
    abstract PopularMovieFragment bindPopularMovieFragment();

    @ContributesAndroidInjector(modules = {DomainModule.class, DetailMovieModule.class,
            DetailMovieViewModule.class})
    abstract DetailMovieActivity bindDetailMovieActivity();
}
