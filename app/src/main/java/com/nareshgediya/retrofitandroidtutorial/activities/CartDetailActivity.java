package com.nareshgediya.retrofitandroidtutorial.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import com.nareshgediya.retrofitandroidtutorial.R;
import com.nareshgediya.retrofitandroidtutorial.ViewModel.MainViewModel;
import com.nareshgediya.retrofitandroidtutorial.adapters.CartProductAdapter;
import com.nareshgediya.retrofitandroidtutorial.api.RetrofitClient;
import com.nareshgediya.retrofitandroidtutorial.models.CartProduct;
import com.nareshgediya.retrofitandroidtutorial.models.DResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartDetailActivity extends AppCompatActivity {
    TextView price, oldPriceT, desc, quantity, shippingT, textTotal;
    ImageView imageView;
    Button remove;
    int totalprice;

    MainViewModel mainViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_detail);

        price = findViewById(R.id.product_price);
        imageView = findViewById(R.id.product_image);
        oldPriceT = findViewById(R.id.oldpricecount);
        desc = findViewById(R.id.description);
        quantity = findViewById(R.id.quantity2Count);
        shippingT = findViewById(R.id.quntityCount);
        textTotal = findViewById(R.id.totalPrice);
        remove = findViewById(R.id.remove);


        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.ctoolbar);
        String name = getIntent().getStringExtra("name");
        String id = getIntent().getStringExtra("id");
        String image = getIntent().getStringExtra("image");
        String priceT = getIntent().getStringExtra("price");
        String oldPrice = getIntent().getStringExtra("oldprice");
        String quantity2 = getIntent().getStringExtra("qty");
        String shipping = getIntent().getStringExtra("shippibg");
        int position = getIntent().getIntExtra("position", 0);


        totalprice = Integer.parseInt(priceT) * Integer.parseInt(quantity2);
        totalprice += Integer.parseInt(shipping);
        textTotal.setText("₹ " + totalprice + " /-");

        collapsingToolbarLayout.setTitle(name);
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.yellow));
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.white));

        Glide.with(CartDetailActivity.this)
                .load("https://shopno.in/gujjustore.in/uploads/product/" + image)
                .into(imageView);

        price.setText("₹ " + priceT);
        shippingT.setText("₹ " + shipping);
        oldPriceT.setText("₹ " + oldPrice);
        quantity.setText(quantity2 + " Pcs");


        remove.setOnClickListener(view -> {
            Call<DResponse> callRemove = RetrofitClient.getInstance().getApi().
                    removeFromCart(id, "1");

            callRemove.enqueue(new Callback<DResponse>() {
                @Override
                public void onResponse(Call<DResponse> call, Response<DResponse> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(CartDetailActivity.this, name + " Removed", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }

                @Override
                public void onFailure(Call<DResponse> call, Throwable t) {

                }
            });
        });


    }


}
