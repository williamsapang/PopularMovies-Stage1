package com.example.samsophias.popularmoviesstage1;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setTitle("Movie Details");
        Intent i = getIntent();
        int position = i.getIntExtra("position", -1);
        Movie selectedMovie = Movie.movieList.get(position);

        TextView txtTitle = findViewById(R.id.txtTitle);
        TextView txtRelease = findViewById(R.id.txtRelease);
        TextView txtRatings = findViewById(R.id.txtRatings);
        TextView txtOverview = findViewById(R.id.txtOverview);
        ImageView imgThumb = findViewById(R.id.imgThumbnail);

        txtTitle.setText(selectedMovie.getTitle());
        txtRelease.setText("Release Date : "+selectedMovie.getRelease_date());
        txtRatings.setText("User Ratings : "+selectedMovie.getRatings().toString());
        txtOverview.setText(selectedMovie.getOverview());
        Picasso.with(this).load("https://image.tmdb.org/t/p/w185"+selectedMovie.getPoster_path()).into(imgThumb);
    }



}
