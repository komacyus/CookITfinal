package com.example.mycookit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mycookit.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Program prog = new Program();

        System.out.print(prog.ingredientTypes);
        System.out.print(prog.breakfastRecipes);
        System.out.print(prog.lunchRecipes);
        System.out.print(prog.dinnerRecipes);

        System.out.print(prog.dinnerRecipes);




    }
}