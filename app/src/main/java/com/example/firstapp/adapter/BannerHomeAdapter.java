package com.example.firstapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstapp.R;
import com.example.firstapp.model.BannerHome;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BannerHomeAdapter extends RecyclerView.Adapter<BannerHomeAdapter.BannerHomeViewHolder>{

    private List<BannerHome> lstImage;

    public BannerHomeAdapter(List<BannerHome> lstImage){
        this.lstImage = lstImage;
    }

    @NonNull
    @Override
    public BannerHomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_banner, parent, false);
        return new BannerHomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerHomeViewHolder holder, int position) {
        BannerHome bannerHome = lstImage.get(position);
        if(bannerHome == null){
            return;
        }
        Picasso.get().load(bannerHome.getUrl()).into(holder.imgBanner);

    }

    @Override
    public int getItemCount() {
        if(lstImage != null){
            return lstImage.size();
        }
        return 0;
    }

    public class BannerHomeViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgBanner;
        public BannerHomeViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBanner = itemView.findViewById(R.id.img_banner);
        }
    }
}
