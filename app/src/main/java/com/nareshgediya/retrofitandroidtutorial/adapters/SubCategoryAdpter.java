package com.nareshgediya.retrofitandroidtutorial.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nareshgediya.retrofitandroidtutorial.R;
import com.nareshgediya.retrofitandroidtutorial.activities.SubCategoryWiseProductActivity;
import com.nareshgediya.retrofitandroidtutorial.models.Subcategory;

import java.util.ArrayList;
import java.util.List;


public class SubCategoryAdpter extends RecyclerView.Adapter<SubCategoryAdpter.ViewHolder> {

    private Context mContext;


    private List<Subcategory> categoryArrayList = new ArrayList<>();

    public SubCategoryAdpter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subcategory_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Subcategory category = categoryArrayList.get(position);
        holder.tvCategory.setText(category.getSubcategory());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, SubCategoryWiseProductActivity.class);
                intent.putExtra("id", category.getSubcategoryId());
                intent.putExtra("name", category.getSubcategory());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryArrayList.size();
    }

    public void setListData(List<Subcategory> categoryArrayList) {
        this.categoryArrayList = categoryArrayList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView tvCategory;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCategory = itemView.findViewById(R.id.tv1);

        }
    }
}
