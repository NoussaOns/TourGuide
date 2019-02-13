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

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {

    private ArrayList<PlacesItems> mHotelsItems;
    private Context mContext;

    public HotelAdapter(Context context, ArrayList<PlacesItems> hotelsItems) {
        mHotelsItems = hotelsItems;
        mContext = context;
    }

    @NonNull
    @Override
    public HotelAdapter.HotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.hotels_item,parent,false);
        return new HotelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelAdapter.HotelViewHolder holder, int position) {
        PlacesItems hotelsItem = mHotelsItems.get(position);

        holder.mTitle.setText(hotelsItem.getTitle());
        holder.mImageView.setImageResource(hotelsItem.getImageResource());
        holder.mPrice.setText(hotelsItem.getPrice());
        holder.mOnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:" + hotelsItem.getGeoCoor() + "?z=18");
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
                String url = hotelsItem.getUrl();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                mContext.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mHotelsItems.size();
    }

    public static class HotelViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.hotel_img_main_card_1)
        ImageView mImageView;
        @BindView(R.id.hotel_tv_card_main_1_title)
        TextView mTitle;
        @BindView(R.id.hotel_tv_card_main_1_price)
        TextView mPrice;
        @BindView(R.id.hotel_btn_card_main1_action1)
        MaterialButton mOnMap;
        @BindView(R.id.hotel_btn_card_main2_action1)
        MaterialButton mBookNow;

        public HotelViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
