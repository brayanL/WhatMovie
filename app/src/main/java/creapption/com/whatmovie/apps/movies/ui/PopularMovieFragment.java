package creapption.com.whatmovie.apps.movies.ui;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import creapption.com.whatmovie.R;
import creapption.com.whatmovie.apps.movies.MoviesPresenter;
import dagger.android.support.AndroidSupportInjection;


/**
 * A simple {@link Fragment} subclass.
 */
public class PopularMovieFragment extends Fragment implements MoviesView {

    @Inject
    MoviesPresenter moviesPresenter;

    public PopularMovieFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        moviesPresenter.getMovies("popular");
        return inflater.inflate(R.layout.fragment_popular_movie, container, false);
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void showMovies(String movieCategory) {

    }
}
