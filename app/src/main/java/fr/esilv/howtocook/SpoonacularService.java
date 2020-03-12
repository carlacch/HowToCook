package fr.esilv.howtocook;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SpoonacularService {
    @GET("search?")
    Call<RecipeSearchResponse> search(@Query("query") String query, @Query("apiKey") String apiKey);
}
