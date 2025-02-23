package com.example.blackjacksegev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnDone;
    private Button btnSignUp;
    private EditText userName, password1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        btnDone = findViewById(R.id.btnDone);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(this);
        btnDone.setOnClickListener(this);
        userName = findViewById(R.id.ETusername);
        password1 = findViewById(R.id.ETpassword);
    }
    public boolean validateGmail(){
        String val = userName.getText().toString();
        if(val.isEmpty())
        {
            userName.setError("cant be empty");
            return false;
        }
        else
        {
            userName.setError(null);
            return true;
        }
    }
    public boolean validatePassword(){
        String val = password1.getText().toString();
        if(val.isEmpty())
        {
            password1.setError("cant be empty");
            return false;
        }
        else
        {
            password1.setError(null);
            return true;
        }
    }
    public void CheckUser()
    {
        String userUsername = userName.getText().toString().trim();
        String userPassword = password1.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(userUsername);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    userName.setError(null);
                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);
                    if(!Objects.equals(passwordFromDB,userPassword))
                    {
                        userName.setError(null);
                    }
                    else
                    {
                        password1.setError("Invalid");
                        password1.requestFocus();
                    }

                }
                else
                {
                    userName.setError("user does not exist");
                    userName.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onClick(View v) {

        if(v == btnSignUp)
        {
            Intent i = new Intent(SignInActivity.this, SignUpActivity.class);
            startActivity(i);
        }
        if(v == btnDone)
        {
            if(!validateGmail() | !validatePassword())
            {

            }
            else
            {
                CheckUser();
            }
        }
    }
}