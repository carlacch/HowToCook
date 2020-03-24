package fr.esilv.howtocook;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecipeResultViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView title;
    private TextView time_prep;
    private ImageView imageView;
    private String recipeID;

    public RecipeResultViewHolder(@NonNull View itemView) {
        super(itemView);
        this.title = itemView.findViewById(R.id.recipe_result_title);
        this.time_prep = itemView.findViewById(R.id.recipe_time_prep);
        this.imageView = itemView.findViewById(R.id.recipe_image);
        itemView.setOnClickListener(this);
    }

    public void bind(final RecipeSearchResult recipeSearchResult, String baseURI, Context context) {
        recipeID=recipeSearchResult.getId();
        title.setText(recipeSearchResult.getTitle());
        List<String> listIm = recipeSearchResult.getImageUrls();
        Picasso.get().load(baseURI+listIm.get(listIm.size()-1)).resize(180,180).centerCrop().into(imageView);
        String time = recipeSearchResult.getReadyInMinutes()+ context.getResources().getString(R.string.min);
        time_prep.setText(time);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), DetailsActivity.class);
        intent.putExtra("RECIPE_ID", recipeID);
        v.getContext().startActivity(intent);
    }
}
