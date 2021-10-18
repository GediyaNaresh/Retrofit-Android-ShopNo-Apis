package com.nareshgediya.retrofitandroidtutorial.activities;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import com.nareshgediya.retrofitandroidtutorial.R;
import com.nareshgediya.retrofitandroidtutorial.api.RetrofitClient;
import com.nareshgediya.retrofitandroidtutorial.models.DResponse;
import com.nareshgediya.retrofitandroidtutorial.models.SingleProduct;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    TextView price, oldPrice, weight, desc, quantity, quantityTV, shipping, textTotal;
    ImageView imageView;
    Button addToCartBtn;
    int totalQuantity = 1;
    int totalPrice = 0;
    String available = "";
    ImageView add, remove;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        price = findViewById(R.id.product_price);
        addToCartBtn = findViewById(R.id.addtocart);
        imageView = findViewById(R.id.product_image);
        oldPrice = findViewById(R.id.oldpricecount);
        weight = findViewById(R.id.weightCount);
        desc = findViewById(R.id.description);
        quantity = findViewById(R.id.quantity2Count);
        shipping = findViewById(R.id.quntityCount);

        add = findViewById(R.id.add1);
        remove = findViewById(R.id.remove1);
        quantityTV = findViewById(R.id.quntity);
        textTotal = findViewById(R.id.totalPrice);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.ctoolbar);
        String name = getIntent().getStringExtra("name");
        String id = getIntent().getStringExtra("id");
        String image = getIntent().getStringExtra("image");
        String priceT = getIntent().getStringExtra("price");

        collapsingToolbarLayout.setTitle(name);
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.yellow));
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.white));

        getSingleProduct(id, image);

        add.setOnClickListener(view -> {
            if (totalQuantity < Integer.parseInt(available)) {
                totalQuantity++;
                quantityTV.setText(String.valueOf(totalQuantity));
                totalPrice = totalQuantity * Integer.parseInt(priceT);
                textTotal.setText("₹ " + totalPrice);
            } else {
                Toast.makeText(DetailActivity.this, "Quantity Not Available", Toast.LENGTH_SHORT).show();
            }
        });

        remove.setOnClickListener(view -> {

            if (totalQuantity > 1) {
                totalQuantity--;
                quantityTV.setText(String.valueOf(totalQuantity));
                totalPrice = totalQuantity * Integer.parseInt(priceT);
                textTotal.setText("₹ " + totalPrice);
            }
        });

        addToCartBtn.setOnClickListener(view -> addTocart(id, "1", String.valueOf(totalQuantity)));
    }


    private void getSingleProduct(String id, String image) {

        Call<SingleProduct> singleProductCall = RetrofitClient.getInstance().getApi().getSingleProduct(id);

        singleProductCall.enqueue(new Callback<SingleProduct>() {
            @Override
            public void onResponse(Call<SingleProduct> call, Response<SingleProduct> response) {
                if (response.isSuccessful()) {
                    Glide.with(DetailActivity.this)
                            .load("https://shopno.in/gujjustore.in/uploads/product/" + image)
                            .into(imageView);

                    String pri = response.body().getData().getProducts().getNewPrice();
                    String opri = response.body().getData().getProducts().getOldPrice();
                    String shi = response.body().getData().getProducts().getShippingRate();
                    available = response.body().getData().getProducts().getQuantity();

                    price.setText("₹ " + pri + "/-");
                    textTotal.setText("₹ " + pri);
                    oldPrice.setText("₹ " + opri + "/-");
                    shipping.setText("₹ " + shi + "/-");
                    desc.setText(response.body().getData().getProducts().getFullDescription());
                    quantity.setText(response.body().getData().getProducts().getQuantity() + " pcs");
                    weight.setText(response.body().getData().getProducts().getWeight() + " Kg");
                }


            }

            @Override
            public void onFailure(Call<SingleProduct> call, Throwable t) {

                Toast.makeText(DetailActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void addTocart(String id, String user_id, String qty) {
        Call<DResponse> addTocartcall = RetrofitClient.getInstance().getApi().addTocart(id, user_id, qty);
        addTocartcall.enqueue(new Callback<DResponse>() {
            @Override
            public void onResponse(Call<DResponse> call, Response<DResponse> response) {
                Toast.makeText(DetailActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                finish();
                Log.d("TAG", response.body().getMsg());
            }

            @Override
            public void onFailure(Call<DResponse> call, Throwable t) {
                Toast.makeText(DetailActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.d("TAG", t.getLocalizedMessage());
            }
        });

    }


}