package com.example.android.tourguideapp;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Find the view pager
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);

        //pager adapter
        PagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            int[] photos = {R.drawable.vacation_holidays_background_with_realistic_globe_suitcase_photo_camera_1284_10476, R.drawable.world_with_landmarks_background_watercolor_style_23_2147765646, R.drawable.modern_hotel_reception_composition_23_2147994128};

            @NonNull
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = new PicturesFragment();
                Bundle args = new Bundle();
                args.putInt("photo", photos[position]);
                fragment.setArguments(args);
                return fragment;
            }

            @Override
            public int getCount() {
                return photos.length;
            }
        };

        //set the adapter into the viewPager
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(viewPager, true);
    }
}
