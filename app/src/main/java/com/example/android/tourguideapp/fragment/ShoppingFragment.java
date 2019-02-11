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
import com.example.android.tourguideapp.adapter.ShoppingAdapter;
import com.example.android.tourguideapp.items.ShoppingItem;

import java.util.ArrayList;


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

        ButterKnife.bind(this, view);
        ArrayList<ShoppingItem> shoppingItems = new ArrayList<>();
        shoppingItems.add(new ShoppingItem(R.drawable.carrefour_shopping, getString(R.string.carrefour_shopping),
                "17.023459,54.066395", getString(R.string.carrefour_url)));

        shoppingItems.add(new ShoppingItem(R.drawable.lulu_shopping, getString(R.string.lulu_shopping),
                "17.017114,54.061711", getString(R.string.lulu_url)));

        mRecyclerView.setHasFixedSize(true);
        mShoppingAdapter = new ShoppingAdapter(getActivity(), shoppingItems);
        mLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mShoppingAdapter);


        return view;
    }

}
