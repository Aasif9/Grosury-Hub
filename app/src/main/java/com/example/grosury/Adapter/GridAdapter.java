package com.example.grosury.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grosury.Model.GridItem;
import com.example.grosury.R;
import com.example.grosury.ui.ProductListDetail;

import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.MyViewHolder> {

    private Context mContext;
    private List<GridItem> gridItems;

    public GridAdapter(Context mContext, List<GridItem> gridItems) {
        this.mContext = mContext;
        this.gridItems = gridItems;
    }

    @NonNull
    @Override
    public GridAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater=LayoutInflater.from(mContext);
        view =inflater.inflate(R.layout.grid_list_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.productName.setText(gridItems.get(position).getProductName());
        holder.productImage.setImageResource(gridItems.get(position).getProductImage());

        //Set click Listener
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent =new Intent(mContext, ProductListDetail.class);

            mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return gridItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

       ImageView productImage;
       TextView productName;
        LinearLayout layout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            productImage=itemView.findViewById(R.id.itemImage);
            productName=itemView.findViewById(R.id.itemName);
            layout=itemView.findViewById(R.id.gridListItem);
        }
    }
}
