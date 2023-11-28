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
import com.example.firstapp.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private List<Product> lstProduct;

    public ProductAdapter(List<Product> lstProduct) {
        this.lstProduct = lstProduct;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_product, parent, false);
        return new ProductAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = lstProduct.get(position);
        if(product == null){
            return;
        }
        Picasso.get().load(product.getImage()).into(holder.imageView);

        holder.price.setText(product.getPrice() + "đ");

        holder.name.setText(product.getName());

        holder.ratingBar.setRating(product.getRating().floatValue());

    }

    @Override
    public int getItemCount() {
        return lstProduct.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView name, price;
        private RatingBar ratingBar;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_product);
            name = itemView.findViewById(R.id.tv_name);
            price = itemView.findViewById(R.id.tv_price);
            ratingBar = itemView.findViewById(R.id.rb_ratings_product);
        }
    }
}
