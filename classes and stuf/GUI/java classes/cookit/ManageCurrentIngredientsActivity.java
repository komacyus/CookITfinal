package com.a.cookit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManageCurrentIngredientsActivity extends AppCompatActivity {
    Button editButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_current_ingredients);

        editButton = findViewById(R.id.inventoryEditButton);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goEditPage = new Intent( ManageCurrentIngredientsActivity.this, IngredientEditActivity.class);
                startActivity(goEditPage);
            }
        });
    }
}