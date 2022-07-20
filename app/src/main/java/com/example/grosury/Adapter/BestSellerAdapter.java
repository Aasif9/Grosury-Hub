package com.example.grosury.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grosury.Model.BestSeller;
import com.example.grosury.Model.GridItem;
import com.example.grosury.R;
import com.example.grosury.ui.ProductListDetail;

import java.util.List;

public class BestSellerAdapter extends RecyclerView.Adapter<BestSellerAdapter.MyViewHolder> {

    private Context mContext;
    private List<BestSeller> bestSellers;

    public BestSellerAdapter( List<BestSeller> bestSeller) {
        this.bestSellers=bestSeller;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.besthorizontalscroll,parent,false);
      return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bestSellerImage.setImageResource(bestSellers.get(position).getImage());

    }


    @Override
    public int getItemCount() {
        return bestSellers.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView bestSellerImage;
        TextView productName;
        LinearLayout layout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            bestSellerImage=itemView.findViewById(R.id.bestImage);
         //   productName=itemView.findViewById(R.id.itemName);
            layout=itemView.findViewById(R.id.topListItem);
        }
    }
}

