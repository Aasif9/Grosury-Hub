package com.example.grosury.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.grosury.Model.MainModel;
import com.example.grosury.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainAdapter extends FirebaseRecyclerAdapter <MainModel,MainAdapter.ViewHolder>{

    private static final String Tag="Recycler View";
    Context context;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceBooks;
    private ArrayList<MainModel> messageList;

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MainAdapter(@NonNull FirebaseRecyclerOptions<MainModel> options) {
        super(options);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_product_list_item,parent,false);
       return new ViewHolder(view);
    }


    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull MainModel model) {


        holder.name.setText(model.getName());
        holder.course.setText(model.getCourse());
        holder.email.setText(model.getEmail());

        Glide.with(holder.images.getContext())
                .load(model.getUrl())
                .placeholder(R.drawable.tr)
                .error(R.drawable.trop)
                .into(holder.images);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView images;
        TextView name,course,email;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        /*
            images=itemView.findViewById(R.id.product_img);
            name=itemView.findViewById(R.id.product_name);
            course=itemView.findViewById(R.id.coursetext);
            email=itemView.findViewById(R.id.emailtext);*/
        }
    }
}

