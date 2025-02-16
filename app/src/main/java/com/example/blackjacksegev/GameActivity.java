package com.example.blackjacksegev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    private GameView gameView;
    private CardDeck deck;
    private ArrayList<Card> player;
    private ArrayList<Card> computer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        deck = new CardDeck(this);
        player = new ArrayList<>();
        computer = new ArrayList<>();
        LinearLayout layout1 = findViewById(R.id.canvasView);

        fill();
        gameView = new GameView(this,player,computer);
        layout1.addView(gameView);
    }

    private void fill() {
        player.add(deck.remover());
        computer.add(deck.remover());
        player.add(deck.remover());
        computer.add(deck.remover());
    }
}