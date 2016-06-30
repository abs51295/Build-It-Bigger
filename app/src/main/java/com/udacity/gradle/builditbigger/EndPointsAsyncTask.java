package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.aagamshah.myapplication.backend.myApi.MyApi;
import com.geek.aagamshah.jokelibrary.JokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by Aagam Shah on 6/29/2016.
 */
public class EndPointsAsyncTask extends AsyncTask<Context,Void,String> {
    private static MyApi myApiservice = null;
    private Context context;

    @Override
    protected String doInBackground(Context... params) {
        if(myApiservice == null){
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(),null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            myApiservice = builder.build();
        }
        context = params[0];


        try {
            return myApiservice.joke().execute().getData();
        }
        catch (IOException e){
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        //Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        Intent sendJoke = new Intent(context, JokeActivity.class);
        sendJoke.putExtra("Joke",result);
        context.startActivity(sendJoke);
    }
}
