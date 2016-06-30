package com.geek.aagamshah.jokelibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView joke = (TextView) findViewById(R.id.joke);
        Intent intent = getIntent();
        try {

            joke.setText(intent.getStringExtra("Joke"));
        }
        catch (Exception np){
            Log.e(np.toString(),"Failed to receive intent");
        }
    }
}
