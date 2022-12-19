package com.example.finalcookit;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(primaryKeys = "name")
public class FavoriteRecipe {
    @ColumnInfo(name = "name")
    @NonNull
    public String name;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "image_number")
    public int image;

    public FavoriteRecipe(String name,String description, int image){
        this.name = name;
        this.description = description;
        this.image = image;
    }
}
