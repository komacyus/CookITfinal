package com.example.finalcookit;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
@Dao
public interface FavoriteRecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertFavRecipe(FavoriteRecipe recipe);

    @Delete
    public void deleteFavRecipe(FavoriteRecipe recipe);

    @Query("SELECT * FROM FavoriteRecipe")
    public LiveData<List<FavoriteRecipe>> getAllFavs();

    @Query("SELECT * FROM favoriterecipe WHERE name LIKE :name")
    public FavoriteRecipe findRecipe(String name);
}
