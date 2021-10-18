package com.nareshgediya.retrofitandroidtutorial.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.nareshgediya.retrofitandroidtutorial.R;
import com.nareshgediya.retrofitandroidtutorial.activities.CategoryWiseProductActivity;
import com.nareshgediya.retrofitandroidtutorial.models.Category;

import java.util.ArrayList;
import java.util.List;


public class CategoryAdpter extends RecyclerView.Adapter<CategoryAdpter.ViewHolder> {

    private Context mContext;


    private List<Category> categoryArrayList = new ArrayList<Category>();

    public CategoryAdpter(Context mContext) {
        this.mContext = mContext;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_product_category, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category category = categoryArrayList.get(position);

        Glide.with(holder.itemView)
                .load("https://shopno.in/gujjustore.in/uploads/category/" + category.getCategoryImg())
                .fitCenter()
                .into(holder.ivCategoryImg);

        holder.tvCategory.setText(category.getCategory());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, CategoryWiseProductActivity.class);
                intent.putExtra("id", category.getId());
                intent.putExtra("name", category.getCategory());

                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryArrayList.size();
    }

    public void setListData(List<Category> categoryArrayList) {
        this.categoryArrayList = categoryArrayList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivCategoryImg;
        private TextView tvCategory;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            ivCategoryImg = itemView.findViewById(R.id.imageView1);
            tvCategory = itemView.findViewById(R.id.tv1);

        }
    }
}
