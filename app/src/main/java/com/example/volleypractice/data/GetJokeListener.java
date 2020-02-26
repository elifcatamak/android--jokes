package com.example.volleypractice.data;

import com.example.volleypractice.model.Joke;

import java.util.ArrayList;

public interface GetJokeListener {
    void JokesReceived(ArrayList<Joke> jokeArrayList);
}
