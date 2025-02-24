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
        setContentView(R.layout.activity_main);

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
        Intent intent = new Intent(SignInActivity.this, LeaderBoard.class);
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
        Intent intent = new Intent(SignInActivity.this, LeaderBoard.class);
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
        Intent intent = new Intent(SignInActivity.this, LeaderBoard.class);
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

























/*extends AppCompatActivity implements View.OnClickListener {
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
    }*/



/*package com.example.blackjacksegev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;*/

/*public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
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
}*/