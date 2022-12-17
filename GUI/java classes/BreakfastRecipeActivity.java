package com.a.cookit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.a.cookit.Listeners.RecipeClickListener;

import java.util.ArrayList;

public class BreakfastRecipeActivity extends AppCompatActivity {

    public ArrayList<String> blist;
    RecyclerView bRecyclerView;
    RecyclerView.LayoutManager bLayoutManager;
    RecyclerView.Adapter bAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast_recipe);

        bRecyclerView = findViewById(R.id.breakfast_list);

        blist = new ArrayList<>();
        blist.add("qwqw");
        blist.add("abababa");


        bRecyclerView.setHasFixedSize(true);
        bLayoutManager = new LinearLayoutManager(this);
        bAdapter = new BreakfastAdapter(BreakfastRecipeActivity.this,blist, recipeClickListener);
        bRecyclerView.setLayoutManager(bLayoutManager);
        bRecyclerView.setAdapter(bAdapter);


    }
    ArrayList<String> getBList(){
        return blist;
    }
    private final RecipeClickListener recipeClickListener = new RecipeClickListener() {
        @Override
        public void onRecipeClicked(int pos) {
            //recipe message
            startActivity(new Intent(BreakfastRecipeActivity.this, RecipeDetailsActivity.class)
                    .putExtra("array", getBList())
                    .putExtra("pos",0)); // buraya stringi ve image ı koyarız onu yazdırırız
                                                            // ya da direkt arraylist posunu göndeririz oradan alırız
        }
    };
}