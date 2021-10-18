package com.nareshgediya.retrofitandroidtutorial.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;

import com.nareshgediya.retrofitandroidtutorial.R;


import java.util.ArrayList;
import java.util.List;

public class SliderAdapterHomepage extends SliderViewAdapter<SliderAdapterHomepage.MySliderView> {

    private Context context;
    private List<String> mSliderItems = new ArrayList<>();

    public SliderAdapterHomepage(Context context) {
        this.context = context;

        notifyDataSetChanged();
    }

    public void setmSliderItems(List<String> sliderItems) {
        this.mSliderItems = sliderItems;
        notifyDataSetChanged();
    }


    @Override
    public MySliderView onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new MySliderView(inflate);
    }


    @Override
    public void onBindViewHolder(MySliderView viewHolder, final int position) {

        String sliderItem = mSliderItems.get(position);

        viewHolder.textViewDescription.setTextColor(Color.WHITE);
        Glide.with(viewHolder.itemView)
                .load("https://shopno.in/gujjustore.in/uploads/slider/" + sliderItem)
                .fitCenter()
                .into(viewHolder.imageViewBackground);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "This is item in position " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return mSliderItems.size();
    }

    class MySliderView extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        ImageView imageGifContainer;
        TextView textViewDescription;

        public MySliderView(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            imageGifContainer = itemView.findViewById(R.id.iv_gif_container);
            textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider);
            this.itemView = itemView;
        }
    }

}
