package fr.esilv.howtocook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import java.util.List;

import fr.esilv.howtocook.Model.Ingredient;
import fr.esilv.howtocook.Model.RecipeInformation;
import fr.esilv.howtocook.Model.Step;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static fr.esilv.howtocook.Constants.BASE_URI;

public class DetailsActivity extends AppCompatActivity {
    String recipeID;
    TextView title;
    TextView noSimilarText;
    ImageView image;
    RecyclerView ingredientsRecycler;
    RecyclerView instructionsRecycler;
    RecyclerView similarRecycler;
    private final String BaseURL = "https://api.spoonacular.com/recipes/";
    private SpoonacularService service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        title = findViewById(R.id.details_activity_title);
        image = findViewById(R.id.detail_image_view);
        ingredientsRecycler = findViewById(R.id.ingredients_recycler_view);
        instructionsRecycler = findViewById(R.id.instructions_recycler_view);
        similarRecycler = findViewById(R.id.similar_recycler_view);
        noSimilarText = findViewById(R.id.no_similar_text);

        ingredientsRecycler.setLayoutManager(new LinearLayoutManager(this));
        instructionsRecycler.setLayoutManager(new LinearLayoutManager(this));
        similarRecycler.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));

        Intent intent= getIntent();
        recipeID = intent.getExtras().getString("RECIPE_ID");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(SpoonacularService.class);

        service.getRecipe(recipeID, Constants.API_KEY).enqueue(new Callback<RecipeInformation>() {
            @Override
            public void onResponse(@NonNull Call<RecipeInformation> call, @NonNull Response<RecipeInformation> response) {
                if (response.isSuccessful()) {
                    RecipeInformation recipe = response.body();
                    title.setText(recipe.getTitle());
                    Picasso.get().load(recipe.getImage()).resize(1500, 800).centerCrop().into(image);
                    List<Ingredient> ingredients = recipe.getExtendedIngredients();
                    ingredientsRecycler.setAdapter(new IngredientsAdapter(ingredients));
                }
            }

            @Override
            public void onFailure(@NonNull Call<RecipeInformation> call, @NonNull Throwable t) {
            }
        });

        service.getInstructions(recipeID, Constants.API_KEY).enqueue(new Callback<List<InstructionsResponse>>() {
            @Override
            public void onResponse(Call<List<InstructionsResponse>> call, Response<List<InstructionsResponse>> response) {
                if (response.isSuccessful()) {
                    InstructionsResponse instructions = response.body().get(0);
                    List<Step> steps = instructions.getSteps();
                    instructionsRecycler.setAdapter(new InstructionsAdapter(steps));
                }
            }

            @Override
            public void onFailure(Call<List<InstructionsResponse>> call, Throwable t) {

            }
        });

        service.getSimilar(recipeID, Constants.API_KEY).enqueue(new Callback<List<RecipeSearchResult>>() {
            @Override
            public void onResponse(Call<List<RecipeSearchResult>> call, Response<List<RecipeSearchResult>> response) {
                if (response.isSuccessful()) {
                    List<RecipeSearchResult> recipes = response.body();
                    similarRecycler.setAdapter(new RecipeSearchResultAdapter(recipes,BASE_URI,getBaseContext()));
                    if (recipes.size() == 0){
                        noSimilarText.setText(R.string.nosimilar);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<RecipeSearchResult>> call, Throwable t) {

            }
        });
    }
}
