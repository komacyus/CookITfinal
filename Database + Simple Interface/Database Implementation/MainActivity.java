package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {
    Button manage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IngViewModel viewModel = new ViewModelProvider(this).get(IngViewModel.class);
        manage = findViewById(R.id.button);

        manage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities();
            }
        });

    }

    private void switchActivities(){
        Intent x = new Intent(this, CurrentIngredientsActivity.class);
        startActivity(x);
    }


}