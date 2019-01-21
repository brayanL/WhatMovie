package creapption.com.whatmovie.apps.movies.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import creapption.com.whatmovie.R;
import creapption.com.whatmovie.data.remote.api.MovieDetailResponseModel;
import creapption.com.whatmovie.util.Constants;

/**
 * @author bomar24
 * Adapter that connects to {@link RecyclerView} view to provide data.
 * This adapter is used for to show Popular, Top Rated and Upcoming movies.
 * */
public class MoviesListAdapter extends RecyclerView.Adapter<MoviesListAdapter.CustomViewHolder> {

    private List<MovieDetailResponseModel> moviesList;
    private Context mContext;

    public MoviesListAdapter(List<MovieDetailResponseModel> moviesList, Context mContext) {
        this.moviesList = moviesList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_movies, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        MovieDetailResponseModel movie = moviesList.get(position);

        Glide.with(mContext)
                .load(Constants.POSTER_IMAGE_BASE_URL.concat(movie.getPosterPath()))
                .into(holder.posterMovie);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public void updateMoviesList(List<MovieDetailResponseModel> moviesList) {
        this.moviesList = moviesList;
        notifyDataSetChanged();
    }

    /**
     * CustomViewHolder to set CardView for Movies.
     * */
    public class CustomViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image_poster_movie)
        ImageView posterMovie;

        Unbinder unbinder;

        public CustomViewHolder(View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this, itemView);
        }
    }
}
