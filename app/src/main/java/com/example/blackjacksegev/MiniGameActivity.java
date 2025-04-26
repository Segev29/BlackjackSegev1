package com.example.blackjacksegev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MiniGameActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etOdds;
    private Button btnSubmit, btnHelp;
    private TextView score;
    private int points = 0, lastadd = 0, round = 0;
    private boolean Streak = false;
    private ArrayList<Card> player;
    private CardDeck deck;
    private MiniGameView miniGameView;
    private LinearLayout layout1;
    CustomDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_game);
        score = findViewById(R.id.txtScore1);
        score.setText("you have : 0 points");
        etOdds = findViewById(R.id.etWHATARETHEODDS);
        layout1 = findViewById(R.id.canvasView1);
        player = new ArrayList<>();
        deck = new CardDeck(this);
        player.add(deck.remover());
        player.add(deck.remover());
        btnHelp = findViewById(R.id.btnHelp);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnHelp.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
        miniGameView = new MiniGameView(this,player);
        layout1.addView(miniGameView);
        }


    @Override
    public void onClick(View v) {
        if(v == btnHelp)
        {
            dialog = new CustomDialog(this);
            dialog.show();
        }
        else {
            int x = Odds();
            if (Integer.parseInt(etOdds.getText().toString()) == x) {
                if (Streak) {
                    points += lastadd + 1;
                    lastadd++;
                } else {
                    Streak = true;
                    points++;
                    lastadd = 1;
                }
            }
            else
            {
                Streak = false;
            }
            round++;
            if (round == 10) {
                Intent i = new Intent();
                i.putExtra("MoneyMoney", points * 10);
                setResult(RESULT_OK, i);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                }, 4000);
            }
            else
            {
                update();
            }
        }

    }
    public void update()
    {

        deck = new CardDeck(this);
        player = new ArrayList<>();
        player.add(deck.remover());
        player.add(deck.remover());
        score.setText("you have : " + points + " points");
        miniGameView.setPlayer(player);
    }

    public int Odds()
    {
        int busters = 0;
        int playersum = 0;
        if(player.get(0).getNumber() >=10)
        {
            playersum += 10;
        }
        else
        {
            playersum += player.get(0).getNumber();
        }
        if(player.get(1).getNumber() >=10)
        {
            playersum += 10;
        }
        else
        {
            playersum += player.get(1).getNumber();
        }
        for (int i = 0; i < deck.getLength(); i++) {
            if(deck.getArrCard().get(i).getNumber() >= 10)
            {
                if(playersum + 10 > 21)
                {
                    busters++;
                }
            }
            else
            {
                if(playersum + deck.getArrCard().get(i).getNumber() > 21)
                    busters++;
            }
        }
        return busters*100/50;
    }
}