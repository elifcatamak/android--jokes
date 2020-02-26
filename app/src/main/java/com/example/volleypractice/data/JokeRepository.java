package com.example.volleypractice.data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.volleypractice.controllers.AppController;
import com.example.volleypractice.model.Joke;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JokeRepository {
    private ArrayList<Joke> jokeList;
    private String urlTen = "https://official-joke-api.appspot.com/jokes/ten";
    private String urlOne = "https://official-joke-api.appspot.com/jokes/random";

    public List<Joke> getTenJokes(final GetJokeListener callback){
        jokeList = new ArrayList<>();

        JsonArrayRequest jsonArrReq = new JsonArrayRequest(Request.Method.GET, urlTen, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for(int i=0; i<response.length(); i++){
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);

                                Joke j = new Joke();
                                j.setJokeId(jsonObject.getInt("id"));
                                j.setJokeType(jsonObject.getString("type"));
                                j.setJokeSetup(jsonObject.getString("setup"));
                                j.setJokePunchline(jsonObject.getString("punchline"));

                                // Log.d("JokeRepo", "onResponse: JokeSetup " + i + ": " + j.getJokeSetup());

                                jokeList.add(j);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        if(callback != null)
                            callback.JokesReceived(jokeList);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        AppController.getInstance().addToRequestQueue(jsonArrReq);

        return jokeList;
    }
}
