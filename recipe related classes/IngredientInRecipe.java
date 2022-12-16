package com.example.mycookit;

import java.util.function.DoubleBinaryOperator;

public class IngredientInRecipe {
    private Ingredient ingredient;
    private double amount;
    private int currentUnit;

    public IngredientInRecipe(Ingredient ingredient, double amount, int currentUnit){
        this.ingredient = ingredient;
        this.amount = amount;
        this.currentUnit = currentUnit;
    }

    /**
     * ingredientı tüm ingredientları tanımlamak ve kendi özelliklerini
     * tutmak için kullanıcaz
     * isim var işte bidde inputtype var kullanıcı hangi  birim üzerinden girecekse
     * input type o olacak
     * input typebence list seklinde olmalı
     * bazılarında iki tane falan var ya
     * 
     * o ayrı işte
     * bu ingredinet objesinin input typeı kullanıcınn hangi birimde gireceğşni
     * tanımlamak için kullanılcak
     * ingrdient in recipede
     * bizim hangi birimle göstereceğimiz tanımlanca
     * ama dönüştüren metodlar ingredientte
     * 
     * public onlar
     * istediğin yerde kullanırsın metodları
     * statik 
     */
}
