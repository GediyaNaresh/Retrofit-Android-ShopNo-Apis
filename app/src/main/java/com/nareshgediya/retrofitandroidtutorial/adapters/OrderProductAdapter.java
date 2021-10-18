package com.nareshgediya.retrofitandroidtutorial.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nareshgediya.retrofitandroidtutorial.R;
import com.nareshgediya.retrofitandroidtutorial.activities.CartDetailActivity;
import com.nareshgediya.retrofitandroidtutorial.api.RetrofitClient;
import com.nareshgediya.retrofitandroidtutorial.models.CartProduct;
import com.nareshgediya.retrofitandroidtutorial.models.DResponse;
import com.nareshgediya.retrofitandroidtutorial.models.OrderProduct;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class OrderProductAdapter extends RecyclerView.Adapter<OrderProductAdapter.ViewHolder> {

    private Context mContext;
    public List<OrderProduct> orderProductList;


    public OrderProductAdapter(Context mContext) {
        this.mContext = mContext;

    }

    public void setList(List<OrderProduct> categoryArrayList) {
        this.orderProductList = categoryArrayList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_product_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OrderProduct product = orderProductList.get(position);
        if (product.getError() != null) {
            holder.imageView.setVisibility(View.GONE);
            holder.price.setVisibility(View.GONE);
            holder.name.setText(product.getError());
            holder.shippingRate.setText("Order id : " + product.getOrderId());
            holder.quantity.setText("Quantity   " + product.getQty() + " Pcs");

        } else {
            holder.imageView.setVisibility(View.VISIBLE);
            holder.price.setVisibility(View.VISIBLE);
            Glide.with(holder.itemView)
                    .load("https://shopno.in/gujjustore.in/uploads/product/" + product.getProductImg1())
                    .fitCenter()
                    .into(holder.imageView);
            holder.name.setText(product.getProductName());
            holder.price.setText("₹ " + product.getNewPrice());
            holder.shippingRate.setText("Shipping ₹ " + product.getShippingRate());
            holder.quantity.setText("Quantity   " + product.getQty() + " Pcs");
        }


//        holder.remove.setOnClickListener(view -> {
//            Call<DResponse> callRemove = RetrofitClient.getInstance().getApi().
//                    removeFromCart(product.getId(),"1");
//
//            callRemove.enqueue(new Callback<DResponse>() {
//                @Override
//                public void onResponse(Call<DResponse> call, Response<DResponse> response) {
//                    if (response.isSuccessful()){
//                        orderProductList.remove(position);
//                        notifyDataSetChanged();
//                        Toast.makeText(mContext, holder.name+" Removed", Toast.LENGTH_SHORT).show();
//                    }
//                }
//                @Override
//                public void onFailure(Call<DResponse> call, Throwable t) {
//
//                }
//            });
//        });

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(mContext, CartDetailActivity.class);
//                intent.putExtra("id", product.getId());
//                intent.putExtra("name", product.getProductName());
//                intent.putExtra("image", product.getProductImg1());
//                intent.putExtra("price", product.getNewPrice());
//                intent.putExtra("oldprice", product.getOldPrice());
//                intent.putExtra("qty", product.getQty());
//                intent.putExtra("shippibg", product.getShippingRate());
//                intent.putExtra("position",position);
//
//                mContext.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return orderProductList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView, remove;
        private TextView name;
        private TextView shippingRate;
        private TextView price, quantity;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView1);
            name = itemView.findViewById(R.id.pName);
            price = itemView.findViewById(R.id.new_price);
            shippingRate = itemView.findViewById(R.id.shipping_rate);
            quantity = itemView.findViewById(R.id.cartquantityCount);
            remove = itemView.findViewById(R.id.removeItem);

        }
    }
}
