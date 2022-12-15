package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

public class Addition extends AppCompatActivity {
    static int row = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addition);
        IngViewModel viewModel = new ViewModelProvider(this).get(IngViewModel.class);
        Button addList = findViewById(R.id.button2);
        EditText edited = findViewById(R.id.editTextTextPersonName2);
        EditText multi = findViewById(R.id.editTextTextMultiLine);
        multi.setEnabled(false);
        EditText number = findViewById(R.id.editTextNumber);
        addList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = edited.getText().toString();
                int sNum = Integer.valueOf(number.getText().toString());
                CIngredient c = new CIngredient(txt,sNum);
                viewModel.insertIngredient(c);
            }
        });
        viewModel.getList().observe(this,list1 ->{
            multi.setText("");
            for(CIngredient cIngredient: list1){
                multi.append(cIngredient.name + " " + cIngredient.num + "\n");
            }

        });
    }
}
