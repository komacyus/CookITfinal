package com.example.finalproject.FavoriteDb;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class FavoriteRecipeRepository {
    FavoriteRecipeDao recipeDao;
    public FavoriteRecipeRepository(Application application){
        FavoriteRecipeDb db = FavoriteRecipeDb.getDb(application);
        recipeDao = db.recipeDao();
    }

    public LiveData<List<FavoriteRecipe>> getAllFavs(){
        return recipeDao.getAllFavs();
    }

    public void insert(FavoriteRecipe recipe){
        new AsyncTaskFav(recipeDao,0).execute(recipe);
    }

    public void delete(FavoriteRecipe recipe){
        new AsyncTaskFav(recipeDao,1).execute(recipe);
    }

    private class AsyncTaskFav extends AsyncTask<FavoriteRecipe,Void,Void>{
        public FavoriteRecipeDao repDao;
        public int counter;
        public AsyncTaskFav(FavoriteRecipeDao dao, int counter){
            this.repDao = dao;
            this.counter = counter;
        }
        @Override
        public Void doInBackground(FavoriteRecipe... recipes){
            if(counter == 0){
                repDao.insertFavRecipe(recipes[0]);
            }
            if(counter == 1){
                repDao.deleteFavRecipe(recipes[0]);
            }
            return null;
        }
    }
}
