package com.nareshgediya.retrofitandroidtutorial.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.nareshgediya.retrofitandroidtutorial.ViewModel.MainViewModel;
import com.nareshgediya.retrofitandroidtutorial.storage.SharedPrefManager;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import com.nareshgediya.retrofitandroidtutorial.R;
import com.nareshgediya.retrofitandroidtutorial.adapters.AllProductAdapter;
import com.nareshgediya.retrofitandroidtutorial.adapters.CategoryAdpter;
import com.nareshgediya.retrofitandroidtutorial.adapters.SliderAdapterExample;
import com.nareshgediya.retrofitandroidtutorial.adapters.SliderAdapterHomepage;
import com.nareshgediya.retrofitandroidtutorial.api.RetrofitClient;
import com.nareshgediya.retrofitandroidtutorial.models.Category;
import com.nareshgediya.retrofitandroidtutorial.models.HomePage;
import com.nareshgediya.retrofitandroidtutorial.models.Product;
import com.nareshgediya.retrofitandroidtutorial.models.SliderItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private Context mContext;
    private TextView textViewEmail, textViewName, textViewDetails;
    private static String TAG = "LoginActivity";
    SliderView sliderView;
    private Button buttonSort;

    private AllProductAdapter allProductAdapter;
    private SliderAdapterExample adapter;
    private SliderAdapterHomepage sliderAdapterHomepage;
    private CategoryAdpter categoryAdpter;
    private RecyclerView recyclerView, allrecycler;
    private ProgressBar progressBar;
    private MainViewModel mainViewModel;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.new_home_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);

        sliderView = view.findViewById(R.id.imageSlider);
        recyclerView = view.findViewById(R.id.categoryRV);
        allrecycler = view.findViewById(R.id.allproductRV);
        progressBar = view.findViewById(R.id.progreebar1);
        buttonSort = view.findViewById(R.id.sort);
        progressBar.setVisibility(View.VISIBLE);

        mainViewModel.makeCallHomepage(SharedPrefManager.getInstance(mContext).getSort());

        categoryAdpter = new CategoryAdpter(getActivity());

        adapter = new SliderAdapterExample(getActivity());
        allProductAdapter = new AllProductAdapter(getActivity());

        buttonSort.setOnClickListener(v -> {
            showBottomSheet();
        });

        mainViewModel.getAllProductlistObserver().observe(getActivity(), products -> {
            progressBar.setVisibility(View.INVISIBLE);
            if (products != null) {
                allProductAdapter.setListData(products);
            }
        });

        mainViewModel.getCategoryObserver().observe(getActivity(), categoryList -> {
            progressBar.setVisibility(View.INVISIBLE);
            if (categoryList != null) {
                categoryAdpter.setListData(categoryList);
            }
        });

        sliderAdapterHomepage = new SliderAdapterHomepage(getActivity());


        sliderView.setSliderAdapter(sliderAdapterHomepage);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_RIGHT);
        sliderView.setScrollTimeInSec(2);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(categoryAdpter);

        allrecycler.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        allrecycler.setAdapter(allProductAdapter);

        sliderView.setOnIndicatorClickListener(new DrawController.ClickListener() {
            @Override
            public void onIndicatorClicked(int position) {
                sliderView.setCurrentPagePosition(position);
                // Log.i("GGG", "onIndicatorClicked: " + sliderView.getCurrentPagePosition());
            }
        });
        setdataHomePage();
    }

    private void showBottomSheet() {

        View view = getLayoutInflater().inflate(R.layout.fragment_bottom_sheet, null);
        ImageView downArrow = view.findViewById(R.id.downarrow);
        TextView hightolow = view.findViewById(R.id.hightolow);
        TextView lowtohigh = view.findViewById(R.id.lowtohigh);
        TextView oldtonew = view.findViewById(R.id.oldtonew);
        TextView newtoold = view.findViewById(R.id.newtoold);


        BottomSheetDialog dialog = new BottomSheetDialog(mContext);
        dialog.setContentView(view);
        dialog.show();

        if (SharedPrefManager.getInstance(mContext).getSort().equals("high_to_low")) {
            hightolow.setBackgroundColor(getResources().getColor(R.color.itemSelect));
        } else if
        (SharedPrefManager.getInstance(mContext).getSort().equals("old_to_new")) {
            oldtonew.setBackgroundColor(getResources().getColor(R.color.itemSelect));
        } else if
        (SharedPrefManager.getInstance(mContext).getSort().equals("new_to_old")) {
            newtoold.setBackgroundColor(getResources().getColor(R.color.itemSelect));
        } else if
        (SharedPrefManager.getInstance(mContext).getSort().equals("low_to_high")) {
            lowtohigh.setBackgroundColor(getResources().getColor(R.color.itemSelect));
        }

        downArrow.setOnClickListener(v -> {
            dialog.dismiss();
        });

        hightolow.setOnClickListener(v -> {
                    Toast.makeText(mContext, "High to low", Toast.LENGTH_SHORT).show();
                    SharedPrefManager.getInstance(mContext).setSort("high_to_low");
                    mainViewModel.makeCallHomepage(SharedPrefManager.getInstance(mContext).getSort());
                    v.setBackgroundColor(getResources().getColor(R.color.itemSelect));
                    oldtonew.setBackground(null);
                    newtoold.setBackground(null);
                    lowtohigh.setBackground(null);


                }
        );
        oldtonew.setOnClickListener(v -> {
                    Toast.makeText(mContext, "Old to New", Toast.LENGTH_SHORT).show();
                    SharedPrefManager.getInstance(mContext).setSort("old_to_new");
                    mainViewModel.makeCallHomepage(SharedPrefManager.getInstance(mContext).getSort());
                    v.setBackgroundColor(getResources().getColor(R.color.itemSelect));
                    hightolow.setBackground(null);
                    newtoold.setBackground(null);
                    lowtohigh.setBackground(null);
                }
        );
        newtoold.setOnClickListener(v -> {
                    Toast.makeText(mContext, "New to Old", Toast.LENGTH_SHORT).show();
                    SharedPrefManager.getInstance(mContext).setSort("new_to_old");
                    mainViewModel.makeCallHomepage(SharedPrefManager.getInstance(mContext).getSort());
                    v.setBackgroundColor(getResources().getColor(R.color.itemSelect));
                    hightolow.setBackground(null);
                    oldtonew.setBackground(null);
                    lowtohigh.setBackground(null);
                }
        );
        lowtohigh.setOnClickListener(v -> {
                    Toast.makeText(mContext, "Low to High", Toast.LENGTH_SHORT).show();
                    SharedPrefManager.getInstance(mContext).setSort("low_to_high");
                    mainViewModel.makeCallHomepage(SharedPrefManager.getInstance(mContext).getSort());
                    v.setBackgroundColor(getResources().getColor(R.color.itemSelect));
                    hightolow.setBackground(null);
                    oldtonew.setBackground(null);
                    newtoold.setBackground(null);
                }
        );
    }

    private void setdataHomePage() {
        Call<HomePage> call = RetrofitClient
                .getInstance().getApi().getHomePage(1);

        Call<HomePage> callcategory = RetrofitClient
                .getInstance().getApi().getHomePage(1);
        List<String> sliderList = new ArrayList<>();

        List<Category> categoryList = new ArrayList<>();
        //     List<Product> productList = new ArrayList<>();
        call.enqueue(new Callback<HomePage>() {
            @Override
            public void onResponse(Call<HomePage> call, Response<HomePage> response) {
                if (response.isSuccessful() && response.body() != null) {
                    progressBar.setVisibility(View.INVISIBLE);
                    for (int i = 0; i < response.body().getData().getSlider().size(); i++) {
                        sliderList.add(response.body().getData().getSlider().get(i));
                    }
                    Log.d("TAG", "" + response.body().getFlag());
                    Log.d("TAG", "" + response.body().getData().getSlider());
                    Log.d("TAG", "" + sliderList);
                    sliderAdapterHomepage.setmSliderItems(sliderList);
                }
//                    if (response.body().getData().getProducts().size() != 0) {
//                        progressBar.setVisibility(View.INVISIBLE);
//                        for (Product product : response.body().getData().getProducts()) {
//                            productList.add(product);
//                        }
//                        Log.d("TAG", "Allpro  " + response.body().getData().getProducts().size());
//                        Log.d("TAG", "AllProduct  " + response.body().getMsg());
//                    }
//                    if (productList != null) {
//                        allProductAdapter.setListData(productList);
//                    }
            }


            @Override
            public void onFailure(Call<HomePage> call, Throwable t) {
                //  Toast.makeText(getContext().getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.INVISIBLE);
                Log.d("TAG", t.getLocalizedMessage());
            }
        });


        //Direct Call For Get category
//        callcategory.enqueue(new Callback<HomePage>() {
//            @Override
//            public void onResponse(Call<HomePage> call, Response<HomePage> response) {
//                if (response.isSuccessful() && response.body()!= null){
//                    progressBar.setVisibility(View.INVISIBLE);
//                    for (int i = 0; i<response.body().getData().getCategory().size();i++){
//                        categoryList.add(response.body().getData().getCategory().get(i));
//                    }
//                    categoryAdpter.setListData(categoryList);
//                    Log.d("TAG",""+categoryList);
//
//                }
//            }
//            @Override
//            public void onFailure(Call<HomePage> call, Throwable t) {
//                progressBar.setVisibility(View.INVISIBLE);
//            }
//        });


    }

    public void renewItems() {
        List<SliderItem> sliderItemList = new ArrayList<>();
        //dummy data
        for (int i = 0; i < 5; i++) {
            SliderItem sliderItem = new SliderItem();
            sliderItem.setDis("Slider Item " + i);
            if (i % 2 == 0) {
                sliderItem.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
            } else {
                sliderItem.setImageUrl("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");
            }
            sliderItemList.add(sliderItem);
        }
        adapter.renewItems(sliderItemList);
    }


    public void removeLastItem(View view) {
        if (adapter.getCount() - 1 >= 0)
            adapter.deleteItem(adapter.getCount() - 1);
    }

    public void addNewItem(View view) {
        SliderItem sliderItem = new SliderItem();
        sliderItem.setDis("Slider Item Added Manually");
        sliderItem.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
        adapter.addItem(sliderItem);
    }
}
//        textViewEmail = view.findViewById(R.id.textViewEmail);
//        textViewName = view.findViewById(R.id.textViewName);
//        textViewDetails = view.findViewById(R.id.textViewSchool);
//
//        Data userData = SharedPrefManager.getInstance(getActivity()).getUserData();
//        textViewEmail.setText(userData.getEmail());
//        textViewName.setText(userData.getFullName());
//        textViewDetails.setText(userData.getAddress()+"\n "+
//                        userData.getCity()+"\n "+  userData.getGender()+"\n "+
//                        userData.getMobile()+"\n "+  userData.getCountry());

