package com.example.blackjacksegev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MiniGameActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnsplit, btnhit, btnstand;
    private TextView score;
    private int points = 0, sumPlayer;
    private ArrayList<Card> player;
    private CardDeck deck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_game);
        score = findViewById(R.id.txtScore1);
        btnsplit = findViewById(R.id.btnsplit1);
        btnhit = findViewById(R.id.btnHIT1);
        btnstand = findViewById(R.id.btnStand1);
        score.setText("you have : 0 points");
        btnstand.setOnClickListener(this);
        btnhit.setOnClickListener(this);
        btnsplit.setOnClickListener(this);
        player = new ArrayList<>();
        player.add(deck.remover());
        player.add(deck.remover());
        }

    @Override
    public void onClick(View v) {

    }
    public int HintSystem()
    {
        int busters = 0;
        double stats;
        return -1;
    }
}