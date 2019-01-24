package creapption.com.whatmovie.apps.movies.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import creapption.com.whatmovie.R;
import creapption.com.whatmovie.data.remote.api.MovieDetailResponseModel;
import creapption.com.whatmovie.util.Constants;

public class DetailMovieActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_detail_movie) Toolbar toolbarDetailMovie;

    @BindView(R.id.image_backdrop) ImageView backdropImageView;

    @BindView(R.id.image_poster_detail) ImageView posterDetailImageView;


    private MovieDetailResponseModel mMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        ButterKnife.bind(this);

        toolbarDetailMovie.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbarDetailMovie);

        mMovie = (MovieDetailResponseModel) getIntent().getSerializableExtra(Constants.DATA_MOVIE_DETAIL);

        //set ActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(mMovie.getTitle());
        }

        //load backdrop image
        Glide.with(getApplicationContext())
                .applyDefaultRequestOptions(new RequestOptions().centerCrop())
                .load(Constants.BACKDROP_IMAGE_BASE_URL.concat(mMovie.getBackdropPath()))
                .into(backdropImageView);

        //load poster image
        Glide.with(getApplicationContext())
                .applyDefaultRequestOptions(new RequestOptions().fitCenter())
                .load(Constants.POSTER_IMAGE_BASE_URL.concat(mMovie.getPosterPath()))
                .into(posterDetailImageView);
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
}
