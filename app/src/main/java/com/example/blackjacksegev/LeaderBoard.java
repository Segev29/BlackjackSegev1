package com.example.blackjacksegev;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class LeaderBoard extends AppCompatActivity implements View.OnClickListener {

    private EditText etName;
    private EditText etRecord;
    private TextView tvWelcome;
    private Button btnAddRecordToDB, btnAddPrivateRecordToDB;
    private Button btnLogout;
    private MoneyAdapter adapter;
    private ArrayList<MyMoney> myRecords;
    private HelperClass fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);

        initialization();
        fb = new HelperClass(this, myRecords);
    }

    private void initialization() {
        // initialize
        etName = findViewById(R.id.etName);
        etRecord = findViewById(R.id.etScore);
        tvWelcome = findViewById(R.id.tvWelcome);
        btnAddRecordToDB = findViewById(R.id.btnAddRecordToDB);
        btnAddRecordToDB.setOnClickListener(this);
        btnAddPrivateRecordToDB = findViewById(R.id.btnAddPrivateRecordToDB);
        btnAddPrivateRecordToDB.setOnClickListener(this);
        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(this);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // to be vertical

        myRecords = new ArrayList<>();
        adapter = new MoneyAdapter(this, myRecords);
        recyclerView.setAdapter(adapter);
    }

    public void dataChange() {
        // update the RecyclerView after change in the arraylist
        adapter.notifyDataSetChanged();
    }

    public void userDataChange(MyMoney currentRecord) {
        tvWelcome.setText(currentRecord.getScore() + " points");
    }

    @Override
    public void onClick(View view) {
        if(view == btnAddRecordToDB)
        {
            // save the record in the firebase
            //fb.setRecord(etName.getText().toString(), Integer.parseInt(etRecord.getText().toString()));
            fb.setRecord(Integer.parseInt(etRecord.getText().toString()));
        }

        if(view == btnAddPrivateRecordToDB)
        {
            // save the record in the firebase
            //fb.setRecord(etName.getText().toString(), Integer.parseInt(etRecord.getText().toString()));
            fb.setPrivateRecord(Integer.parseInt(etRecord.getText().toString()));
        }

        if(view == btnLogout)
        {
            FirebaseAuth.getInstance().signOut();
            finish(); // close the activity
        }
    }
}