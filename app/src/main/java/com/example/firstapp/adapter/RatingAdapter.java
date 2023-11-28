package com.example.firstapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstapp.R;
import com.example.firstapp.model.Rating;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RatingAdapter extends RecyclerView.Adapter<RatingAdapter.RatingViewHolder>{

    private List<Rating> lstRating;

    public RatingAdapter(List<Rating> lstRating){
        this.lstRating = lstRating;
    }

    @NonNull
    @Override
    public RatingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_review_home, parent, false);
        return new RatingAdapter.RatingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RatingViewHolder holder, int position) {
        Rating rating = lstRating.get(position);
        if(rating == null){
            return;
        }
        holder.nameFood.setText(rating.getNameFood());
        holder.name.setText(rating.getName());
        holder.rating.setText(rating.getRating().toString());
        holder.review.setText(rating.getReview());

        Picasso.get().load(rating.getAvatar()).into(holder.avatar);
        Picasso.get().load(rating.getImageFood()).into(holder.imageFood);

        holder.ratingBar.setRating(rating.getRating().floatValue());
    }

    @Override
    public int getItemCount() {
        return lstRating.size();
    }

    public class RatingViewHolder extends RecyclerView.ViewHolder {
        private TextView nameFood, name, rating, review;
        private ImageView imageFood, avatar;
        private RatingBar ratingBar;

        public RatingViewHolder(@NonNull View itemView) {
            super(itemView);
            nameFood = itemView.findViewById(R.id.tv_name_food_ratings);
            name = itemView.findViewById(R.id.tv_name_ratings);
            rating = itemView.findViewById(R.id.tv_number_ratings);
            review = itemView.findViewById(R.id.tv_review_ratings);
            imageFood = itemView.findViewById(R.id.img_food_ratings);
            avatar = itemView.findViewById(R.id.img_person_ratings);
            ratingBar = itemView.findViewById(R.id.rb_ratings);
        }
    }
}
