package com.example.volleypractice.model;

public class Joke {
    int jokeId;
    String jokeType;
    String jokeSetup;
    String jokePunchline;

    public Joke() {
    }

    public Joke(int jokeId, String jokeType, String jokeSetup, String jokePunchline) {
        this.jokeId = jokeId;
        this.jokeType = jokeType;
        this.jokeSetup = jokeSetup;
        this.jokePunchline = jokePunchline;
    }

    public int getJokeId() {
        return jokeId;
    }

    public void setJokeId(int jokeId) {
        this.jokeId = jokeId;
    }

    public String getJokeType() {
        return jokeType;
    }

    public void setJokeType(String jokeType) {
        this.jokeType = jokeType;
    }

    public String getJokeSetup() {
        return jokeSetup;
    }

    public void setJokeSetup(String jokeSetup) {
        this.jokeSetup = jokeSetup;
    }

    public String getJokePunchline() {
        return jokePunchline;
    }

    public void setJokePunchline(String jokePunchline) {
        this.jokePunchline = jokePunchline;
    }
}
