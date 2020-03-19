package fr.esilv.howtocook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GridRecipeSearchResultAdpater extends RecyclerView.Adapter<GridRecipeViewHolder>  {
    private final List<RecipeSearchResult> items;
    private final String baseURI;
    private Context context;

    public GridRecipeSearchResultAdpater(List<RecipeSearchResult> items, String baseURI, Context context) {
        this.items = items;
        this.baseURI = baseURI;
        this.context = context;
    }

    @NonNull
    @Override
    public GridRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_recipe_result, viewGroup, false);
        return new GridRecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridRecipeViewHolder holder, int position) {
        holder.bind(items.get(position),baseURI,context);
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }
}
