package com.example.finalcookit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class Breakfast_RecyclerViewAdapter extends RecyclerView.Adapter<Breakfast_RecyclerViewAdapter.MyViewHolder> {
 // BU
 // VARRRRRRRRRRRR
    private  final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<RecipeModel> recipeModels;
    public Breakfast_RecyclerViewAdapter(Context context,  ArrayList<RecipeModel> recipeModels, RecyclerViewInterface recyclerViewInterface){
        this.context=context;
        this.recipeModels = recipeModels;
        this.recyclerViewInterface = recyclerViewInterface;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_random_recipe, parent, false);

        return new MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.dishName.setText(recipeModels.get(position).getName());
        holder.imageView.setImageResource(recipeModels.get(position).getImage());


    }

    @Override
    public int getItemCount() {
        return recipeModels.size();
    }

    public static class  MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView dishName;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView_food);
            dishName = itemView.findViewById(R.id.textView_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null){
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }

                    }
                }
            });

        }
    }
}
