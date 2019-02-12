package com.example.android.tourguideapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final int MAX_STEP = 3;
    // viewpager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            bottomProgressDots(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };
    private MyViewPagerAdapter myViewPagerAdapter;
    private String[] titles;
    private String[] aboutTitles;

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    private int images[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //set the arrays for which the items of the pageviewer will be put to
        titles = new String[]{
                getString(R.string.ready_to_travel),
                getString(R.string.best_destination),
                getString(R.string.best_hotels)
        };

        aboutTitles = new String[]{
                getString(R.string.ready_to_travel_text),
                getString(R.string.best_destination_text),
                getString(R.string.best_hotels_text)
        };

        images = new int[]{
                R.drawable.vacation_holidays_background_with_realistic_globe_suitcase_photo_camera_1284_10476,
                R.drawable.world_with_landmarks_background_watercolor_style_23_2147765646,
                R.drawable.modern_hotel_reception_composition_23_2147994128
        };


        bottomProgressDots(0);

        //set the view pager adapter to the view pager
        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        Tools.setSystemBarColor(this, R.color.overlay_light_80);
        Tools.setSystemBarLight(this);

    }

    //show the bottom bar dots
    private void bottomProgressDots(int current_index) {
        LinearLayout dotsLayout = findViewById(R.id.layoutDots);
        ImageView[] dots = new ImageView[MAX_STEP];

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(this);
            int width_height = 15;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(width_height, width_height));
            params.setMargins(10, 10, 10, 10);
            dots[i].setLayoutParams(params);
            dots[i].setImageResource(R.drawable.shape_circle);
            dots[i].setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[current_index].setImageResource(R.drawable.shape_circle);
            dots[current_index].setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
        }
    }

    //A custom pager adapter
    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater mLayoutInflater;
        private MaterialButton mButton;

        public MyViewPagerAdapter() {
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            mLayoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = mLayoutInflater.inflate(R.layout.card_items_main, container, false);

            ((TextView) view.findViewById(R.id.title)).setText(titles[position]);
            ((TextView) view.findViewById(R.id.description)).setText(aboutTitles[position]);
            ((ImageView) view.findViewById(R.id.image)).setImageResource(images[position]);

            mButton = view.findViewById(R.id.btn_next);

            if (position == titles.length - 1) {
                mButton.setText(getString(R.string.get_started));
            } else {
                mButton.setText(getString(R.string.next));
            }

            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int current = viewPager.getCurrentItem() + 1;
                    if (current < MAX_STEP) {
                        // move to next screen
                        viewPager.setCurrentItem(current);
                    } else {
                        Intent i = new Intent(getApplicationContext(), Places.class);
                        startActivity(i);
                        finish();
                    }
                }
            });

            container.addView(view);

            return view;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}
