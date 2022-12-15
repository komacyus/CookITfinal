package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(primaryKeys = "name")
public class CIngredient {
    @ColumnInfo(name = "name")
    @NonNull String name;
    @ColumnInfo(name = "classification_number")
    int num;

    public CIngredient(String name, int num){
        this.name = name;
        this.num = num;
    }

    public boolean equals(Object obj){
        if(obj instanceof CIngredient){
            CIngredient ing = (CIngredient) obj;
            if(this.name.equalsIgnoreCase(ing.name)){
                return true;
            }
            return false;
        }
        return false;

    }
}
