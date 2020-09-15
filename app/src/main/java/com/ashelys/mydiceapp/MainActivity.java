package com.ashelys.mydiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.dice_sound);

        // references for the dice images that changes on button tap
        final ImageView diceImg1 = findViewById(R.id.imgDice1);
        final ImageView diceImg2 = findViewById(R.id.imgDice2);

        //array to store value of the dices after rolling
        final int [] diceImages = { R.drawable.dice1, R.drawable.dice2, R.drawable.dice3,
                                  R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};

       // reference for the button in the view
        Button btnRoll = findViewById(R.id.btnRollTheDice);

        //onclick listener to respond to the clicks of the button
        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("Mydiceapp", "button tapped now");

                //generating a random number  between  0...5  to use in dice display
                int random = (int)(Math.random()*6); // 0....5
                Log.i("Mydiceapp", "is" +random);

                //setting the random number in dice to the image view to display on the ui. for dice 1
                diceImg1.setImageResource(diceImages[random]);

                // regenerating random value for using in dice 2
                random = (int) (Math.random()*6);
                diceImg2.setImageResource(diceImages[random]);


                //shake animation implementation for dice images.
                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .repeat(0)
                        .playOn(diceImg1);
                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .repeat(0)
                        .playOn(diceImg2);

                mp.start();
            }
        });
    }
}