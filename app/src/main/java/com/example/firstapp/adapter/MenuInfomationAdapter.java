package com.example.firstapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstapp.R;
import com.example.firstapp.model.MenuInfo;

import java.util.List;

public class MenuInfomationAdapter extends RecyclerView.Adapter<MenuInfomationAdapter.MenuInfomationViewHolder>{
    private List<MenuInfo> lstMenu;
    public MenuInfomationAdapter(List<MenuInfo> lstMenu){
        this.lstMenu = lstMenu;
    }

    @NonNull
    @Override
    public MenuInfomationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_menu_info, parent, false);
        return new MenuInfomationAdapter.MenuInfomationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuInfomationViewHolder holder, int position) {
        MenuInfo menu = lstMenu.get(position);
        if(menu == null){
            return;
        }
        holder.tvMainMenu.setText(menu.getName());
        holder.imgMainMenu.setImageResource(menu.getImage());
    }

    @Override
    public int getItemCount() {
        return lstMenu.size();
    }

    public class MenuInfomationViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgMainMenu;
        private TextView tvMainMenu;
        public MenuInfomationViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMainMenu = itemView.findViewById(R.id.img_main_menu);
            tvMainMenu = itemView.findViewById(R.id.tv_main_menu);
        }
    }
}
