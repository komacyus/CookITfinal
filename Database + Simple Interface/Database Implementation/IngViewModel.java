package com.example.myapplication;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class IngViewModel extends AndroidViewModel {

    CIngredientRepository repository;
    LiveData<List<CIngredient>> list1;

    public IngViewModel(Application application){
        super(application);
        repository = new CIngredientRepository(application);
        list1 = repository.getAllIngredients();
    }

    LiveData<List<CIngredient>> getList(){
        return list1;
    }

    public void insertIngredient(CIngredient c){
        repository.insert(c);
    }

    public void deleteIngredients(CIngredient c){
        repository.delete(c);
    }
}
