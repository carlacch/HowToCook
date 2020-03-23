package fr.esilv.howtocook.Model;

import java.util.List;

public class RecipeInformation {
    String title;
    String image;
    int readyInMinutes;
    List<Ingredient> extendedIngredients;
    String summary;

    public String getTitle() { return title; }
    public String getImage() { return image; }
    public int getReadyInMinutes() { return readyInMinutes; }
    public List<Ingredient> getExtendedIngredients() { return extendedIngredients; }
    public String getSummary() { return summary; }
}
