package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Aagam Shah on 6/30/2016.
 */
public class MainActivityFragment extends Fragment {

    View progressCircle;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        progressCircle = root.findViewById(R.id.progress_circle);
        progressCircle.setVisibility(View.INVISIBLE);
        return root;

    }

    public void tellJoke(View view) {
        progressCircle.setVisibility(View.VISIBLE);
        new EndPointsAsyncTask().execute(getActivity());
    }
}

