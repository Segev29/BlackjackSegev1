package com.example.blackjacksegev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnSave;
    private EditText userName, password1, password2;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btnSave = findViewById(R.id.BtnSignUp);
        btnSave.setOnClickListener(this);
        userName = findViewById(R.id.ETusername1);
        password1 = findViewById(R.id.ETpassword1);
        password2 = findViewById(R.id.ETpasswordVerify);
    }

    @Override
    public void onClick(View v) {
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Users");
        String Gmail = userName.getText().toString();
        String password = password1.getText().toString();
        String passwordCheck = password2.getText().toString();
        if(passwordCheck == password && password.length() > 4)
        {
            HelperClass helperClass = new HelperClass(Gmail,password);
            reference.child(Gmail).setValue(helperClass);
        }
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);


    }
}