package com.example.blackjacksegev;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int bet,totalmoeny;
    private Button btn1, btn10, btn50, btn200,btnstartGame;
    private TextView betview, moneyview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        betview = findViewById(R.id.betview);
        btn1 = findViewById(R.id.btn1);
        btn10 = findViewById(R.id.btn10);
        btn50 = findViewById(R.id.btn50);
        btn200 = findViewById(R.id.btn200);
        moneyview = findViewById(R.id.moneyview);

        btnstartGame = findViewById(R.id.btnstart);
        btn1.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn50.setOnClickListener(this);
        btn200.setOnClickListener(this);
        btnstartGame.setOnClickListener(this);
        bet = 0;
        totalmoeny = 1000;
        moneyview.setText("You have:" + totalmoeny);

    }

    @Override
    public void onClick(View v) {
        if(v == btnstartGame)
        {
            if(bet > 0)
            {
                int win = 0;
                Intent intent = new Intent(this, GameActivity.class);
                intent.putExtra("bet",bet);
                startActivityForResult(intent,win);
            }
        }
        if(v == btn1)
        {
            if(1 <= totalmoeny)
            {
                bet = bet+1;
                totalmoeny = totalmoeny-1;
            }
        }
        if(v == btn10)
        {
            if(10 <= totalmoeny)
            {
                bet = bet+10;
                totalmoeny = totalmoeny-10;
            }
        }
        if(v == btn50)
        {
            if(50 <= totalmoeny)
            {
                bet = bet+50;
                totalmoeny = totalmoeny-50;
            }
        }
        if(v == btn200)
        {
            if(200 <= totalmoeny)
            {
                bet = bet+200;
                totalmoeny = totalmoeny-200;
            }
        }
        refresh();
    }

    private void refresh() {
        String string = "Your current bet is: " + bet;
        String string1 = "You have: " + totalmoeny;
        betview.setText(string);
        moneyview.setText(string1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int bet1 = bet;
        String result = data.getStringExtra("k");
        if(result.equals("1") )
        {
            totalmoeny = totalmoeny + bet1 * 2;
        }
        if(result.equals("0") )
        {
            totalmoeny = totalmoeny + bet1;
        }

        bet = 0;
        refresh();
    }
}