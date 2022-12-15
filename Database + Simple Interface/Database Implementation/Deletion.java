package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

public class Deletion extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deletion);
        IngViewModel viewModel = new ViewModelProvider(this).get(IngViewModel.class);
        Button delList = findViewById(R.id.button2);
        EditText edited = findViewById(R.id.editTextTextPersonName2);
        EditText multi = findViewById(R.id.editTextTextMultiLine);
        multi.setEnabled(false);
        delList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = edited.getText().toString();
                CIngredient c = new CIngredient(txt,1);

                if(!c.name.equals("")){
                    viewModel.deleteIngredients(c);
                }

            }
        });
        viewModel.getList().observe(this, list1 ->{
            multi.setText("");
            for(CIngredient cIngredient: list1){
                multi.append(cIngredient.name + " " + cIngredient.num + "\n");
            }
        });
    }
}
