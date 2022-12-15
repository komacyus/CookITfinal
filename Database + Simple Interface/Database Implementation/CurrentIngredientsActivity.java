package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class CurrentIngredientsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IngViewModel viewModel = new ViewModelProvider(this).get(IngViewModel.class);
        setContentView(R.layout.activity_current_ingredients);
        Button add = findViewById(R.id.button3);
        Button remove = findViewById(R.id.button4);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CurrentIngredientsActivity.this, AdditionActivity.class);
                startActivity(i);
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CurrentIngredientsActivity.this, DeletionActivity.class);
                startActivity(i);
            }
        });
    }
}
