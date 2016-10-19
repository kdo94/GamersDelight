package edu.orangecoastcollege.cs273.mpaulding.gamersdelight;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class GameDetailsActivity extends AppCompatActivity {

    private ImageView gameDetailsImageView;
    private TextView gameDetailsNameTextView;
    private TextView gameDetailsDescriptionTextView;
    private RatingBar gameDetailsRatingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_details);

        // TODO:  Use the Intent object sent from GameListActivity to populate the Views on
        // TODO:  this layout, including the TextViews, RatingBar and ImageView with the Game details.
        gameDetailsImageView = (ImageView) findViewById(R.id.gameDetailsImageView);
        gameDetailsNameTextView = (TextView) findViewById(R.id.gameDetailsNameTextView);
        gameDetailsDescriptionTextView = (TextView) findViewById(R.id.gameDetailsDescriptionTextView);
        gameDetailsRatingBar = (RatingBar) findViewById(R.id.gameDetailsRatingBar);

        Intent gameDetails = getIntent();
        gameDetailsNameTextView.setText(gameDetails.getStringExtra("Game Name"));
        gameDetailsDescriptionTextView.setText(gameDetails.getStringExtra("Game Description"));
        gameDetailsRatingBar.setRating(gameDetails.getFloatExtra("Game Rating", 0));

        AssetManager am = this.getAssets();
        try{
            InputStream stream = am.open(gameDetails.getStringExtra("Game Image"));
            Drawable event = Drawable.createFromStream(stream, gameDetails.getStringExtra("Game Image"));
            gameDetailsImageView.setImageDrawable(event);
        }
        catch (IOException e){
            Log.e(gameDetails.getStringExtra("Game Image"), " cannot be loaded.");
        }
    }
}
