package com.example.myapplication;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = CIngredient.class, version = 4)
public abstract class IngDb extends RoomDatabase {
    public abstract CIngredientDao ingredientDao();

    public static IngDb INSTANCE;

    public static IngDb getDb(Context context){
        if(INSTANCE == null){
            synchronized (IngDb.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context,IngDb.class,"MyDb").fallbackToDestructiveMigration().build();
                }
            }

        }
        return INSTANCE;
    }
}
