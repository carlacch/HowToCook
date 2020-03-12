package fr.esilv.howtocook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    //private EditText searchBar;
    //private Button searchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*
        searchBar = findViewById(R.id.main_activity_search_bar);
        searchBtn = findViewById(R.id.activity_name_search_btn);

        searchBtn.setOnClickListener(v -> {
            String query = searchBar.getText().toString();
            Intent intent = new Intent(v.getContext(), ResultActivity.class);
            intent.putExtra("QUERY", query);
            startActivity(intent);
        });*/


    }
}
