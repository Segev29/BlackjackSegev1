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
    private Button btn1, btn10, btn50, btn200,btnstartGame, btnLogout, btnSettings;
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
        bet = 0;

        moneyview.setText("You have:" + totalmoeny);
        
        
        
        
        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult o) {
                if (o.getResultCode() == RESULT_OK) {
                    Intent data = o.getData();
                    color = data.getStringExtra("color");
                    colors1();
                    Toast.makeText(MainActivity.this, color, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

        public void userDataChange(MyMoney currentRecord) {
        totalmoeny = currentRecord.getScore();
        moneyview.setText("You have:" + currentRecord.getScore());}
    public void colors1()
    {

        switch (color)
        {
            case "blue":
            {
                btn1.setBackgroundColor(Color.BLUE);
                btn10.setBackgroundColor(Color.BLUE);
                btn50.setBackgroundColor(Color.BLUE);
                btn200.setBackgroundColor(Color.BLUE);
                break;

            }
            case "red":
            {
                btn1.setBackgroundColor(Color.RED);
                btn10.setBackgroundColor(Color.RED);
                btn50.setBackgroundColor(Color.RED);
                btn200.setBackgroundColor(Color.RED);
                break;
            }
            case "green":
            {
                btn1.setBackgroundColor(Color.GREEN);
                btn10.setBackgroundColor(Color.GREEN);
                btn50.setBackgroundColor(Color.GREEN);
                btn200.setBackgroundColor(Color.GREEN);
                break;
            }
            default:
                Toast.makeText(MainActivity.this, "No valid color selected", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onClick(View v) {

        if(v == btnLogout)
        {
            FirebaseAuth.getInstance().signOut();
            finish();
        }
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
        if(v == btnSettings)
        {
            Intent i1 = new Intent(this,SettingsActivity.class);
            activityResultLauncher.launch(i1);
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