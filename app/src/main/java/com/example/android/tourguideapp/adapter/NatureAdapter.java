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
import com.example.android.tourguideapp.items.PlacesItems;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class NatureAdapter extends RecyclerView.Adapter<NatureAdapter.NatureViewHolder> {
    private ArrayList<PlacesItems> mNatureItems;
    private Context mContext;

    public NatureAdapter(Context context, ArrayList<PlacesItems> natureItems) {
        mNatureItems = natureItems;
        mContext = context;
    }

    @NonNull
    @Override
    public NatureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.nature_item, parent, false);
        return new NatureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NatureViewHolder holder, int position) {
        PlacesItems natureItem = mNatureItems.get(position);

        holder.mImageView.setImageResource(natureItem.getImageResource());
        holder.mTitle.setText(natureItem.getTitle());
        holder.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:" + natureItem.getGeoCoor() + "?z=18");
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
        return mNatureItems.size();
    }

    public static class NatureViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.nature_img_main_card_1)
        ImageView mImageView;
        @BindView(R.id.nature_tv_card_main_1_title)
        TextView mTitle;
        @BindView(R.id.nature_btn_card_main1_action1)
        MaterialButton mButton;

        public NatureViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
