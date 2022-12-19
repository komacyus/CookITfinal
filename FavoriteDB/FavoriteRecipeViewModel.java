package com.example.finalproject.FavoriteDb;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class FavoriteRecipeViewModel extends AndroidViewModel {
    public FavoriteRecipeRepository repo;
    public LiveData<List<FavoriteRecipe>> listOfRecipes;

    public FavoriteRecipeViewModel(Application application){
        super(application);
        repo = new FavoriteRecipeRepository(application);
        listOfRecipes = repo.getAllFavs();
    }

    public LiveData<List<FavoriteRecipe>> getRecipeList(){
        return listOfRecipes;
    }

    public void insertRecipe(FavoriteRecipe recipe){
        repo.insert(recipe);
    }

    public void deleteRecipe(FavoriteRecipe recipe){
        repo.delete(recipe);
    }
}
