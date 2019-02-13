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

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder> {

    private ArrayList<PlacesItems> mShoppingItems;
    private Context mContext;

    public ShoppingAdapter(Context context, ArrayList<PlacesItems> shoppingItems) {
        mShoppingItems = shoppingItems;
        mContext = context;
    }

    @NonNull
    @Override
    public ShoppingAdapter.ShoppingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.shopping_item, parent, false);
        return new ShoppingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingAdapter.ShoppingViewHolder holder, int position) {
        PlacesItems shoppingItem = mShoppingItems.get(position);

        holder.mTitle.setText(shoppingItem.getTitle());
        holder.mImageView.setImageResource(shoppingItem.getImageResource());
        holder.mOnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:" + shoppingItem.getGeoCoor() + "?z=18");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(mContext.getPackageManager()) != null) {
                    mContext.startActivity(mapIntent);
                }
            }
        });
        holder.mGoOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = shoppingItem.getUrl();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                mContext.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mShoppingItems.size();
    }

    public static class ShoppingViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.shopping_img_main_card_1)
        ImageView mImageView;
        @BindView(R.id.shopping_tv_card_main_1_title)
        TextView mTitle;
        @BindView(R.id.shopping_btn_card_main1_action1)
        MaterialButton mOnMap;
        @BindView(R.id.shopping_btn_card_main2_action1)
        MaterialButton mGoOnline;

        public ShoppingViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

