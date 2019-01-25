package creapption.com.whatmovie.apps.movies.ui.detaiMovie.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import creapption.com.whatmovie.R;
import creapption.com.whatmovie.data.remote.api.MovieByIdResponseModel;
import creapption.com.whatmovie.util.Constants;

/**
 * Adapter to show information of actors on cardViews.
 * */
public class CastMovieAdapter extends RecyclerView.Adapter<CastMovieAdapter.CastViewHolder> {

    private Context mContext;
    private List<MovieByIdResponseModel.Cast> castList;

    public CastMovieAdapter(Context mContext, List<MovieByIdResponseModel.Cast> castList) {
        this.mContext = mContext;
        this.castList = castList;
    }

    @NonNull
    @Override
    public CastViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CastViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_view_cast, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CastViewHolder castViewHolder, int i) {
        MovieByIdResponseModel.Cast actor = castList.get(i);

        if (actor.getProfile_path() != null) {
            Glide.with(mContext)
                    .applyDefaultRequestOptions(new RequestOptions().centerCrop())
                    .load(Constants.ACTOR_IMAGE_BASE_URL.concat(actor.getProfile_path()))
                    .into(castViewHolder.actorPhotoImage);
        } else {
           Glide.with(mContext).load(R.drawable.ic_movie).into(castViewHolder.actorPhotoImage);
        }

        castViewHolder.actorNameText.setText(actor.getName());
    }

    @Override
    public int getItemCount() {
        return castList.size();
    }

    public void updateCastList(List<MovieByIdResponseModel.Cast> castList) {
        this.castList = castList;
        notifyDataSetChanged();
    }

    public class CastViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image_actor_photo) ImageView actorPhotoImage;
        @BindView(R.id.text_actor_name) TextView actorNameText;

        Unbinder unbinder;

        public CastViewHolder(@NonNull View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this, itemView);
        }
    }
}
