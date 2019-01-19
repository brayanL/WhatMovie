package creapption.com.whatmovie.main;

import android.content.res.Configuration;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import creapption.com.whatmovie.R;
import creapption.com.whatmovie.apps.movies.ui.MoviesFragment;

/**
 * Main Activity, implements Navigation Drawer functionality,
 * set all main configuration for whole project.
 * */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.navigationView) NavigationView navigationView;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;

    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init ButterKnife
        ButterKnife.bind(this);

        setupNavigationDrawer();
    }

    /**
     * Overwriting onPostCreate because according to the documentation
     * syncState should be called here.
     * */
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Config Navigation Drawer and set ItemSelectedListener.
     * */
    private void setupNavigationDrawer() {
        //Toolbar Config
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);

        toggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        selectDrawerItem(item);
                        return true;
                    }
                });

        // Set Default Selected Fragment
        selectDrawerItem(navigationView.getMenu().findItem(R.id.nav_movies));
        navigationView.setCheckedItem(R.id.nav_movies);
    }

    /**
     * Show Fragment from the menu selected in the Navigation Drawer.
     * @param menuItem item to be selected.
     * */
    private void selectDrawerItem(MenuItem menuItem) {
        Fragment fragment;
        Class fragmentClass;
        switch(menuItem.getItemId()) {
            case R.id.nav_movies:
                fragmentClass = MoviesFragment.class;
                break;
            default:
                fragmentClass = MoviesFragment.class;
                break;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, fragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit();
        } catch (java.lang.InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        drawerLayout.closeDrawers();

    }
}
