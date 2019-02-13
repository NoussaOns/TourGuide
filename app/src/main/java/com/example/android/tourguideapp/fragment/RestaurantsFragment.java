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
import com.example.android.tourguideapp.adapter.RestaurantAdapter;
import com.example.android.tourguideapp.items.PlacesItems;

import java.util.ArrayList;


public class RestaurantsFragment extends Fragment {

    @BindView(R.id.recycler_view_restaurants)
    RecyclerView mRecyclerView;

    private RestaurantAdapter mRestaurantAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_restaurants, container, false);

        //bind the views
        ButterKnife.bind(this,view);

        //add items to the arraylist
        ArrayList<PlacesItems> restaurantItems = new ArrayList<>();
        restaurantItems.add(new PlacesItems(R.drawable.hamdan_plaza_restaurant, getString(R.string.hamdan_plaza_restaurant),
                getString(R.string.gps_hamdan_plaza), getString(R.string.hamdan_plaza_url)));

        restaurantItems.add(new PlacesItems(R.drawable.sammak_restaurant, getString(R.string.sammak_restaurant),
                getString(R.string.gps_rotana), getString(R.string.rotana_url)));

        //set the recycler view
        mRecyclerView.setHasFixedSize(true);
        mRestaurantAdapter = new RestaurantAdapter(getActivity(),restaurantItems);
        mLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mRestaurantAdapter);


        return view;
    }
}

