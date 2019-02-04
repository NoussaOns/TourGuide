package com.example.android.tourguideapp;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Picture1();
            case 1:
                return new Picture2();
            case 2:
                return new Picture3();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
