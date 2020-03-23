package fr.esilv.howtocook;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fr.esilv.howtocook.Model.Ingredient;

public class IngredientsViewHolder extends RecyclerView.ViewHolder {

    private TextView ingredientText;

    public IngredientsViewHolder(@NonNull View itemView) {
        super(itemView);
        this.ingredientText = itemView.findViewById(R.id.instruction_ingredient_name);
    }

    public void bind(final Ingredient ingredient) {
        ingredientText.setText(ingredient.getOriginal());
    }
}
