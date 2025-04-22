package com.example.blackjacksegev;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.LauncherActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int bet,totalmoeny;
    private Button btn1, btn10, btn50, btn200,btnstartGame, btnLogout, btnSettings, btnAddMoney;
    private TextView betview, moneyview;
    private ArrayList<MyMoney> myMonies;
    private String color;
    private HelperClass fb;
    private LinearLayout layout;
    private ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Intent i = new Intent(this, SignInActivity.class);
        startActivity(i);*/
        btnSettings = findViewById(R.id.btnSettings);
        betview = findViewById(R.id.betview);
        btn1 = findViewById(R.id.btn1);
        btn10 = findViewById(R.id.btn10);
        btn50 = findViewById(R.id.btn50);
        btn200 = findViewById(R.id.btn200);
        moneyview = findViewById(R.id.moneyview);
        btnLogout = findViewById(R.id.btnLogout);
        btnAddMoney = findViewById(R.id.btnaddmoney);
        myMonies = new ArrayList<>();
        fb = new HelperClass(this, myMonies);
        btnLogout.setOnClickListener(this);
        btnstartGame = findViewById(R.id.btnstart);
        btn1.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn50.setOnClickListener(this);
        btn200.setOnClickListener(this);
        btnstartGame.setOnClickListener(this);
        btnSettings.setOnClickListener(this);
        btnAddMoney.setOnClickListener(this);
        bet = 0;

        moneyview.setText("You have:" + totalmoeny);
        
        
        
        
        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult o) {
                if (o.getResultCode() == RESULT_OK) {
                    Intent data = o.getData();
                    int x = data.getIntExtra("MoneyMoney",1);
                    totalmoeny += x;
                    refresh();
                }
            }
        });
    }

        public void userDataChange(MyMoney currentRecord) {
        totalmoeny = currentRecord.getScore();
        moneyview.setText("You have:" + currentRecord.getScore());}

    @Override
    public void onClick(View v) {
        if(v == btnAddMoney)
        {
            Intent i1 = new Intent(this,MiniGameActivity.class);
            activityResultLauncher.launch(i1);
        }

        if(v == btnLogout)
        {
            FirebaseAuth.getInstance().signOut();
            finish();
        }
        if(v == btnstartGame)
        {
            if(bet > 0)
            {
                int win = 17;
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
        if(v == btnSettings)
        {
            Intent i1 = new Intent(this,SettingsActivity.class);
            startActivity(i1);
        }
        fb.setPrivateRecord(totalmoeny);
        refresh();
    }

    private void refresh() {
        String string = "Your current bet is: " + bet;
        String string1 = "You have: " + totalmoeny;
        betview.setText(string);
        moneyview.setText(string1);
        fb.setPrivateRecord(totalmoeny);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int bet1 = bet;
        if(requestCode == 17)
        {
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
}