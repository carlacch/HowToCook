package fr.esilv.howtocook;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

class LaunchService {
    private SpoonacularService service;
    private RecyclerView recyclerView;
    private Context context;

    LaunchService(Retrofit retrofit, RecyclerView recyclerView, Context context){
        service = retrofit.create(SpoonacularService.class);
        this.recyclerView = recyclerView;
        this.context = context;
    }

    void launchService(String query){
        service.search(query, Constants.API_KEY).enqueue(new Callback<RecipeSearchResponse>() {
            @Override
            public void onResponse(@NonNull Call<RecipeSearchResponse> call, @NonNull Response<RecipeSearchResponse> response) {
                if (response.isSuccessful()) {
                    RecipeSearchResponse recipes = response.body();
                    List<RecipeSearchResult> items = null;
                    String baseURI = null;
                    if (recipes != null) {
                        items = recipes.getResults();
                        baseURI = recipes.getBaseUri();
                    }
                    recyclerView.setAdapter(new RecipeSearchResultAdapter(items,baseURI, context ));
                }
            }

            @Override
            public void onFailure(@NonNull Call<RecipeSearchResponse> call, @NonNull Throwable t) {
            }
        });
    }
}
