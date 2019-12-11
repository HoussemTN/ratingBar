package com.brains404.ratingbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import static com.brains404.ratingbar.Const.DEFAULT_RATING_VALUE;

public class MainActivity extends AppCompatActivity {
    RatingBar ratingBar ;
    Button submit ;

    SharedPreferences ratingPrefs ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ratingBar= findViewById(R.id.ratingBar);
        submit = findViewById(R.id.submit);

        ratingPrefs= getSharedPreferences(Const.RATING_PREFS_NAME,MODE_PRIVATE);
        if (ratingPrefs.contains(Const.RATING_PREFS_NAME)){
            ratingBar.setRating(ratingPrefs.getFloat(Const.RATING_VALUE, DEFAULT_RATING_VALUE));
        }
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               SharedPreferences.Editor editRatingPrefs = ratingPrefs.edit().putFloat(Const.RATING_VALUE, ratingBar.getRating());
               editRatingPrefs.apply();
                Log.d(Const.RATING_VALUE, String.valueOf(ratingPrefs.getFloat(Const.RATING_VALUE, DEFAULT_RATING_VALUE)));
                Toast.makeText(getApplicationContext(),"Rate : "+ratingBar.getRating(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,Rated.class);
                finish();
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);


        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.act_refresh) {
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
            return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
