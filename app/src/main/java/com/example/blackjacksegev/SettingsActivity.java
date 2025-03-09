package com.example.blackjacksegev;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Set;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private boolean isMusicPlaying = false;
    private Button musicButton, btnDone;
    private Spinner spinner;
    private String[] arr = {"","red","green","blue"};
    private ArrayAdapter<String> stringArrayAdapter;
    private boolean isfirsttime = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        musicButton = findViewById(R.id.musicButton);
        btnDone = findViewById(R.id.btnDone);
        spinner = findViewById(R.id.spinnerColors);
        stringArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                arr);
        stringArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(stringArrayAdapter);
        btnDone.setOnClickListener(this);
        musicButton.setOnClickListener(this);
        spinner.setOnItemClickListener(this);

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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(isfirsttime==false){
            Intent intent = new Intent();
            intent.putExtra("color",arr[position]);
            setResult(RESULT_OK,intent);
            finish();
        }
        isfirsttime= false;
    }

}