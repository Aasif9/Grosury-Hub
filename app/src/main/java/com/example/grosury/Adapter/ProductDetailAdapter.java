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
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grosury.Model.GridItem;
import com.example.grosury.Model.ProductDetail;
import com.example.grosury.R;
import com.example.grosury.ui.ProductDescriptionActivity;
import com.example.grosury.ui.ProductListDetail;

import java.util.List;

public class ProductDetailAdapter extends RecyclerView.Adapter<ProductDetailAdapter.MyViewHolder>{

    private Context mContext;
    private List<ProductDetail> productDetails;

    public ProductDetailAdapter(Context mContext, List<ProductDetail> productDetails) {
        this.mContext = mContext;
        this.productDetails = productDetails;
    }

    @NonNull
    @Override
    public ProductDetailAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater=LayoutInflater.from(mContext);
        view =inflater.inflate(R.layout.activity_product_list_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductDetailAdapter.MyViewHolder holder, int position) {
       holder.prodImage.setImageResource(productDetails.get(position).getProductDetailImage());
       holder.prodName.setText(productDetails.get(position).getProductDetailName());
     //  holder.prodPrice.setText(productDetails.get(position).getProductPrice());

    }

    @Override
    public int getItemCount() {
        return productDetails.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView prodImage;
        TextView prodName,prodPrice,prodDiscount,prodQuantity;
       CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            prodImage=itemView.findViewById(R.id.product_image);
            prodName=itemView.findViewById(R.id.product_name);
            prodPrice=itemView.findViewById(R.id.product_price);
            prodDiscount=itemView.findViewById(R.id.product_discount);
            prodQuantity=itemView.findViewById(R.id.product_quantity);
            cardView=itemView.findViewById(R.id.activityListItem);
        }

    }
}
