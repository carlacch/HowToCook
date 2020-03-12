package fr.esilv.howtocook;

import java.util.List;

public class RecipeSearchResponse {
    private List<RecipeSearchResult> results;
    private String baseUri;
    private int totalResults;

    public List<RecipeSearchResult> getResults() { return results; }

    public String getBaseUri() { return baseUri; }

    public int getTotalResults() { return totalResults; }
}
