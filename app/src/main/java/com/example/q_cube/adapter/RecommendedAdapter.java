package com.example.q_cube.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.q_cube.R;
import com.example.q_cube.model.Recommended;

import java.util.List;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.RecommendedViewHolder> {

    private Context context;
    private List<Recommended> recommendedList;

    public RecommendedAdapter(List<Recommended> recommendedList, Context context) {
        this.context = context;
        this.recommendedList = recommendedList;
    }

    @NonNull
    @Override
    public RecommendedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recommended_recycler_items, parent, false);
        return new RecommendedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendedViewHolder holder, final int position) {

        holder.recommendedName.setText(recommendedList.get(position).getName());
        //holder.recommendedPrice.setText("₹ "+recommendedList.get(position).getPrice());

        Glide.with(context).load(recommendedList.get(position).getImageUrl()).into(holder.recommendedImage);

        // holder.itemView.setOnClickListener(new View.OnClickListener() {
        //   @Override
        // public void onClick(View view) {
        //   Intent i = new Intent(context, FoodDetails.class);
        // i.putExtra("name", recommendedList.get(position).getName());
        //i.putExtra("price", recommendedList.get(position).getPrice());
        //i.putExtra("rating", recommendedList.get(position).getRating());
        //i.putExtra("image", recommendedList.get(position).getImageUrl());

        //context.startActivity(i);
        //}
        //});

    }

    @Override
    public int getItemCount() {
        return recommendedList.size();
    }

    public  static class RecommendedViewHolder extends RecyclerView.ViewHolder{

        ImageView recommendedImage;
        TextView recommendedName;
        // TextView recommendedPrice;
        public RecommendedViewHolder(@NonNull View itemView) {
            super(itemView);

            recommendedImage = itemView.findViewById(R.id.recommended_image);
            recommendedName = itemView.findViewById(R.id.recommended_name);
            //recommendedPrice = itemView.findViewById(R.id.recommended_price);

        }

    }

}
