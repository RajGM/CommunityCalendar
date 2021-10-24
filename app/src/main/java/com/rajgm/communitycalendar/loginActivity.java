package com.rajgm.communitycalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginActivity extends AppCompatActivity {

    Button loginButton;
    EditText emailField;
    EditText passwordField;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        if(mAuth.getCurrentUser()!=null){
            Intent loggedInIntent = new Intent(loginActivity.this,eventListActivity.class);
            startActivity(loggedInIntent);
        }

        loginButton = findViewById(R.id.loginButton);
        emailField = findViewById(R.id.emailForm);
        passwordField = findViewById(R.id.passwordForm);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginButton.setEnabled(false);

                mAuth.signInWithEmailAndPassword(emailField.getText().toString(),passwordField.getText().toString()).addOnCompleteListener(task -> {

                    loginButton.setEnabled(true);

                    if(task.isSuccessful()){
                        Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                        Log.e("LoginActivity","SignIn done",task.getException());
                        Intent loggedInIntent = new Intent(loginActivity.this,eventListActivity.class);
                        startActivity(loggedInIntent);
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(),"Login Failed, check email and password",Toast.LENGTH_SHORT).show();
                    }

                });

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"Activity Destroyed",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mAuth.getCurrentUser()!=null){
            Intent loggedInIntent = new Intent(loginActivity.this,eventListActivity.class);
            startActivity(loggedInIntent);
        }
    }
}