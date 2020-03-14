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

    private RecyclerView recyclerView;
    private String BaseURL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        BaseURL = "https://api.spoonacular.com/recipes/";
        recyclerView = findViewById(R.id.result_activity_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        String query = intent.getStringExtra("QUERY");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LaunchService launch = new LaunchService(retrofit, recyclerView, getBaseContext());
        launch.launchService(query);
    }

    /*
    private void launchService(String query){
        service.search(query, API_KEY).enqueue(new Callback<RecipeSearchResponse>() {
            @Override
            public void onResponse(@NonNull Call<RecipeSearchResponse> call, @NonNull Response<RecipeSearchResponse> response) {
                if (response.isSuccessful()) {
                    RecipeSearchResponse recipes = response.body();
                    List<RecipeSearchResult> items = null;
                    String baseURL = null;
                    if (recipes != null) {
                        items = recipes.getResults();
                        baseURL = recipes.getBaseUri();
                    }
                    recyclerView.setAdapter(new RecipeSearchResultAdapter(items,baseURL,getBaseContext()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<RecipeSearchResponse> call, @NonNull Throwable t) {
            }
        });
    }*/

}
