package com.nareshgediya.retrofitandroidtutorial.fragments;

import android.os.Bundle;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nareshgediya.retrofitandroidtutorial.R;
import com.nareshgediya.retrofitandroidtutorial.ViewModel.MainViewModel;
import com.nareshgediya.retrofitandroidtutorial.adapters.AllProductAdapter;
import com.nareshgediya.retrofitandroidtutorial.adapters.CartProductAdapter;
import com.nareshgediya.retrofitandroidtutorial.adapters.UsersAdapter;
import com.nareshgediya.retrofitandroidtutorial.api.RetrofitClient;
import com.nareshgediya.retrofitandroidtutorial.models.CartProduct;
import com.nareshgediya.retrofitandroidtutorial.models.CartResponse;
import com.nareshgediya.retrofitandroidtutorial.models.Product;
import com.nareshgediya.retrofitandroidtutorial.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CartFragment extends Fragment {

    private RecyclerView recyclerView;
    private UsersAdapter adapter;
    private List<User> userList;
    private CartProductAdapter cartProductAdapter;
    private AllProductAdapter allProductAdapter;
    private MainViewModel mainViewModel;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("TAG", "OnCreateView");
        return inflater.inflate(R.layout.users_fragment, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainViewModel = ViewModelProviders.of(requireActivity()).get(MainViewModel.class);
        mainViewModel.makeCallCartProduct();

        cartProductAdapter = new CartProductAdapter(getActivity());

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        mainViewModel.getCartProductList().observe(getActivity(), cartProducts ->
                {
                    if (cartProducts != null) {
                        cartProductAdapter.setList(cartProducts);
                        Log.d("TAG", "Fragment   " + cartProducts.size());
                        recyclerView.setAdapter(cartProductAdapter);

                    }
                }
        );

//        Call<CartResponse> call = RetrofitClient.getInstance().getApi().getCartList(1);
//
//        call.enqueue(new Callback<CartResponse>() {
//            @Override
//            public void onResponse(Call<CartResponse> call, Response<CartResponse> response) {
//                if (response.isSuccessful()){
//                    cartProductsList = response.body().getData().getProducts();
//                    cartProductAdapter = new CartProductAdapter(getActivity(), cartProductsList);
//                    cartProductAdapter.notifyDataSetChanged();
//                    recyclerView.setAdapter(cartProductAdapter);
//                    Log.d("TAG","Fragment "+cartProductAdapter.getItemCount());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<CartResponse> call, Throwable t) {
//
//            }
//        });


//        Call<UsersResponse> call = RetrofitClient.getInstance().getApi().getUsers();
//
//        call.enqueue(new Callback<UsersResponse>() {
//            @Override
//            public void onResponse(Call<UsersResponse> call, Response<UsersResponse> response) {
//                userList = response.body().getUsers();
//                adapter = new UsersAdapter(getActivity(), userList);
//                recyclerView.setAdapter(adapter);
//            }
//
//            @Override
//            public void onFailure(Call<UsersResponse> call, Throwable t) {
//
//            }
//        });


    }


}
