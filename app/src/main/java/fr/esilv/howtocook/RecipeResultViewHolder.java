package fr.esilv.howtocook;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecipeResultViewHolder extends RecyclerView.ViewHolder {

    private TextView title;

    public RecipeResultViewHolder(@NonNull View itemView) {
        super(itemView);
        this.title = itemView.findViewById(R.id.recipe_result_title);
    }

    public void bind(final RecipeSearchResult recipeSearchResult) {
        title.setText(recipeSearchResult.getTitle());

    }
}
