package com.example.finalcookit;

public class RecipeModel {
    String name;
    String description;
    int image;

    public RecipeModel(String name, String description, int image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }
}
