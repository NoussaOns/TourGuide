package com.example.android.tourguideapp.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.tourguideapp.R;
import com.example.android.tourguideapp.adapter.ShoppingAdapter;
import com.example.android.tourguideapp.items.PlacesItems;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingFragment extends Fragment {


    @BindView(R.id.recycler_view_shopping)
    RecyclerView mRecyclerView;

    private ShoppingAdapter mShoppingAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public ShoppingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shopping, container, false);

        //bind the views
        ButterKnife.bind(this, view);

        //add items to the arraylist
        ArrayList<PlacesItems> shoppingItems = new ArrayList<>();
        shoppingItems.add(new PlacesItems(R.drawable.carrefour_shopping, getString(R.string.carrefour_shopping),
                getString(R.string.gps_gardens), getString(R.string.carrefour_url)));

        shoppingItems.add(new PlacesItems(R.drawable.lulu_shopping, getString(R.string.lulu_shopping),
                getString(R.string.gps_lulu), getString(R.string.lulu_url)));

        //set the recycler view
        mRecyclerView.setHasFixedSize(true);
        mShoppingAdapter = new ShoppingAdapter(getActivity(), shoppingItems);
        mLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mShoppingAdapter);


        return view;
    }

}
