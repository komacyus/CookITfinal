package com.example.recipeclasses;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;

public class AdditionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);
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
                double sNum = Double.valueOf(number.getText().toString());
                CIngredient c = new CIngredient(txt,sNum);
                viewModel.insertIngredient(c);
            }
        });
        viewModel.getList().observe(this,list1 ->{
            multi.setText("");
            Program.currIngredients = new ArrayList<CurrentIngredient>();
            for(CIngredient cIngredient: list1){
                multi.append(cIngredient.name + " " + cIngredient.num + "\n");

                Program.currIngredients.add(Program.converter(cIngredient));
            }
            if(Program.currIngredients.size() > 0){
                //Log.d("Debug",Program.currIngredients.get(Program.currIngredients.size()-1));
            }


        });
    }
}
