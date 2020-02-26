package com.example.volleypractice.data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.volleypractice.controllers.AppController;
import com.example.volleypractice.model.Joke;

import org.json.JSONException;
import org.json.JSONObject;

public class JokeRepository {
    private String url = "https://official-joke-api.appspot.com/jokes/random";

    public void getJoke(final GetJokeListener callback){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Joke j = new Joke();

                        try {
                            j.setJokeId(response.getInt("id"));
                            j.setJokeType(response.getString("type"));
                            j.setJokeSetup(response.getString("setup"));
                            j.setJokePunchline(response.getString("punchline"));

                            Log.d("JokeRepoTry", "onResponse: " + j.getJokeSetup());
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d("JokeRepoCatch", "onResponse: " + e);
                        }

                        if(callback != null)
                            callback.JokeReceived(j);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("JokeRepoErr", "onErrorResponse: " + error);
                    }
                });

        AppController.getInstance().addToRequestQueue(jsonObjectRequest);
    }
}
