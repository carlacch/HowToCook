package fr.esilv.howtocook;

import androidx.annotation.NonNull;

import java.util.List;

public class RecipeSearchResponse {
    private List<RecipeSearchResult> results;
    private String baseUri;
    private int totalResults;

    @NonNull
    List<RecipeSearchResult> getResults() { return results; }

    String getBaseUri() { return baseUri; }

    public int getTotalResults() { return totalResults; }
}
