package com.example.firstapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstapp.R;
import com.example.firstapp.model.MenuHome;

import java.util.List;

public class MenuHomeAdapter extends RecyclerView.Adapter<MenuHomeAdapter.MenuHomeViewHolder>{

    private List<MenuHome> lstMenu;

    public MenuHomeAdapter(List<MenuHome> lstMenu){
        this.lstMenu = lstMenu;
    }

    @NonNull
    @Override
    public MenuHomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_menu_home, parent, false);
        return new MenuHomeAdapter.MenuHomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuHomeViewHolder holder, int position) {
        MenuHome menu = lstMenu.get(position);
        if(menu == null){
            return;
        }

        holder.tvName.setText(menu.getName());
        holder.imgMenu.setImageResource(menu.getImage());
    }

    @Override
    public int getItemCount() {
        return lstMenu.size();
    }

    public class MenuHomeViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private ImageView imgMenu;

        public MenuHomeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name_menu);
            imgMenu = itemView.findViewById(R.id.img_menu_home);
        }
    }
}
