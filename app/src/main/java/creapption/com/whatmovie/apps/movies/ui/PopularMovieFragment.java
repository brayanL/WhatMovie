package creapption.com.whatmovie.apps.movies.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import creapption.com.whatmovie.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PopularMovieFragment extends Fragment {


    public PopularMovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popular_movie, container, false);
    }

}