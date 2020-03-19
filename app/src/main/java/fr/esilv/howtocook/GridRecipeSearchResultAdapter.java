package fr.esilv.howtocook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GridRecipeSearchResultAdapter extends RecyclerView.Adapter<GridRecipeViewHolder>  {
    private final List<RecipeSearchResult> items;

    public GridRecipeSearchResultAdapter(List<RecipeSearchResult> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public GridRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_recipe_result, viewGroup, false);
        return new GridRecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridRecipeViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }
}
