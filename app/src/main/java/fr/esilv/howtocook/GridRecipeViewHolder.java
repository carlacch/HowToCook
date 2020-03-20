package fr.esilv.howtocook;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class GridRecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView title;
    private ImageView imageView;
    private String recipeID;


    public GridRecipeViewHolder(@NonNull View itemView) {
        super(itemView);
        this.title = itemView.findViewById(R.id.recipe_result_title);
        this.imageView = itemView.findViewById(R.id.recipe_image);
        itemView.setOnClickListener(this);
    }

    public void bind(final RecipeSearchResult recipeSearchResult) {
        recipeID = recipeSearchResult.getId();
        title.setText(recipeSearchResult.getTitle());
        Picasso.get().load(recipeSearchResult.getImage()).resize(180, 180).centerCrop().into(imageView);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), DetailsActivity.class);
        intent.putExtra("RECIPE_ID", recipeID);
        v.getContext().startActivity(intent);
    }
}