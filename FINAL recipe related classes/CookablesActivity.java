package com.example.recipeclasses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class CookablesActivity extends AppCompatActivity {

    TextView tw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookables);
        tw = findViewById(R.id.cookables);
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
            String s = Program.toStringCookableWithExtras();
            s += Program.toStringCookableWithCurrents();

            String finalS = s;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tw.setText(finalS);
                }
            });



            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}