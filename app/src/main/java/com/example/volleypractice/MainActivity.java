package com.example.volleypractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.volleypractice.data.GetJokeListener;
import com.example.volleypractice.data.JokeRepository;
import com.example.volleypractice.model.Joke;

public class MainActivity extends AppCompatActivity {
    private TextView jokeSetupTextView;
    private TextView jokePunchlineTextView;
    private Button newJokeBtn;

    private JokeRepository jokeRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jokeSetupTextView = findViewById(R.id.textView_jokeSetup);
        jokePunchlineTextView = findViewById(R.id.textView_jokePunchline);
        newJokeBtn = findViewById(R.id.button_newJoke);

        jokeRepository = new JokeRepository();
        getNewJoke();

        newJokeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNewJoke();
            }
        });
    }

    public void getNewJoke(){
        jokeRepository.getJoke(new GetJokeListener() {
            @Override
            public void JokeReceived(Joke joke) {
                jokeSetupTextView.setText(joke.getJokeSetup());
                jokePunchlineTextView.setText(joke.getJokePunchline());
            }
        });
    }
}
