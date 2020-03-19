package fr.esilv.howtocook;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.esilv.howtocook.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.MODE_PRIVATE;

public class MainFragment extends Fragment {

    private RecyclerView recyclerView;
    private final String BaseURL = "https://api.spoonacular.com/recipes/";
    private View view;
    private String query;
    private SpoonacularService service;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = view.findViewById(R.id.main_dishes_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(SpoonacularService.class);

        service.complexSearch("main course", Constants.API_KEY).enqueue(new Callback<RecipeSearchResponse>() {
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
                    recyclerView.setAdapter(new GridRecipeSearchResultAdpater(items, baseURI, view.getContext()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<RecipeSearchResponse> call, @NonNull Throwable t) {
            }
        });
        return view;
    }

}
