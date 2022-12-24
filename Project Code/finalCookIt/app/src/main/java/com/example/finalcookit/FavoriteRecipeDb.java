package com.example.finalcookit;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = FavoriteRecipe.class, version = 3)
public abstract class FavoriteRecipeDb extends RoomDatabase {
    public abstract FavoriteRecipeDao recipeDao();
    public static FavoriteRecipeDb INSTANCE;

    public static FavoriteRecipeDb getDb(Context context){
        if(INSTANCE == null){
            synchronized (FavoriteRecipeDb.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context, FavoriteRecipeDb.class, "FavoritesDb").fallbackToDestructiveMigration().build();
                }
            }
        }
        return INSTANCE;
    }
}
