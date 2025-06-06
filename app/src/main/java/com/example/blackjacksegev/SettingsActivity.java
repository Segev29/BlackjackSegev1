package com.example.blackjacksegev;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
import java.util.Set;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {
    private boolean isMusicPlaying = false;
    private Button musicButton, btnDone, btnRead;
    private boolean isfirsttime = true;
    private TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        musicButton = findViewById(R.id.PlayMusic);
        btnDone = findViewById(R.id.btnDone);
        btnDone.setOnClickListener(this);
        musicButton.setOnClickListener(this);
        btnRead = findViewById(R.id.RuleRead);
        btnRead.setOnClickListener(this);

        textToSpeech= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

                // if No error is found then only it will run
                if(i!=TextToSpeech.ERROR){
                    // To Choose language of speech
                    textToSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });

    }


    @Override
    public void onClick(View v) {
        if(v == musicButton)
        {
            if (!isMusicPlaying) {
                // Start the music service
                musicButton.setText("Stop music");
                startService(new Intent(SettingsActivity.this, MusicService.class));
                isMusicPlaying = true;
            } else {
                musicButton.setText("Start music");
                // Stop the music service
                stopService(new Intent(SettingsActivity.this, MusicService.class));
                isMusicPlaying = false;
            }
        }
        if(v == btnDone)
        {
            finish();
        }
        if(v == btnRead)
        {

            textToSpeech.speak("nHow to Play Blackjack" +
                    "Goal: Get as close as possible to 21 without going over.  " +
                    "Card Values: Cards 2–10 = face value  " +
                    "J, Q, K = 10 points  " +
                    "A (Ace) = 1 point only  " +
                    "Your Turn: You start with 2 cards  " +
                    "You can choose to Hit (take another card) or Stand (keep your current hand)  " +
                    "If your total goes over 21, you bust and lose the round  " +
                    "Dealer's Turn: The dealer also has 2 cards (1 is visible)  " +
                    "The dealer keeps hitting until they reach at least 17  " +
                    "If they bust, you win  " +
                    "Who Wins: If you bust, you lose  " +
                    "If the dealer busts, you win  " +
                    "If both are under 21, the highest total wins  " +
                    "nIf it's a tie, it's a draw",TextToSpeech.QUEUE_FLUSH,null);
        }

    }



}