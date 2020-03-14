package fr.esilv.howtocook;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import static android.content.Context.MODE_PRIVATE;

public class MenuFragment extends Fragment {

    View view;
    SearchView searchView;
    ResultFragment resultFragment = new ResultFragment();
    FragmentTransaction transaction;
    SharedPreferences sharedPreferences;


    public MenuFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_menu, container, false);
        searchView = view.findViewById(R.id.search_bar_view);

        sharedPreferences = getContext().getSharedPreferences(Constants.PREF_NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        transaction = getFragmentManager().beginTransaction();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                /*
                Intent intent = new Intent( getContext(), ResultActivity.class);
                intent.putExtra("QUERY", query);
                startActivity(intent);
                 */
                editor.putString("query1",query);
                editor.apply();
                Bundle bundle = new Bundle();
                bundle.putString("query", query);
                resultFragment.setArguments(bundle);
                transaction.replace(R.id.Main_frameLayout,resultFragment).commit();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return view;
    }

}
