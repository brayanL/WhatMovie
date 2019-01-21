package creapption.com.whatmovie.apps.movies.ui;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import creapption.com.whatmovie.R;

/**
 * @author bomar24
 * Movies Fragment this contain {@link BottomNavigationView} to visualize Popular,
 * Top Rated and Upcoming Movies.
 */
public class MoviesFragment extends Fragment {

    @BindView(R.id.bottom_navigation) BottomNavigationView bottomNavigationView;

    private Unbinder mUnbinder;
    private Class fragmentClass;

    private static final String TAG = MoviesFragment.class.getSimpleName();

    public MoviesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Config for ButterKnife
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        setupBottomNavigation();

        //set default Fragment
        fragmentClass = PopularMovieFragment.class;
        setFragment(fragmentClass);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    /**
     * Config BottomNavigationView and show every child Fragment
     * according to the menu selected by the user.
     * */
    private void setupBottomNavigation() {
        bottomNavigationView.setOnNavigationItemSelectedListener(
                item -> {
                    switch (item.getItemId()) {
                        case R.id.nav_popular:
                            fragmentClass = PopularMovieFragment.class;
                            setFragment(fragmentClass);
                            return true;
                        case R.id.nav_top_rated:
                            fragmentClass = TopRatedMovieFragment.class;
                            setFragment(fragmentClass);
                            return true;
                        case R.id.nav_upcoming:
                            fragmentClass = UpcomingMovieFragment.class;
                            setFragment(fragmentClass);
                            return true;
                        default:
                            return false;
                    }
                });
    }

    /**
     * Generic implementation for instance child fragments.
     * @param fragmentClass fragment that will be instantiated.
     * */
    private void setFragment(Class fragmentClass) {
        Fragment fragment;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
            if (getFragmentManager() != null) {
                getFragmentManager().beginTransaction().replace(R.id.content_movies, fragment).commit();
            } else {
                Log.i(TAG, "getFragmentManager was null, fragment was not instanced");
            }

        } catch (java.lang.InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
