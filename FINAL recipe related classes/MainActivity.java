package com.example.recipeclasses;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    Button manage;
    Button calculateWithCurr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        manage = findViewById(R.id.button);
        calculateWithCurr = findViewById(R.id.button5);



        Content c = new Content();
        c.execute();


        calculateWithCurr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Calculator calc = new Calculator();
                calc.execute();

                System.out.println(Program.cookableWithCurrents);

            }
        });



        manage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switchFromMainToCurrIngActivity();
            }

        });







    }

    private class Calculator extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Searcher.fillCookableWithCurrentsList();

            try {
                Searcher.fillCookableWithExtrasList();
                System.out.println(Program.cookableWithExtras);
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

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println(Program.currIngredients);

    }



    private void switchFromMainToCurrIngActivity(){
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