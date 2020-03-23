package fr.esilv.howtocook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.esilv.howtocook.Model.Ingredient;

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsViewHolder> {

    private final List<Ingredient> ingredients;

    public IngredientsAdapter(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @NonNull
    @Override
    public IngredientsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ingredient_instruction_view, parent, false);
        return new IngredientsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientsViewHolder holder, int position) {
        holder.bind(ingredients.get(position));
    }

    @Override
    public int getItemCount() {
        return ingredients != null ? ingredients.size() : 0;
    }
}
