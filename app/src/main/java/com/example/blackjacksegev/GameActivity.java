package com.example.blackjacksegev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private GameView gameView;
    private CardDeck deck;
    private ArrayList<Card> player;
    private ArrayList<Card> computer;
    private Button btnStand, btnHit;
    private LinearLayout layout1;
    private int sumPlayer, sumComputer;
    private String p,c;
    private TextView txtplayer, txtcomputer;
    int bet,totalmoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        txtplayer = findViewById(R.id.txtplayer);
        txtcomputer = findViewById(R.id.txtcomputer);
        deck = new CardDeck(this);
        player = new ArrayList<>();
        computer = new ArrayList<>();
        btnStand = findViewById(R.id.btnStand);
        btnHit = findViewById(R.id.btnHIT);
        btnStand.setOnClickListener(this);
        btnHit.setOnClickListener(this);
        totalmoney = 1500;
        bet = 0;
        layout1 = findViewById(R.id.canvasView);

        fill();
        gameView = new GameView(this,player,computer);
        layout1.addView(gameView);


    }

    private void fill() {
        player.add(deck.remover());
        computer.add(deck.remover());
        player.add(deck.remover());
        computer.add(deck.remover());
        addCards();
    }
    private void addCards()
    {
        sumPlayer = 0;
        sumComputer = 0;
        for (int i = 0; i < player.size(); i++) {
            if(player.get(i).getNumber() > 10)
            {
                sumPlayer = sumPlayer + 10;
            }
            else { sumPlayer = sumPlayer +player.get(i).getNumber();}
        }
        for (int i = 0; i < computer.size(); i++) {
            if(computer.get(i).getNumber() > 10)
            {
                sumComputer = sumComputer + 10;
            }
            else { sumComputer = sumComputer +computer.get(i).getNumber();}
        }
        p = "" +sumPlayer;
        c = "" + sumComputer;
        txtcomputer.setText(p);
        txtplayer.setText(c);
    }
    private void createDialog() {
        CustomDialog customDialog = new CustomDialog(this);
        customDialog.show();
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
            while (sumComputer < 17)
            {
                computer.add(deck.remover());
                gameView.setComputer(computer);
                addCards();
                //להוסיף קצת לוגיקת משחק שתגדיר מי ניצח ומי לא ותשים את הכסף בארנק של השחקן.
                //להוסיף מוזיקה
                //להוסיף בחירת צבע רקע למרות שזה מכוער
                //לדבר עם הקלוד ולעשות עיצוב מגניב יותר
                //אם ישנה אפשרות להוסיף גם פראגמנט
                //להוסיף הרשמה ושמירת נתונים ויצירת חשבון חדש
            }
            this.createDialog();
        }
        addCards();
    }
}