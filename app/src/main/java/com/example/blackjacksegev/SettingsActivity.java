package com.example.blackjacksegev;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Set;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {
    private boolean isMusicPlaying = false;
    private Button musicButton, btnDone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        musicButton = findViewById(R.id.musicButton);
        btnDone = findViewById(R.id.btnDone);
        btnDone.setOnClickListener(this);
        musicButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == musicButton)
        {
            if (!isMusicPlaying) {
                // Start the music service
                startService(new Intent(SettingsActivity.this, MusicService.class));
                isMusicPlaying = true;
                musicButton.setText("Stop Music");
            } else {
                // Stop the music service
                stopService(new Intent(SettingsActivity.this, MusicService.class));
                isMusicPlaying = false;
                musicButton.setText("Play Music");
            }
        }
        if(v == btnDone)
        {
            finish();
        }

    }
}