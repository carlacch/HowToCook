package fr.esilv.howtocook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText searchBar;
    private Button searchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchBar = findViewById(R.id.main_activity_search_bar);
        searchBtn = findViewById(R.id.activity_name_search_btn);

        searchBtn.setOnClickListener(v -> {
            String query = searchBar.getText().toString();
            Intent intent = new Intent(v.getContext(), ResultActivity.class);
            intent.putExtra("QUERY", query);
            startActivity(intent);
        });


    }
}
