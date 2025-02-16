package com.example.blackjacksegev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private GameView gameView;
    private CardDeck deck;
    private ArrayList<Card> player;
    private ArrayList<Card> computer;
    private Button btnStand, btnHit;
    private LinearLayout layout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        deck = new CardDeck(this);
        player = new ArrayList<>();
        computer = new ArrayList<>();
        layout1 = findViewById(R.id.canvasView);

        fill();
        gameView = new GameView(this,player,computer);
        layout1.addView(gameView);

        btnStand = findViewById(R.id.btnStand);
        btnHit = findViewById(R.id.btnHIT);
        btnStand.setOnClickListener(this);
        btnHit.setOnClickListener(this);
    }

    private void fill() {
        player.add(deck.remover());
        computer.add(deck.remover());
        player.add(deck.remover());
        computer.add(deck.remover());
    }

    @Override
    public void onClick(View v) {
        if(v == btnHit && player.size()<9)
        {
            player.add(deck.remover());
            gameView.setPlayer(player);
        }
        if(v == btnStand)
        {

        }

    }
}