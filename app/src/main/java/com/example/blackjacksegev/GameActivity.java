package com.example.blackjacksegev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
    private ArrayList<Card> playerSplitted;
    private Button btnStand, btnHit, btnSplit;
    private LinearLayout layout1;
    private int sumPlayer=0, sumComputer=0, sumPlayerSplit=0, firstpartofthegame;
    private String p,c;
    private TextView txtplayer, txtcomputer;
    private boolean split, endfirstsplit;
    //int bet,totalmoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        txtplayer = findViewById(R.id.txtplayer);
        txtcomputer = findViewById(R.id.txtcomputer);
        btnStand = findViewById(R.id.btnStand);
        btnHit = findViewById(R.id.btnHIT);
        btnSplit = findViewById(R.id.btnsplit);
        btnStand.setOnClickListener(this);
        btnHit.setOnClickListener(this);
        layout1 = findViewById(R.id.canvasView);
        btnSplit.setOnClickListener(this);
        reset();
        gameView = new GameView(this,player,computer);
        layout1.addView(gameView);
        split = false;
        endfirstsplit = false;

    }

    public void reset() {
        deck = new CardDeck(this);
        player = new ArrayList<>();
        computer = new ArrayList<>();
        playerSplitted = new ArrayList<>();
        //תוסיף challenges וגם את הhint
        //תוסיף challenges וגם את הhint
        //תוסיף challenges וגם את הhint
        //תוסיף challenges וגם את הhint
        //תוסיף challenges וגם את הhint
        //תוסיף challenges וגם את הhint
        //totalmoney = 1500;
        //bet = 0;
        fill();
    }


    private void fill() {
        player.add(deck.remover());
        computer.add(deck.remover());
        player.add(deck.remover());
        computer.add(deck.remover());
        addCardsBeforeSplit();
    }
    private void addCardsBeforeSplit()
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
        p = "you: " +sumPlayer;
        c = "computer: " + sumComputer;
        txtcomputer.setText(p);
        txtplayer.setText(c);
    }
    private void addCardsAfterSplit()
    {
        sumPlayerSplit = 0;
        sumComputer = 0;
        for (int i = 0; i < playerSplitted.size(); i++) {
            if(playerSplitted.get(i).getNumber() > 10)
            {
                sumPlayerSplit = sumPlayerSplit + 10;
            }
            else { sumPlayerSplit = sumPlayerSplit +playerSplitted.get(i).getNumber();}
        }
        for (int i = 0; i < computer.size(); i++) {
            if(computer.get(i).getNumber() > 10)
            {
                sumComputer = sumComputer + 10;
            }
            else { sumComputer = sumComputer +computer.get(i).getNumber();}
        }
        p = "you: " +sumPlayerSplit;
        c = "computer: " + sumComputer;
        txtcomputer.setText(p);
        txtplayer.setText(c);
    }
    private void createDialog() {
        CustomDialog customDialog = new CustomDialog(this);
        customDialog.show();
    }
    @Override
    public void onClick(View v) {
        if(v == btnHit /*&& player.size()<9*/)
        {
            if(split)
            {
                if(endfirstsplit == true)
                {
                    gameView.setPlayer(playerSplitted);
                    playerSplitted.add(deck.remover());
                    addCardsAfterSplit();
                }
                else
                {
                    player.add(deck.remover());
                    gameView.setPlayer(player);
                    addCardsBeforeSplit();
                }
            }
            else
            {
                player.add(deck.remover());
                gameView.setPlayer(player);
                addCardsBeforeSplit();
            }
        }
        if(v == btnSplit && player.size() == 2 && player.get(1).getNumber() == player.get(0).getNumber())
        {
            playerSplitted.add(player.get(1));
            player.remove(1);
            split = true;
            gameView.setPlayer(player);
            addCardsBeforeSplit();
        }
        if(v == btnStand) {
            Intent i = new Intent();
            if(split == false)
            {
                while (sumComputer < 17) {
                    computer.add(deck.remover());
                    gameView.setComputer(computer);
                    //להוסיף בחירת צבע רקע למרות שזה מכוער
                    //לדבר עם הקלוד ולעשות עיצוב מגניב יותר
                    //אם ישנה אפשרות להוסיף גם פראגמנט
                    addCardsBeforeSplit();
                }
                addCardsBeforeSplit();
                switch (winner(sumComputer,sumPlayer))
                {
                    case (1):
                    {
                        i.putExtra("k", "1");
                        txtcomputer.setText("you win!");
                        txtplayer.setText("you win!");
                        break;
                    }
                    case (0):
                    {
                        i.putExtra("k", "0");
                        txtcomputer.setText("draw");
                        txtplayer.setText("draw");
                    }
                    default:
                    {

                        i.putExtra("k", "2");
                        txtcomputer.setText("you lost");
                        txtplayer.setText("you lost");
                    }
                }
                setResult(RESULT_OK,i);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                },2500);
            }
            else
            {

                if(endfirstsplit == false)
                {
                    addCardsAfterSplit();
                    gameView.setPlayer(playerSplitted);
                    endfirstsplit = true;
                }
                else
                {
                    while (sumComputer < 17) {
                        computer.add(deck.remover());
                        gameView.setComputer(computer);
                        //להוסיף בחירת צבע רקע למרות שזה מכוער
                        //לדבר עם הקלוד ולעשות עיצוב מגניב יותר
                        //אם ישנה אפשרות להוסיף גם פראגמנט
                        addCardsBeforeSplit();
                    }
                    int part1 = winner(sumComputer,sumPlayer);
                    int part2 = winner(sumComputer,sumPlayerSplit);
                    if((part1 == 1 && part2 == 1) || (part1 == 1 && part2 == 0) || (part1 == 0 && part2 == 1))
                    {
                        i.putExtra("k", "1");
                        txtcomputer.setText("you win!");
                        txtplayer.setText("you win!");
                    } else if ((part2 == 0 && part1 == 0) || (part1 == 1 && part2 == 2) || (part1 == 2 && part2 == 1)) {
                        i.putExtra("k", "0");
                        txtcomputer.setText("Draw");
                        txtplayer.setText("Draw");
                    }
                    else
                    {
                        i.putExtra("k", "2");
                        txtcomputer.setText("you lost");
                        txtplayer.setText("you lost");
                    }
                    setResult(RESULT_OK,i);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            finish();
                        }
                    },2500);
                }

                //write the logic of win and lose in split! draw and win = win. win and win = win. draw and draw = draw. draw and lose = lose. lost and win = draw. lose and lose = lost

            }
        }
        //addCards();
    }
    public int winner(int c, int p){
        if((c > 21 && p < 22) || (p < 22 && p > c))
        {
            return 1;
        }
        else if (p < 22 && p == c) {
            return 0;
        }
        else if(p > 22 && c > 22)
        {
            return 2;
        }
        else if (c < 22 && c > p)
        {
            return 2;
        }
        else if (p > 21) {
            return 2;
        }
        else
        {
            return 2;
        }
    }

    public int HintSystem()
    {
        int busters = 0;
        double stats;
        for(int i = 0; i < deck.getArrCard().size(); i++)
        {
            if(sumPlayer < 12)
            {
                return 1;
            }
            if(split == false)
            {
                if(deck.getArrCard().get(i).getNumber() + sumPlayer > 21)
                {
                    busters++;
                }
            }
            else
            {
                if(endfirstsplit)
                {
                    if(deck.getArrCard().get(i).getNumber() + sumPlayerSplit > 21)
                    {
                        busters++;
                    }
                }
                else
                {
                    if(deck.getArrCard().get(i).getNumber() + sumPlayer > 21)
                    {
                        busters++;
                    }
                }
            }
            stats = busters/deck.getArrCard().size()*100;
            if(stats < 35)
            {
                return 1;
            }
            if(stats > 50)
            {
                return 2;
            }
            if(stats > 35 && stats < 50)
            {
                return (int)stats;
            }

        }
        return -1;
        //להוסיף כפתור של int
        //להוסיף מfake api
        //איי פי איי של חידות כאלה שתהיה שאלה על המסך ואז זה ישאל אותך מה לעשות ואז אם אתה בוחר ככה וצדקת אתה מקבל עוד 50 כסף
    }
}