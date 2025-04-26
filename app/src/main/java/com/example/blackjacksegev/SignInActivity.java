package com.example.blackjacksegev;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

private FirebaseAuth mAuth;
        Button btnRegister, btnLogin;
        EditText etEmailAddress, etNumberPassword;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        etEmailAddress = findViewById(R.id.etEmailAddress);
        etNumberPassword = findViewById(R.id.etNumberPassword);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        }

@Override
protected void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
        reload();
        }
        }

private void reload() {
        Intent intent = new Intent(SignInActivity.this, MainActivity.class);
        startActivity(intent);
        }

@Override
public void onClick(View view) {
        if(view == btnRegister)
        {
        String email = etEmailAddress.getText().toString();
        String password = etNumberPassword.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
@Override
public void onComplete(@NonNull Task<AuthResult> task) {
        if (task.isSuccessful()) {
        // Sign in success, update UI with the signed-in user's information
        Intent intent = new Intent(SignInActivity.this, MainActivity.class);
        startActivity(intent);

        } else {
        // If sign in fails, display a message to the user.
        Toast.makeText(SignInActivity.this, "fail register", Toast.LENGTH_SHORT).show();
        }
        }
        });
        }

        if(view == btnLogin)
        {
        String email = etEmailAddress.getText().toString();
        String password = etNumberPassword.getText().toString();
        mAuth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
@Override
public void onComplete(@NonNull Task<AuthResult> task) {
        if (task.isSuccessful()) {
        // Sign in success, update UI with the signed-in user's information
        Intent intent = new Intent(SignInActivity.this, MainActivity.class);
        startActivity(intent);
        } else {
        // If sign in fails, display a message to the user.
        Toast.makeText(SignInActivity.this, "login failed.", Toast.LENGTH_SHORT).show();

        }
        }
        });
        }
        }
}


