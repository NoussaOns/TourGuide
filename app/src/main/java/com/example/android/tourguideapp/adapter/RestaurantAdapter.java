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
import com.example.android.tourguideapp.items.RestaurantItem;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {

    private ArrayList<RestaurantItem> mRestaurantItems;
    private Context mContext;

    public RestaurantAdapter(Context context, ArrayList<RestaurantItem> restaurantItems){
        mRestaurantItems = restaurantItems;
        mContext = context;
    }

    @NonNull
    @Override
    public RestaurantAdapter.RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.restaurant_item,parent,false);
        RestaurantViewHolder restaurantViewHolder = new RestaurantViewHolder(view);
        return restaurantViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantAdapter.RestaurantViewHolder holder, int position) {
        RestaurantItem restaurantItem = mRestaurantItems.get(position);

        holder.mTitle.setText(restaurantItem.getTitle());
        holder.mImageView.setImageResource(restaurantItem.getImageResource());
        holder.mOnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:" + restaurantItem.getGeoCoor());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(mContext.getPackageManager()) != null) {
                    mContext.startActivity(mapIntent);
                }
            }
        });
        holder.mBookNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = restaurantItem.getUrl();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                mContext.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mRestaurantItems.size();
    }

    public static class RestaurantViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.restaurant_img_main_card_1)
        ImageView mImageView;
        @BindView(R.id.restaurant_tv_card_main_1_title)
        TextView mTitle;
        @BindView(R.id.restaurant_btn_card_main1_action1)
        MaterialButton mOnMap;
        @BindView(R.id.restaurant_btn_card_main2_action1)
        MaterialButton mBookNow;

        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
