package com.nada.administrativecapital.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.makeramen.roundedimageview.RoundedImageView;
import com.nada.administrativecapital.R;
import com.nada.administrativecapital.model.SliderItem;

import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder> {

    private List<SliderItem> sliderItems;
    private ViewPager2 viewPager2;

    public SliderAdapter(List<SliderItem> sliderItems, ViewPager2 viewPager2) {
        this.sliderItems = sliderItems;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new SliderViewHolder(
                LayoutInflater.from(viewGroup.getContext()).inflate(
                        R.layout.slide_item_container,
                        viewGroup,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SliderAdapter.SliderViewHolder sliderViewHolder, int position) {
        sliderViewHolder.setImage(sliderItems.get(position));
        sliderViewHolder.setText(sliderItems.get(position));
    }

    @Override
    public int getItemCount() {
        return sliderItems.size();
    }

    class SliderViewHolder extends RecyclerView.ViewHolder {

        private RoundedImageView roundedImageView;
        private TextView textView;

        SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            roundedImageView = itemView.findViewById(R.id.imageSlider);
            textView = itemView.findViewById(R.id.sliderDescript);
        }

        void setImage(SliderItem sliderItem) {
            roundedImageView.setImageResource(sliderItem.getImage());
        }
        void setText(SliderItem sliderItem) {
            textView.setText(sliderItem.getDescript());
        }

    }

}
