package com.example.android.tourguideapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tourguideapp.R;
import com.example.android.tourguideapp.items.BeachesItem;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class BeachesAdapter extends RecyclerView.Adapter<BeachesAdapter.BeachesViewHolder> {
    private ArrayList<BeachesItem> mBeachesItems;
    private Context mContext;

    public BeachesAdapter(Context context, ArrayList<BeachesItem> beachesItems) {
        mBeachesItems = beachesItems;
        mContext = context;
    }

    @NonNull
    @Override
    public BeachesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.beaches_item, parent, false);
        BeachesViewHolder beachesViewHolder = new BeachesViewHolder(view);
        return beachesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BeachesViewHolder holder, int position) {
        BeachesItem beachesItem = mBeachesItems.get(position);

        holder.mImageView.setImageResource(beachesItem.getImageResource());
        holder.mTitle.setText(beachesItem.getTitle());
        holder.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:" + beachesItem.getGeoCoor() + "?z=18");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(mContext.getPackageManager()) != null) {
                    mContext.startActivity(mapIntent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mBeachesItems.size();
    }

    public static class BeachesViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.beaches_img_main_card_1)
        ImageView mImageView;
        @BindView(R.id.beaches_tv_card_main_1_title)
        TextView mTitle;
        @BindView(R.id.beaches_btn_card_main1_action1)
        MaterialButton mButton;

        public BeachesViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}

