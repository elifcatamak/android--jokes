package com.example.volleypractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.volleypractice.data.GetJokeListener;
import com.example.volleypractice.data.JokeRepository;
import com.example.volleypractice.model.Joke;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView jokeSetupTextView;
    private TextView jokePunchlineTextView;
    private ImageButton playImageBtn;

    private List<Joke> jokeList;
    private int jokeIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jokeSetupTextView = findViewById(R.id.textView_jokeSetup);
        jokePunchlineTextView = findViewById(R.id.textView_jokePunchline);
        playImageBtn = findViewById(R.id.imageButton_play);

        jokeList = new JokeRepository().getTenJokes(new GetJokeListener() {
            @Override
            public void JokesReceived(ArrayList<Joke> jokeArrayList) {
                Log.d("JOKE", "JokesReceived: " + jokeArrayList.get(0).getJokeSetup());
                jokeSetupTextView.setText(jokeArrayList.get(jokeIndex).getJokeSetup());
                jokePunchlineTextView.setText(jokeArrayList.get(jokeIndex).getJokePunchline());
            }
        });
    }
}
