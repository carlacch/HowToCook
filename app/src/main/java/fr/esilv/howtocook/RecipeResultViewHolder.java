package fr.esilv.howtocook;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class RecipeResultViewHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private TextView time_prep;
    private ImageView imageView;

    public RecipeResultViewHolder(@NonNull View itemView) {
        super(itemView);
        this.title = itemView.findViewById(R.id.recipe_result_title);
        this.time_prep = itemView.findViewById(R.id.recipe_time_prep);
        this.imageView = itemView.findViewById(R.id.recipe_image);
    }

    public void bind(final RecipeSearchResult recipeSearchResult, String baseURL, Context context) {
        title.setText(recipeSearchResult.getTitle());
        Picasso.get().load(baseURL+recipeSearchResult.getImage()).resize(180,180).centerCrop().into(imageView);
        String time = recipeSearchResult.getReadyInMinutes()+ context.getResources().getString(R.string.min);
        time_prep.setText(time);
    }
}
