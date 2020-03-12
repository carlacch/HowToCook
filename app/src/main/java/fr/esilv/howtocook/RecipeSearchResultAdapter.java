package fr.esilv.howtocook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecipeSearchResultAdapter extends RecyclerView.Adapter<RecipeResultViewHolder>  {

    private final List<RecipeSearchResult> items;
    private final String baseURL;
    private Context context;

    public RecipeSearchResultAdapter(List<RecipeSearchResult> items, String baseURL, Context context) {
        this.items = items;
        this.baseURL = baseURL;
        this.context = context;
    }

    @NonNull
    @Override
    public RecipeResultViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recipe_result, viewGroup, false);
        return new RecipeResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeResultViewHolder holder, int position) {
        holder.bind(items.get(position),baseURL,context);
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }
}
