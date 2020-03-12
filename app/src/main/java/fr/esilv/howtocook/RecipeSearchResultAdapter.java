package fr.esilv.howtocook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecipeSearchResultAdapter extends RecyclerView.Adapter<RecipeResultViewHolder>  {

    private final List<RecipeSearchResult> items;

    public RecipeSearchResultAdapter(List<RecipeSearchResult> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecipeResultViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recipe_result, viewGroup, false);
        return new RecipeResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeResultViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }
}
