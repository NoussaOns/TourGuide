package com.example.android.tourguideapp;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Places extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        ButterKnife.bind(this);
        //if the activity is intialized for the first time or
        // we hit the back button and came again to it
        if (savedInstanceState == null) {
            //when we start the activity we open the nature fragment immediately
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new NatureFragment()).commit();
            //check the nature option
            navigationView.setCheckedItem(R.id.nav_nature);
        }

        //set the title to the clicked item of the navigation drawer
        toolbar.setTitle(navigationView.getCheckedItem().getTitle());

        //set the drawer navigation bar
        drawer = findViewById(R.id.drawer_layout);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_nature:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new NatureFragment()).commit();
                        break;

                    case R.id.nav_beaches:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new BeachesFragment()).commit();
                        break;

                    case R.id.nav_hotels:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new HotelsFragment()).commit();
                        break;

                    case R.id.nav_restaurants:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new RestaurantsFragment()).commit();
                        break;

                    case R.id.nav_shopping:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new ShoppingFragment()).commit();
                        break;
                }

                toolbar.setTitle(menuItem.getTitle());
                //close drawer after selecting the item
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        //to handle the rotating of the navigation button in the toolbar
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,
                toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            //if close it to the right, use instead .END
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
