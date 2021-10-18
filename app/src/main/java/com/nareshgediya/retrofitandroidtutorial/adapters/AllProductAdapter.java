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
import com.nareshgediya.retrofitandroidtutorial.activities.DetailActivity;
import com.nareshgediya.retrofitandroidtutorial.models.Product;

import java.util.ArrayList;
import java.util.List;


public class AllProductAdapter extends RecyclerView.Adapter<AllProductAdapter.ViewHolder> {

    private Context mContext;


    private List<Product> categoryArrayList = new ArrayList<>();

    public AllProductAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_product_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = categoryArrayList.get(position);

        Glide.with(holder.itemView)
                .load("https://shopno.in/gujjustore.in/uploads/product/" + product.getProductImg1())
                .fitCenter()
                .into(holder.imageView);

        holder.price.setText("₹ " + product.getNewPrice());
        holder.name.setText(product.getProductName());
        holder.shippingRate.setText("Shipping ₹ " + product.getShippingRate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("id", product.getId());
                intent.putExtra("name", product.getProductName());
                intent.putExtra("image", product.getProductImg1());
                intent.putExtra("price", product.getNewPrice());

                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryArrayList.size();
    }

    public void setListData(List<Product> categoryArrayList) {
        this.categoryArrayList = categoryArrayList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView name;
        private TextView shippingRate;
        private TextView price;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            imageView = itemView.findViewById(R.id.imageView1);
            name = itemView.findViewById(R.id.pName);
            price = itemView.findViewById(R.id.new_price);
            shippingRate = itemView.findViewById(R.id.shipping_rate);

        }
    }
}
