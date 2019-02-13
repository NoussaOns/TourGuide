package com.example.android.tourguideapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.tourguideapp.adapter.NatureAdapter;
import com.example.android.tourguideapp.items.PlacesItems;

import java.util.ArrayList;


public class NatureFragment extends Fragment {

    @BindView(R.id.recycler_view_nature)
    RecyclerView mRecyclerView;

    private NatureAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public NatureFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nature, container, false);

        //bind the views
        ButterKnife.bind(this, view);

        //add items to the arraylist
        ArrayList<PlacesItems> natureItems = new ArrayList<>();
        natureItems.add(new PlacesItems(R.drawable.arzat_nature, getString(R.string.arzat_nature), getString(R.string.gps_arzat)));
        natureItems.add(new PlacesItems(R.drawable.darbat_nature, getString(R.string.darbat_nature), getString(R.string.gps_darbat)));
        natureItems.add(new PlacesItems(R.drawable.himran_nature, getString(R.string.himran_nature), getString(R.string.gps_himran)));
        natureItems.add(new PlacesItems(R.drawable.jarzeez_nature, getString(R.string.jarzeez_nature), getString(R.string.gps_jarzeez)));

        //set the recycler view
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        mAdapter = new NatureAdapter(getActivity(), natureItems);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }


}
