package com.example.myapplication;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class CIngredientRepository {

    CIngredientDao ingDao;
    CIngredientRepository(Application application){
        IngDb db = IngDb.getDb(application);
        ingDao = db.ingredientDao();
    }

    LiveData<List<CIngredient>> getAllIngredients(){
        return ingDao.getAll();
    }

    void insert(CIngredient ingredient){
        new InsertAsyncTask(ingDao,0).execute(ingredient);
    }

    void delete(CIngredient ing){
        new InsertAsyncTask(ingDao,1).execute(ing);
    }

    private class InsertAsyncTask extends AsyncTask<CIngredient,Void,Void>{
        public CIngredientDao ingDao;
        int x = 0;
        InsertAsyncTask(CIngredientDao ing, int x){
            ingDao = ing;
            this.x = x;
        }

        @Override
        protected Void doInBackground(CIngredient... ings){
            if(x == 0){
                ingDao.addIngredients(ings[0]);
            }
            else{
                ingDao.deleteIngredient(ings[0]);
            }

            return null;
        }

    }
}
