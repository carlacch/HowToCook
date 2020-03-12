package fr.esilv.howtocook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResultActivity extends AppCompatActivity {

    private static final String API_KEY = "16f956ed446f4c2badf858240d0ba832";
    private SpoonacularService service;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        recyclerView = findViewById(R.id.result_activity_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        String query = intent.getStringExtra("QUERY");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.spoonacular.com/recipes/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(SpoonacularService.class);


        service.search(query, API_KEY).enqueue(new Callback<RecipeSearchResponse>() {
            @Override
            public void onResponse(@NonNull Call<RecipeSearchResponse> call, @NonNull Response<RecipeSearchResponse> response) {
                if (response.isSuccessful()) {
                    RecipeSearchResponse recipes = response.body();
                    List<RecipeSearchResult> items = recipes.getResults();
                    String baseURL = recipes.getBaseUri();
                    recyclerView.setAdapter(new RecipeSearchResultAdapter(items,baseURL,getBaseContext()));
                }
            }

            @Override
            public void onFailure(Call<RecipeSearchResponse> call, Throwable t) {
            }
        });
    }
}
