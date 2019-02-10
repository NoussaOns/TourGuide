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
import com.example.android.tourguideapp.items.NatureItem;

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
        ButterKnife.bind(this, view);

        ArrayList<NatureItem> natureItems = new ArrayList<>();
        natureItems.add(new NatureItem(R.drawable.arzat_nature, getString(R.string.arzat_nature), "17.129886,54.237979"));
        natureItems.add(new NatureItem(R.drawable.darbat_nature, getString(R.string.darbat_nature), "17.105881,54.453102"));
        natureItems.add(new NatureItem(R.drawable.himran_nature, getString(R.string.himran_nature), "17.097262,54.281278"));
        natureItems.add(new NatureItem(R.drawable.jarzeez_nature, getString(R.string.jarzeez_nature), "17.105654,54.074202"));

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        mAdapter = new NatureAdapter(getActivity(), natureItems);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }


}
