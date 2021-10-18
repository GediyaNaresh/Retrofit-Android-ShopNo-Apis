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
import com.nareshgediya.retrofitandroidtutorial.adapters.OrderProductAdapter;
import com.nareshgediya.retrofitandroidtutorial.adapters.UsersAdapter;
import com.nareshgediya.retrofitandroidtutorial.models.User;

import java.util.List;


public class PendingOrderFragment extends Fragment {

    private RecyclerView recyclerView;
    private UsersAdapter adapter;
    private List<User> userList;
    private OrderProductAdapter orderProductAdapter;
    private MainViewModel mainViewModel;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("TAG", "OnCreateView");
        return inflater.inflate(R.layout.fragment_pending_order, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainViewModel = ViewModelProviders.of(requireActivity()).get(MainViewModel.class);

        orderProductAdapter = new OrderProductAdapter(getActivity());

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mainViewModel.makeCallOrderList();

        mainViewModel.getOrderProductlistObserver().observe(getActivity(), orderProducts -> {
            if (orderProducts.size() != 0) {
                orderProductAdapter.setList(orderProducts);
                recyclerView.setAdapter(orderProductAdapter);
                Log.d("TAG", orderProducts.toString());
            }
        });


    }


}
