package fr.esilv.howtocook;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SpoonacularService {
    @GET("search?number=100")
    Call<RecipeSearchResponse> search(@Query("query") String query, @Query("apiKey") String apiKey);

    @GET("complexSearch?number=50")
    Call<RecipeSearchResponse> complexSearch(@Query("type") String query, @Query("apiKey") String apiKey);

    @GET("{id}/information")
    Call<RecipeSearchResult> getRecipe(@Path("id") String id_recipe, @Query("apiKey") String apiKey);
}
