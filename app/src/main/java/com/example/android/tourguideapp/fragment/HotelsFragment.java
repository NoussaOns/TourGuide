package com.example.android.tourguideapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.tourguideapp.R;
import com.example.android.tourguideapp.adapter.HotelAdapter;
import com.example.android.tourguideapp.items.HotelsItem;

import java.util.ArrayList;


public class HotelsFragment extends Fragment {

    @BindView(R.id.recycler_view_hotels)
    RecyclerView mRecyclerView;

    private HotelAdapter mHotelAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hotels, container, false);

        //bind the views
        ButterKnife.bind(this,view);

        //add items to the arraylist
        ArrayList<HotelsItem> hotelsItems = new ArrayList<>();
        // TODO: The prices should be replaced with the ones that I have to learn how to get from the website
        hotelsItems.add(new HotelsItem(R.drawable.crowne_plaza_hotels,getString(R.string.crowne_plaza_hotel),
                "17.009342,54.152216", getString(R.string.crowne_plaza_url), "64 OMR"));

        hotelsItems.add(new HotelsItem(R.drawable.hamdan_plaza_hotel,getString(R.string.hamdan_plaza_hotel),
                "17.019285,54.060908", getString(R.string.hamdan_plaza_url), "46 OMR"));

        hotelsItems.add(new HotelsItem(R.drawable.gradens_hotel,getString(R.string.gardens_hotel),
                "17.022435,54.066085", getString(R.string.gardens_url), "50 OMR"));

        hotelsItems.add(new HotelsItem(R.drawable.rotana_hotels,getString(R.string.rotana_hotel),
                "17.030712,54.296055", getString(R.string.rotana_url), "100 OMR"));

        //set the recycler view
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        mHotelAdapter = new HotelAdapter(getActivity(),hotelsItems);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mHotelAdapter);
        return view;
    }

}
