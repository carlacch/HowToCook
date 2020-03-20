package fr.esilv.howtocook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailsActivity extends AppCompatActivity {

    String recipeID;
    TextView title;
    private final String BaseURL = "https://api.spoonacular.com/recipes/";
    private SpoonacularService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        title = findViewById(R.id.details_activity_title);

        Intent intent= getIntent();
        recipeID = intent.getExtras().getString("RECIPE_ID");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(SpoonacularService.class);

        service.getRecipe(recipeID, Constants.API_KEY).enqueue(new Callback<RecipeSearchResult>() {
            @Override
            public void onResponse(@NonNull Call<RecipeSearchResult> call, @NonNull Response<RecipeSearchResult> response) {
                if (response.isSuccessful()) {
                    RecipeSearchResult recipe = response.body();
                    title.setText(recipe.getTitle());
                }
            }

            @Override
            public void onFailure(@NonNull Call<RecipeSearchResult> call, @NonNull Throwable t) {
            }
        });
    }
}
