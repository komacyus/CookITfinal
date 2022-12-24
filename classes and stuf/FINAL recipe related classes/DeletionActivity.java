package com.example.recipeclasses;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class DeletionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletion);
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
            Program.currIngredients = new ArrayList<CurrentIngredient>();
            for(CIngredient cIngredient: list1){
                multi.append(cIngredient.name + " " + cIngredient.num + "\n");

                Program.currIngredients.add(Program.converter(cIngredient));
            }
            Log.d("Debug",Integer.toString(Program.currIngredients.size()));
        });
    }
}
