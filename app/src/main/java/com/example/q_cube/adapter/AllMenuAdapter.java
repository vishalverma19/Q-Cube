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
import com.example.q_cube.model.Allmenu;

import java.util.List;

public class AllMenuAdapter extends RecyclerView.Adapter<AllMenuAdapter.AllMenuViewHolder> {

    Context context;
    List<Allmenu> allmenuList;

    public AllMenuAdapter(List<Allmenu> allmenuList, Context context) {
        this.context = context;
        this.allmenuList = allmenuList;
    }


    @NonNull
    @Override
    public AllMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.allmenu_recycler_items, parent, false);

        return new AllMenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllMenuViewHolder holder, final int position) {

        holder.allMenuName.setText(allmenuList.get(position).getName());
       /* holder.allMenuPrice.setText("₹ " + allmenuList.get(position).getPrice());
        holder.allMenuTime.setText(allmenuList.get(position).getDeliveryTime());
        holder.allMenuRating.setText(allmenuList.get(position).getRating());
        holder.allMenuCharges.setText(allmenuList.get(position).getDeliveryCharges());
        holder.allMenuNote.setText(allmenuList.get(position).getNote());*/

        Glide.with(context).load(allmenuList.get(position).getImageUrl()).into(holder.allMenuImage);


        //holder.itemView.setOnClickListener(new View.OnClickListener() {
        //  @Override
        //public void onClick(View view) {
        //  Intent i = new Intent(context, FoodDetails.class);
        //      i.putExtra("name", allmenuList.get(position).getName());
        //    i.putExtra("price", allmenuList.get(position).getPrice());
        //  i.putExtra("rating", allmenuList.get(position).getRating());
        //     i.putExtra("image", allmenuList.get(position).getImageUrl());

        //   context.startActivity(i);
        //}
        //});

    }

    @Override
    public int getItemCount() {
        return allmenuList.size();
    }

    public static class AllMenuViewHolder extends RecyclerView.ViewHolder {

        TextView allMenuName, allMenuNote, allMenuRating, allMenuTime, allMenuCharges, allMenuPrice;
        ImageView allMenuImage;

        public AllMenuViewHolder(@NonNull View itemView) {
            super(itemView);

            allMenuName = itemView.findViewById(R.id.all_menu_name);
            allMenuPrice = itemView.findViewById(R.id.all_menu_price);
            allMenuImage = itemView.findViewById(R.id.all_menu_image);
        }
    }

}
