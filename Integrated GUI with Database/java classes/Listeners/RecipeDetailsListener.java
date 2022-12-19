package com.example.finalproject.Listeners;

import java.util.ArrayList;

public interface RecipeDetailsListener {
    void didFetch(ArrayList<String> array, String message);
    void didError(String message);
}
