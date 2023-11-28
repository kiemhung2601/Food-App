package com.example.firstapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.firstapp.R;
import com.example.firstapp.api_services.base_services.NetworkException;
import com.example.firstapp.databinding.FragmentLoginBinding;
import com.example.firstapp.api_services.base_services.BaseRespone;
import com.example.firstapp.extension.CustomToast;
import com.example.firstapp.model.Product;
import com.example.firstapp.model.TestHome;
import com.example.firstapp.model.User;
import com.example.firstapp.model.UserRequest;
import com.example.firstapp.repository.LoginRepository;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding;
    private LoginRepository loginRepository = new LoginRepository();
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        listenEditText();
        OnClick();
    }

    private void listenEditText(){
        binding.edtAccount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Pattern mPattern = Pattern.compile("^0([0-9]{9})");
                Matcher matcher = mPattern.matcher(s.toString());

                if(s.toString().trim().equalsIgnoreCase("")){
                    binding.tilAccount.setError("Tài khoản không được để trống");
                } else if(!matcher.find()){
                    binding.tilAccount.setError("Tài khoản phải là số điện thoại");
                } else {
                    binding.tilAccount.setError(null);
                }
            }
        });

        binding.edtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Pattern mPattern = Pattern.compile("^[a-zA-Z0-9 ~`!@#$%^&*()-_=+]{8,50}");
                Matcher matcher = mPattern.matcher(s.toString());

                if(s.toString().trim().equalsIgnoreCase("")){
                    binding.tilPassword.setError("Mật khẩu không được để trống");
                } else if(!matcher.find()){
                    binding.tilPassword.setError("Vui lòng nhập chữ không dấu, số, ký tự đặc biệt (bao gồm khoảng trắng)");
                } else {
                    binding.tilPassword.setError(null);
                }
            }
        });
    }

    private void OnClick(){
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.tilAccount.isErrorEnabled() && binding.tilPassword.isErrorEnabled() ){
                    loginRepository.login(binding.edtAccount.getText().toString(), binding.edtPassword.getText().toString()).enqueue(new Callback<BaseRespone<User>>() {
                        @Override
                        public void onResponse(Call<BaseRespone<User>> call, Response<BaseRespone<User>> response) {
                            try {
                                User user = NetworkException.converJson(response);
                                navController.navigate(R.id.action_loginFragment_to_dashboardFragment);
                            } catch(NetworkException e){
                                CustomToast.makeText(getActivity(),e.getStatusText(),CustomToast.LENGTH_LONG,CustomToast.ERROR,true).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<BaseRespone<User>> call, Throwable t) {
                            CustomToast.makeText(getActivity(),t.getMessage(),CustomToast.LENGTH_LONG,CustomToast.ERROR,true).show();
                        }
                    });

                } else {
                    CustomToast.makeText(getActivity(),"Thông tin đăng nhập chưa đúng",CustomToast.LENGTH_LONG,CustomToast.WARNING,true).show();
                }
            }
        });

        binding.tvRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CustomToast.makeText(getActivity(),"Chức năng đang phát triển",CustomToast.LENGTH_LONG,CustomToast.CONFUSING,true).show();
//                loginRepository.getProduct().enqueue(new Callback<BaseRespone<List<TestHome>>>() {
//                    @Override
//                    public void onResponse(Call<BaseRespone<List<TestHome>>> call, Response<BaseRespone<List<TestHome>>> response) {
//                        try{
//                            List<TestHome> lst = NetworkException.converJson(response);
//                            System.out.println("THÀNH CÔNG: ");
//                        } catch(NetworkException e){
//                            CustomToast.makeText(getActivity(),e.getStatusText(),CustomToast.LENGTH_LONG,CustomToast.ERROR,true).show();
//                        }
//                    }
//                    @Override
//                    public void onFailure(Call<BaseRespone<List<TestHome>>> call, Throwable t) {
//                        CustomToast.makeText(getActivity(),t.getMessage(),CustomToast.LENGTH_LONG,CustomToast.ERROR,true).show();
//                    }
//                });
            }
        });

        binding.tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CustomToast.makeText(getActivity(),"Chức năng đang phát triển",CustomToast.LENGTH_LONG,CustomToast.CONFUSING,true).show();
            }
        });
    }
}