package com.example.firstapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.firstapp.R;
import com.example.firstapp.adapter.BannerHomeAdapter;
import com.example.firstapp.adapter.MenuHomeAdapter;
import com.example.firstapp.adapter.ProductAdapter;
import com.example.firstapp.adapter.RatingAdapter;
import com.example.firstapp.animation.ZoomOutPageTransformer;
import com.example.firstapp.databinding.FragmentHomeBinding;
import com.example.firstapp.model.BannerHome;
import com.example.firstapp.model.MenuHome;
import com.example.firstapp.model.Product;
import com.example.firstapp.model.Rating;
import com.example.firstapp.recyclerview.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private List<BannerHome> lstImage;
    private List<Product> lstProduct;
    private List<MenuHome> lstMenuHome;
    private List<Rating> lstRating;
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if(binding.vpBanner.getCurrentItem() == lstImage.size() - 1){
                binding.vpBanner.setCurrentItem(0);
            } else {
                binding.vpBanner.setCurrentItem(binding.vpBanner.getCurrentItem() + 1);
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ActionViewFlipper();
        loadMenuHome();
        loadRatingsHome();
        loadProduct();
    }

    private void ActionViewFlipper(){

        lstImage = new ArrayList<>();
        lstImage.add(new BannerHome("https://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/banner-Le-hoi-phu-kien-800-300.png"));
        lstImage.add(new BannerHome("https://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/banner-HC-Tra-Gop-800-300.png"));
        lstImage.add(new BannerHome("https://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/banner-big-ky-nguyen-800-300.jpg"));
        lstImage.add(new BannerHome("https://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/banner-big-ky-nguyen-800-300.jpg"));
        lstImage.add(new BannerHome("https://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/banner-big-ky-nguyen-800-300.jpg"));
        lstImage.add(new BannerHome("https://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/banner-big-ky-nguyen-800-300.jpg"));
        lstImage.add(new BannerHome("https://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/banner-big-ky-nguyen-800-300.jpg"));

        BannerHomeAdapter adapter = new BannerHomeAdapter(lstImage);
        binding.vpBanner.setAdapter(adapter);

        binding.ciBanner.setViewPager(binding.vpBanner);

        binding.vpBanner.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 5000);
            }
        });

        binding.vpBanner.setPageTransformer(new ZoomOutPageTransformer());
    }

    private void loadProduct(){

        lstProduct = new ArrayList<>();
        lstProduct.add(new Product(1, "https://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/banner-Le-hoi-phu-kien-800-300.png", "Cơm sườn", 30000, 1.5));
        lstProduct.add(new Product(2, "https://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/banner-Le-hoi-phu-kien-800-300.png", "Cơm gà", 25000, 2.5));
        lstProduct.add(new Product(3, "https://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/banner-Le-hoi-phu-kien-800-300.png", "Cơm trứng", 30000, 4.0));
        lstProduct.add(new Product(4, "https://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/banner-Le-hoi-phu-kien-800-300.png", "Cơm nêu", 45000, 5.0));
        lstProduct.add(new Product(5, "https://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/banner-Le-hoi-phu-kien-800-300.png", "Cơm sườn bì", 35000,3.2));
        lstProduct.add(new Product(6, "https://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/banner-Le-hoi-phu-kien-800-300.png", "Cơm cá kho", 20000, 3.0));
        lstProduct.add(new Product(8, "https://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/banner-Le-hoi-phu-kien-800-300.png", "Cơm tép", 420002,2.0));
        lstProduct.add(new Product(9, "https://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/banner-Le-hoi-phu-kien-800-300.png", "Cơm khổ qua", 24000, 1.0));
        lstProduct.add(new Product(10, "https://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/banner-Le-hoi-phu-kien-800-300.png", "Gà chiên", 15000, 0.5));

        ProductAdapter adapter = new ProductAdapter(lstProduct);
        binding.rcvProducts.addItemDecoration(new DividerItemDecoration(40, 40));
        binding.rcvProducts.setAdapter(adapter);
        binding.rcvProducts.setHasFixedSize(true);
        binding.rcvProducts.setNestedScrollingEnabled(false);
        binding.rcvProducts.setLayoutManager(new GridLayoutManager(getContext(), 2));
    }

    private void loadMenuHome(){
        lstMenuHome = new ArrayList<>();
        lstMenuHome.add(new MenuHome("Thức ăn chính", R.drawable.menu_food));
        lstMenuHome.add(new MenuHome("Nước uống", R.drawable.menu_drink));
        lstMenuHome.add(new MenuHome("Lẩu", R.drawable.menu_hotpot));
        lstMenuHome.add(new MenuHome("Đồ nướng", R.drawable.menu_grill));
        lstMenuHome.add(new MenuHome("Đồ sống", R.drawable.menu_shushi));
        lstMenuHome.add(new MenuHome("Nước uống có cồn", R.drawable.menu_alcohol));

        MenuHomeAdapter adapter = new MenuHomeAdapter(lstMenuHome);
        binding.rcvMenuHome.addItemDecoration(new DividerItemDecoration(0, 30));
        binding.rcvMenuHome.setAdapter(adapter);
        binding.rcvMenuHome.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    private void loadRatingsHome(){
        lstRating = new ArrayList<>();
        lstRating.add(new Rating("Gà chiên nước mắm", "https://i.imgur.com/M6BqXMm.jpg", "https://cdn-icons-png.flaticon.com/512/5556/5556468.png", "Dang Kiem hung", 4.5, "Đây là nọi dung đánh giá, chào bạn đến với app của Kiếm hùng. Món ăn nay rất ngon và giá rẻ, bạn thưởng thức no trong troi đông giá rét thì tuyệt vời, cứu mèo, con đà điểu"));
        lstRating.add(new Rating("Lẩu độ", "https://i.imgur.com/I9qOBU0.jpg", "https://cdn-icons-png.flaticon.com/512/5556/5556468.png", "John carry", 3.7, "Đây là nọi dung đánh giá, chào bạn đến với app của Kiếm hùng. Món ăn nay rất ngon và giá rẻ, bạn thưởng thức no trong troi đông giá rét thì tuyệt vời, cứu mèo, con đà điểu"));
        lstRating.add(new Rating("Sà bì chưởng", "https://i.imgur.com/M6BqXMm.jpg", "https://cdn-icons-png.flaticon.com/512/5556/5556468.png", "Mical Dem", 4.0, "Đây là nọi dung đánh giá, chào bạn đến với app của Kiếm hùng. Món ăn nay rất ngon và giá rẻ, bạn thưởng thức no trong troi đông giá rét thì tuyệt vời, cứu mèo, con đà điểu"));
        lstRating.add(new Rating("Cơm chiên", "https://i.imgur.com/I9qOBU0.jpg", "https://cdn-icons-png.flaticon.com/512/5556/5556468.png", "John cena", 3.5, "Đây là nọi dung đánh giá, chào bạn đến với app của Kiếm hùng. Món ăn nay rất ngon và giá rẻ, bạn thưởng thức no trong troi đông giá rét thì tuyệt vời, cứu mèo, con đà điểu"));
        lstRating.add(new Rating("Nươớc dừa", "https://i.imgur.com/M6BqXMm.jpg", "https://cdn-icons-png.flaticon.com/512/5556/5556468.png", "Beach Water", 2.0, "Đây là nọi dung đánh giá, chào bạn đến với app của Kiếm hùng. Món ăn nay rất ngon và giá rẻ, bạn thưởng thức no trong troi đông giá rét thì tuyệt vời, cứu mèo, con đà điểu"));

        RatingAdapter adapter = new RatingAdapter(lstRating);
        binding.rcvRatingsHome.addItemDecoration(new DividerItemDecoration(0, 100));
        binding.rcvRatingsHome.setAdapter(adapter);
        binding.rcvRatingsHome.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        handler.postDelayed(runnable, 5000);
    }
}