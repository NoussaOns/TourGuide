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
import com.example.android.tourguideapp.adapter.BeachesAdapter;
import com.example.android.tourguideapp.items.PlacesItems;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BeachesFragment extends Fragment {


    @BindView(R.id.recycler_view_beaches)
    RecyclerView mRecyclerView;

    private BeachesAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public BeachesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_beaches, container, false);

        //bind the views
        ButterKnife.bind(this, view);

        //add items to the arraylist
        ArrayList<PlacesItems> beachesItems = new ArrayList<>();
        beachesItems.add(new PlacesItems(R.drawable.dahareez_beaches, getString(R.string.dahareez_beach), getString(R.string.gps_dahareez)));
        beachesItems.add(new PlacesItems(R.drawable.haffa_beach, getString(R.string.haffa_beach), getString(R.string.gps_haffa)));
        beachesItems.add(new PlacesItems(R.drawable.maghseel_beaches, getString(R.string.maghseel_beach), getString(R.string.gps_maghseel)));
        beachesItems.add(new PlacesItems(R.drawable.mirbat_beaches, getString(R.string.mirbat_beach), getString(R.string.gps_mirbat)));

        //set the recycler view
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        mAdapter = new BeachesAdapter(getActivity(), beachesItems);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

}
