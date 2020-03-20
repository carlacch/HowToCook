package fr.esilv.howtocook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    String recipeID;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        title = findViewById(R.id.details_activity_title);

        Intent intent= getIntent();
        recipeID = intent.getExtras().getString("RECIPE_ID");
        title.setText(recipeID);
    }
}
