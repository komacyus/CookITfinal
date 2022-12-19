package com.example.recipeclasses;
import androidx.lifecycle.LiveData;
import androidx.room.*;

import java.util.List;

@Dao
public interface CIngredientDao {
    @Insert
    public void addIngredients(CIngredient... ingredients);

    @Delete
    public void deleteIngredient(CIngredient ingredient);

    @Query("SELECT * FROM cIngredient")
    public LiveData<List<CIngredient>> getAll();

    @Query("SELECT * FROM cingredient WHERE name LIKE :name1")
    public CIngredient findIng(String name1);
}
