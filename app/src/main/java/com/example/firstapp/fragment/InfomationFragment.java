package com.example.firstapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.firstapp.R;
import com.example.firstapp.adapter.MenuHomeAdapter;
import com.example.firstapp.adapter.MenuInfomationAdapter;
import com.example.firstapp.databinding.FragmentHomeBinding;
import com.example.firstapp.databinding.FragmentInfomationBinding;
import com.example.firstapp.model.MenuHome;
import com.example.firstapp.model.MenuInfo;
import com.example.firstapp.recyclerview.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class InfomationFragment extends Fragment {
    private FragmentInfomationBinding binding;
    private List<MenuInfo> lstInfo;
    private NavController navController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInfomationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        loadMenuHome();
        binding.tvName.setText("TESSTTT");
        binding.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_dashboardFragment_to_loginFragment);
            }
        });
    }

    private void loadMenuHome(){
        lstInfo = new ArrayList<>();
        lstInfo.add(new MenuInfo(1, R.drawable.ic_logo, "Thông tin cá nhân"));
        lstInfo.add(new MenuInfo(2, R.drawable.ic_logo, "Ví điểm"));
        lstInfo.add(new MenuInfo(3, R.drawable.ic_logo, "Lịch sử đơn hàng"));
        lstInfo.add(new MenuInfo(4, R.drawable.ic_logo, "Hỗ trợ"));
        lstInfo.add(new MenuInfo(5, R.drawable.ic_logo, "Cài đặt"));

        MenuInfomationAdapter adapter = new MenuInfomationAdapter(lstInfo);
        binding.rcvMenuInfo.addItemDecoration(new DividerItemDecoration(30, 0));
        binding.rcvMenuInfo.setAdapter(adapter);
        binding.rcvMenuInfo.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false));
    }
}