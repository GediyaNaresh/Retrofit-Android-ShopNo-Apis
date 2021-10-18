package com.nareshgediya.retrofitandroidtutorial.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nareshgediya.retrofitandroidtutorial.R;
import com.nareshgediya.retrofitandroidtutorial.adapters.SubCategoryAdpter;
import com.nareshgediya.retrofitandroidtutorial.api.RetrofitClient;
import com.nareshgediya.retrofitandroidtutorial.models.CategoryResponse;
import com.nareshgediya.retrofitandroidtutorial.models.Subcategory;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryWiseProductActivity extends AppCompatActivity {

    private SubCategoryAdpter subCategoryAdpter;
    private RecyclerView recyclerView;
    private TextView textView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_wise_product);

        String id = getIntent().getStringExtra("id");
        String name = getIntent().getStringExtra("name");

        progressBar = findViewById(R.id.progreebar1);
        progressBar.setVisibility(View.VISIBLE);

        //    getSupportActionBar().setTitle(name);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>" + name + "</font>"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Customize the back button
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_round_arrow_back_ios_24);

        recyclerView = findViewById(R.id.subcategoryRV);
        textView = findViewById(R.id.notext);

        subCategoryAdpter = new SubCategoryAdpter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(subCategoryAdpter);
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

        Call<CategoryResponse> call = RetrofitClient
                .getInstance().getApi().getCategoryWiseProduct(id);

        List<Subcategory> subcategoryList = new ArrayList<>();


        call.enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                if (response.isSuccessful()) {
                    progressBar.setVisibility(View.INVISIBLE);
                    if (response.body().getData().getSubcategory() != null) {
                        textView.setVisibility(View.INVISIBLE);
                        for (Subcategory subcategory : response.body().getData().getSubcategory()) {
                            subcategoryList.add(subcategory);
                        }
                        if (subcategoryList != null) {
                            subCategoryAdpter.setListData(subcategoryList);
                        }

                    } else {
                        progressBar.setVisibility(View.INVISIBLE);
                        textView.setVisibility(View.VISIBLE);

                    }
                }
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                Log.d("TAG", t.getLocalizedMessage());
                Log.d("TAG", t.getMessage());
                Log.d("TAG", t.getCause().toString());
            }
        });

    }
}