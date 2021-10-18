package com.nareshgediya.retrofitandroidtutorial.ViewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nareshgediya.retrofitandroidtutorial.api.RetrofitClient;
import com.nareshgediya.retrofitandroidtutorial.models.AllProductResponse;
import com.nareshgediya.retrofitandroidtutorial.models.CartProduct;
import com.nareshgediya.retrofitandroidtutorial.models.CartResponse;
import com.nareshgediya.retrofitandroidtutorial.models.Category;
import com.nareshgediya.retrofitandroidtutorial.models.HomePage;
import com.nareshgediya.retrofitandroidtutorial.models.OrderProduct;
import com.nareshgediya.retrofitandroidtutorial.models.OrderResponse;
import com.nareshgediya.retrofitandroidtutorial.models.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    private MutableLiveData<List<Product>> allProductlist;
    private MutableLiveData<List<Category>> categoryList;
    private MutableLiveData<List<CartProduct>> cartProductList;
    private MutableLiveData<List<OrderProduct>> orderList;

    public MainViewModel() {
        allProductlist = new MutableLiveData<>();
        categoryList = new MutableLiveData<>();
        cartProductList = new MutableLiveData<>();
        orderList = new MutableLiveData<>();
    }

    public MutableLiveData<List<Product>> getAllProductlistObserver() {
        return allProductlist;
    }

    public MutableLiveData<List<OrderProduct>> getOrderProductlistObserver() {
        return orderList;
    }

    public MutableLiveData<List<Category>> getCategoryObserver() {
        return categoryList;
    }

    public MutableLiveData<List<CartProduct>> getCartProductList() {
        return cartProductList;
    }

    public void makeCallOrderList() {
        Call<OrderResponse> call = RetrofitClient
                .getInstance().getApi().getPendingOrder(1);
        call.enqueue(new Callback<OrderResponse>() {
            @Override
            public void onResponse(Call<OrderResponse> call, Response<OrderResponse> response) {
                if (response.isSuccessful()) {
                    List<OrderProduct> orderProducts = new ArrayList<>();
                    for (int i = 0; i < response.body().getData().getProducts().size(); i++) {
                        OrderProduct orderProduct = response.body().getData().getProducts().get(i);
                        if (orderProduct.getError() == null) {
                            orderProduct.setProductName(orderProduct.getProductName());
                            orderProduct.setNewPrice(orderProduct.getNewPrice());
                            orderProduct.setShippingRate(orderProduct.getShippingRate());
                            orderProduct.setQty(orderProduct.getQty());
                            orderProduct.setProductImg1(orderProduct.getProductImg1());

                            orderProducts.add(orderProduct);
                        } else {
                            orderProduct.setError(orderProduct.getError());
                            orderProduct.setQty(orderProduct.getQty());
                            orderProduct.setOrderId(orderProduct.getOrderId());
                            Log.d("TAG", "MVVVM Error" + orderProduct.getError());

                            orderProducts.add(orderProduct);
                        }
//                        orderProduct.setProductName(response.body().getData().getProducts().get(i).getProductName());


                    }
                    orderList.postValue(orderProducts);
                    Log.d("TAG", "OrdereCall  " + response.body().getData().getProducts().size());
                }
            }

            @Override
            public void onFailure(Call<OrderResponse> call, Throwable t) {
                orderList.postValue(null);
            }
        });

    }

    public void makeCallHomepage(String sort) {

        Call<HomePage> call = RetrofitClient
                .getInstance().getApi().getHomePage(1);

        Call<AllProductResponse> allproductCall = RetrofitClient
                .getInstance().getApi().getAllProduct(sort, "1");


        call.enqueue(new Callback<HomePage>() {
            @Override
            public void onResponse(Call<HomePage> call, Response<HomePage> response) {
                if (response.isSuccessful()) {
                    categoryList.postValue(response.body().getData().getCategory());
                }
            }

            @Override
            public void onFailure(Call<HomePage> call, Throwable t) {
                categoryList.postValue(null);
                Log.d("TAG", t.getLocalizedMessage());
            }
        });

        allproductCall.enqueue(new Callback<AllProductResponse>() {
            @Override
            public void onResponse(Call<AllProductResponse> call, Response<AllProductResponse> response) {
                allProductlist.postValue(response.body().getData().getProductList());
            }

            @Override
            public void onFailure(Call<AllProductResponse> call, Throwable t) {
                allProductlist.postValue(null);
            }
        });


    }

    public void makeCallCartProduct() {

        Call<CartResponse> call = RetrofitClient
                .getInstance().getApi().getCartList(1);

        call.enqueue(new Callback<CartResponse>() {
            @Override
            public void onResponse(Call<CartResponse> call, Response<CartResponse> response) {
                if (response.isSuccessful()) {
                    cartProductList.postValue(response.body().getData().getProducts());
                    Log.d("TAG", "MVVM    " + response.body().getData().getProducts().size());
                } else {
                    Log.d("TAG", response.message());
                }

            }

            @Override
            public void onFailure(Call<CartResponse> call, Throwable t) {
                cartProductList.postValue(null);
                Log.d("TAG", t.getLocalizedMessage());
            }
        });
    }

}
