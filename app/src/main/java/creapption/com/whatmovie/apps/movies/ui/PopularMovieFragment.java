package creapption.com.whatmovie.apps.movies.ui;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import creapption.com.whatmovie.R;
import creapption.com.whatmovie.apps.movies.MoviesPresenter;
import creapption.com.whatmovie.data.remote.api.MovieResponseModel;
import creapption.com.whatmovie.util.Constants;
import dagger.android.support.AndroidSupportInjection;


/**
 * @author bomar24
 * Show Popular Movies in {@link android.support.design.widget.BottomNavigationView}.
 */
public class PopularMovieFragment extends Fragment implements MoviesView {

    @Inject
    MoviesPresenter moviesPresenter;

    @Inject
    Context context;

    @BindView(R.id.recycler_movies)
    RecyclerView recyclerViewMovies;

    @BindView(R.id.progress_bar_popular_movie)
    ProgressBar progressBar;

    private static final String TAG = PopularMovieFragment.class.getSimpleName();
    private MoviesListAdapter mAdapter;
    private Unbinder mUnbinder;

    public PopularMovieFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_popular_movie, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        //get movies list
        moviesPresenter.getMovies(Constants.POPULAR_MOVIE);

        setupAdapter();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void showMovies(MovieResponseModel movieResponseModels) {
        progressBar.setVisibility(View.GONE);
        mAdapter.updateMoviesList(movieResponseModels.getResults());
    }

    private void setupAdapter() {
        mAdapter = new MoviesListAdapter(new ArrayList<>(), context);
        recyclerViewMovies.setLayoutManager(new GridLayoutManager(context, 2));
        recyclerViewMovies.setAdapter(mAdapter);
    }
}
