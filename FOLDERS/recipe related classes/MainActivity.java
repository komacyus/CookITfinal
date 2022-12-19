package com.example.recipeclasses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Content c = new Content();
        c.execute();




    }

    private class Content extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            Program prog;
            try {

                prog = new Program();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.print(Program.ingredientTypes);
            System.out.print(Program.breakfastRecipes);
            System.out.print(Program.lunchRecipes);
            System.out.print(Program.dinnerRecipes);

            System.out.print(Program.dinnerRecipes);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}