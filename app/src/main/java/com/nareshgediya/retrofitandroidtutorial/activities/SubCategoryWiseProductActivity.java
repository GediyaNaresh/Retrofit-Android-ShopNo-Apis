package com.nareshgediya.retrofitandroidtutorial.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nareshgediya.retrofitandroidtutorial.R;
import com.nareshgediya.retrofitandroidtutorial.adapters.AllProductAdapter;
import com.nareshgediya.retrofitandroidtutorial.api.RetrofitClient;
import com.nareshgediya.retrofitandroidtutorial.models.Product;
import com.nareshgediya.retrofitandroidtutorial.models.SubcategoryProduct;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubCategoryWiseProductActivity extends AppCompatActivity {

    private AllProductAdapter allProductAdapter;
    private RecyclerView recyclerView;
    private TextView textView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category_wise_product);

        String id = getIntent().getStringExtra("id");
        String name = getIntent().getStringExtra("name");

        progressBar = findViewById(R.id.progreebar1);
        Resources res = getResources();
        progressBar.setProgressDrawable(res.getDrawable(R.drawable.p));

        //    getSupportActionBar().setTitle(name);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>" + name + "</font>"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Customize the back button
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_round_arrow_back_ios_24);


// Get the Drawable custom_progressbar
// set the drawable as progress drawable

        progressBar.setVisibility(View.VISIBLE);


        recyclerView = findViewById(R.id.productRV);
        textView = findViewById(R.id.notext);

        allProductAdapter = new AllProductAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(allProductAdapter);
        setUpdata(id);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setUpdata(String id) {

        Call<SubcategoryProduct> call = RetrofitClient
                .getInstance().getApi().getSubCategoryWiseProduct(id);

        List<Product> productList = new ArrayList<>();


        call.enqueue(new Callback<SubcategoryProduct>() {
            @Override
            public void onResponse(Call<SubcategoryProduct> call, Response<SubcategoryProduct> response) {
                if (response.isSuccessful()) {
                    progressBar.setVisibility(View.GONE);
                    if (response.body().getData().getSubcategory() != null) {
                        textView.setVisibility(View.INVISIBLE);
                        if (response.body().getData().getProducts().size() == 0) {
                            textView.setVisibility(View.VISIBLE);
                        }
                        for (Product product : response.body().getData().getProducts()) {
                            productList.add(product);
                        }
                        Log.d("TAG", "SubCategory  " + response.body().getData().getProducts().size());
                        Log.d("TAG", "SubCategory  " + response.body().getMsg());

                        if (productList != null) {
                            allProductAdapter.setListData(productList);
                        }
                    } else {
                        progressBar.setVisibility(View.GONE);
                        textView.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void onFailure(Call<SubcategoryProduct> call, Throwable t) {
                Log.d("TAG", "SubCategory" + t.getLocalizedMessage());
                Log.d("TAG", "SubCategory" + t.getMessage());

            }
        });

    }
}