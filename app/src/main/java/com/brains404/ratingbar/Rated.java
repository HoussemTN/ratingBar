package com.brains404.ratingbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class Rated extends AppCompatActivity {
    Button back ;
    RatingBar ratedBar ;
    SharedPreferences ratingPrefs ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rated);
     back = findViewById(R.id.back);
     ratedBar = findViewById(R.id.ratedBar);
        ratingPrefs= getSharedPreferences(Const.RATING_PREFS_NAME,MODE_PRIVATE);
        if (ratingPrefs.contains(Const.RATING_VALUE)) {
            ratedBar.setRating(ratingPrefs.getFloat(Const.RATING_VALUE, Const.DEFAULT_RATING_VALUE));
        }


     back.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent (Rated.this,MainActivity.class);
             startActivity(intent);
         }
     });
    }
}
