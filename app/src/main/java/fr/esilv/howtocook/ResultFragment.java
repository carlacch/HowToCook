package fr.esilv.howtocook;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.MODE_PRIVATE;

/*
/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ResultFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ResultFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResultFragment extends Fragment {

    private TextView no_result;
    private String query;
    private View view;
    private RecyclerView recyclerView;
    private final String BaseURL = "https://api.spoonacular.com/recipes/";
    //private OnFragmentInteractionListener mListener;

    public ResultFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_result, container, false);
        recyclerView = view.findViewById(R.id.result_activity_recycler_view);
        no_result = view.findViewById(R.id.no_result_text);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        setQuery();

        LaunchService launch = new LaunchService(retrofit, no_result, recyclerView, this.getContext());
        launch.launchService(query);
        return view ;
    }

    private void setQuery() {
        SharedPreferences sharedPreferences;
        Bundle bundle = getArguments();
        if (bundle != null) {
            query = bundle.getString("query");
        }
        else {
            sharedPreferences = getContext().getSharedPreferences(Constants.PREF_NAME,MODE_PRIVATE);
            query = sharedPreferences.getString("query1","none");
        }
    }

}
