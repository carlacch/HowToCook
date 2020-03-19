package fr.esilv.howtocook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    //private EditText searchBar;
    //private Button searchBtn;
    Fragment frag_menu = new MenuFragment();
    Fragment frag_starter = new StarterFragment();
    Fragment frag_main = new MainFragment();

    private BottomNavigationView bottomNavigationView;
    private BottomNavigationView.OnNavigationItemSelectedListener itemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.home :
                    showFragment(frag_menu);
                    break;
                case R.id.starter :
                    showFragment(frag_starter);
                    break;
                case R.id.main_courses :
                    showFragment(frag_main);
                    break;
                case R.id.desserts :
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        showFragment(new MenuFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(itemSelectedListener);

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

    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.Main_frameLayout, fragment)
                .commit();
    }
}
