package fr.esilv.howtocook;


import java.util.List;

public class RecipeSearchResult {
    private String id;
    private String title;
    private int readyInMinutes;
    private int servings;
    private String image;
    private List<String> imageUrls;


    public String getId() { return id; }
    public String getTitle() { return title; }

    public int getReadyInMinutes() { return readyInMinutes; }

    public int getServings() { return servings; }

    public String getImage() {
        return image;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }
}
