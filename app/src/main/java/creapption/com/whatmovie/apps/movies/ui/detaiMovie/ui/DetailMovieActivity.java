package creapption.com.whatmovie.apps.movies.ui.detaiMovie.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import creapption.com.whatmovie.R;
import creapption.com.whatmovie.apps.movies.ui.detaiMovie.DetailMoviePresenter;
import creapption.com.whatmovie.data.remote.api.MovieByIdResponseModel;
import creapption.com.whatmovie.data.remote.api.MovieDetailResponseModel;
import creapption.com.whatmovie.util.Constants;
import dagger.android.AndroidInjection;

/**
 * Display additional information for specific Movie.
 * */
public class DetailMovieActivity extends AppCompatActivity implements DetailMovieView {

    @BindView(R.id.toolbar_detail_movie) Toolbar toolbarDetailMovie;
    @BindView(R.id.image_backdrop) ImageView backdropImageView;
    @BindView(R.id.image_poster_detail) ImageView posterDetailImageView;
    @BindView(R.id.text_overview) TextView overViewText;
    @BindView(R.id.progress_bar_cast) ProgressBar castProgressBar;
    @BindView(R.id.recycler_cast) RecyclerView recyclerViewCast;

    @Inject
    DetailMoviePresenter moviePresenter;


    private MovieDetailResponseModel mMovie;
    private CastMovieAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        ButterKnife.bind(this);

        toolbarDetailMovie.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbarDetailMovie);

        //get movie object passed from PopularMovieFragment
        mMovie = (MovieDetailResponseModel) getIntent().getSerializableExtra(Constants.DATA_MOVIE_DETAIL);

        moviePresenter.getDetailMovie(mMovie.getId());

        //set ActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(mMovie.getTitle());
        }

        //load backdrop image
        if (mMovie.getBackdropPath() != null) {
            Glide.with(getApplicationContext())
                    .applyDefaultRequestOptions(new RequestOptions().centerCrop())
                    .load(Constants.BACKDROP_IMAGE_BASE_URL.concat(mMovie.getBackdropPath()))
                    .into(backdropImageView);
        } else {
            Glide.with(getApplicationContext()).load(R.drawable.ic_launcher_background).into(backdropImageView);
        }

        //load poster image
        if(mMovie.getPosterPath() != null) {
            Glide.with(getApplicationContext())
                    .applyDefaultRequestOptions(new RequestOptions().fitCenter())
                    .load(Constants.POSTER_IMAGE_BASE_URL.concat(mMovie.getPosterPath()))
                    .into(posterDetailImageView);
        } else {
            Glide.with(getApplicationContext()).load(R.drawable.ic_launcher_foreground).into(posterDetailImageView);
        }

        //set overview
        overViewText.setText(mMovie.getOverview());

        setupAdapter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        moviePresenter.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void showDetailMovie(MovieByIdResponseModel movieByIdResponseModel) {
        if(movieByIdResponseModel != null) {
            //Todo: check possible IndexOutOfBoundsException.
            //limit number actors that can be appear.
            mAdapter.updateCastList(movieByIdResponseModel.getCast().subList(0, 5));
        }
        castProgressBar.setVisibility(View.GONE);
    }

    /**
     * Set Adapter and Divider for recyclerView.
     * */
    private void setupAdapter() {
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        DividerItemDecoration dividerItemDecoration = new
                DividerItemDecoration(recyclerViewCast.getContext(), layoutManager.getOrientation());
        mAdapter = new CastMovieAdapter(this, new ArrayList<>());
        recyclerViewCast.setLayoutManager(layoutManager);
        recyclerViewCast.setAdapter(mAdapter);
        recyclerViewCast.addItemDecoration(dividerItemDecoration);

    }
}
