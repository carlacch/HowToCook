package fr.esilv.howtocook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.esilv.howtocook.Model.Ingredient;
import fr.esilv.howtocook.Model.Step;

public class InstructionsAdapter extends RecyclerView.Adapter<InstructionsViewHolder> {

    private final List<Step> steps;

    public InstructionsAdapter(List<Step> steps) {
        this.steps = steps;
    }

    @NonNull
    @Override
    public InstructionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ingredient_instruction_view, parent, false);
        return new InstructionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InstructionsViewHolder holder, int position) {
        holder.bind(steps.get(position));
    }

    @Override
    public int getItemCount() {
        return steps != null ? steps.size() : 0;
    }
}
