package fr.esilv.howtocook;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fr.esilv.howtocook.Model.Step;

public class InstructionsViewHolder extends RecyclerView.ViewHolder {

    private TextView instructionText;

    public InstructionsViewHolder(@NonNull View itemView) {
        super(itemView);
        this.instructionText = itemView.findViewById(R.id.instruction_ingredient_name);
    }

    public void bind(final Step step) {
        instructionText.setText(step.getStep());
    }
}
