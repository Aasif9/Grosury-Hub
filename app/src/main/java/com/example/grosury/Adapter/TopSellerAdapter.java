package com.example.grosury.Adapter;

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
import com.example.grosury.Model.TopSeller;
import com.example.grosury.R;
import com.example.grosury.ui.ProductListDetail;

import java.util.List;

public class TopSellerAdapter extends RecyclerView.Adapter<TopSellerAdapter.MyViewHolder> {

    private Context mContext;
    private List<TopSeller> topSellers;

    public TopSellerAdapter( List<TopSeller> topSeller) {
        this.topSellers=topSeller;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.tophorizontalview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.topSellerImage.setImageResource(topSellers.get(position).getImage());

       /* //Set click Listener
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(mContext, ProductListDetail.class);
                // intent.putExtra("Title",gridItems.get(position).getProductName());
                mContext.startActivity(intent);
            }
        });*/

    }


    @Override
    public int getItemCount() {
        return topSellers.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView topSellerImage;
        TextView productName;
        LinearLayout layout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            topSellerImage=itemView.findViewById(R.id.topImage);
            //   productName=itemView.findViewById(R.id.itemName);
            layout=itemView.findViewById(R.id.bestListItem);
        }
    }
}

