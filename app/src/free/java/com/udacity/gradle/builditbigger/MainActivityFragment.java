package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by Aagam Shah on 6/30/2016.
 */
public class MainActivityFragment extends Fragment {
    View progressCircle;
    InterstitialAd mInterstitialAd;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        progressCircle = root.findViewById(R.id.progress_circle);
        progressCircle.setVisibility(View.INVISIBLE);
        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                showJoke();
            }
        });

        requestNewInterstitial();

        return root;
    }

    public void showJoke(){
        progressCircle.setVisibility(View.VISIBLE);
        new EndPointsAsyncTask().execute(getActivity());
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("SEE_YOUR_LOGCAT_TO_GET_YOUR_DEVICE_ID")
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

    public void tellJoke(View view) {
        progressCircle.setVisibility(View.VISIBLE);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            new EndPointsAsyncTask().execute(getActivity());
        }
    }
}
