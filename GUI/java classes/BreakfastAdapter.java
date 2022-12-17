package com.a.cookit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.a.cookit.Listeners.RecipeClickListener;

import java.util.ArrayList;

public class BreakfastAdapter extends RecyclerView.Adapter<BreakfastAdapter.RandomRecipeViewHolder> {
    ArrayList<String> breaklist;
    Context context;
    RecipeClickListener listener;

    public BreakfastAdapter(Context context, ArrayList<String> blist, RecipeClickListener listener) {
        this.context = context;
        breaklist = blist;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RandomRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new RandomRecipeViewHolder(LayoutInflater.from(context).inflate(R.layout.list_random_recipe,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RandomRecipeViewHolder holder, int position) {
           //arraydaki pos a göre adı alıyor          get(position).name falan olucak burası
            holder.textView_title.setText(breaklist.get(position));
        // image pöyle kurarız
        //Picasso.get().load(list.get(position).image).into(holder.imageView_food);

        holder.random_list_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // listener.onRecipeClicked(String.valueOf(list.get(holder.getAdapterPosition()).id));

            }
        });
    }

    @Override
    public int getItemCount() {
        return breaklist.size();
    }

    /*public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView bFullName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
                                            // buraya recipe adı id falan dish namedeki recipe name id sini buraya mesela
            bFullName = itemView.findViewById(R.id.textView_title);
        }
    }*/

    class RandomRecipeViewHolder extends RecyclerView.ViewHolder{
        CardView random_list_container;
        TextView textView_title;
        ImageView imageView_food;


        public RandomRecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            random_list_container = itemView.findViewById(R.id.random_list_container);
            textView_title= itemView.findViewById(R.id.textView_title);
            imageView_food = itemView.findViewById(R.id.imageView_food);



        }
    }
}

