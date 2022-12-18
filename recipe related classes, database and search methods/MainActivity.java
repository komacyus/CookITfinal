package com.example.recipeclasses;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    Button manage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        manage = findViewById(R.id.button);



        manage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities();
            }
        });




    }

    @Override
    protected void onStart() {
        super.onStart();

        Content c = new Content();
        c.execute();

    }

    @Override
    protected void onStop() {
        super.onStop();

        IngViewModel viewModel = new ViewModelProvider(this).get(IngViewModel.class);
        viewModel.getList().observe(MainActivity.this,list1 ->{

            Program.currIngredients = new ArrayList<CurrentIngredient>();

            for(CIngredient cIngredient: list1){
                Program.currIngredients.add(Program.converter(cIngredient));
            }
            if(Program.currIngredients.size() > 0){
                //Log.d("Debug",Program.currIngredients.get(Program.currIngredients.size()-1));
            }


        });

    }


    /*
    protected void onStart(Bundle savedInstanceState) {

        super.onPostCreate(savedInstanceState);

        IngViewModel viewModel = new ViewModelProvider(this).get(IngViewModel.class);
        viewModel.getList().observe(MainActivity.this,list1 ->{

            Program.currIngredients = new ArrayList<CurrentIngredient>();

            for(CIngredient cIngredient: list1){
                Program.currIngredients.add(Program.converter(cIngredient));
            }
            if(Program.currIngredients.size() > 0){
                //Log.d("Debug",Program.currIngredients.get(Program.currIngredients.size()-1));
            }


        });

    }

     */







    private void switchActivities(){
        Intent x = new Intent(this, CurrentIngredientsActivity.class);
        startActivity(x);
    }



    private class Content extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                Program prog = new Program();
                System.out.println(prog.currIngredients);
                System.out.println(prog.currIngredients);

            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }






}