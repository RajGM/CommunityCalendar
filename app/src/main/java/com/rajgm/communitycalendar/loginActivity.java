package com.rajgm.communitycalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class loginActivity extends AppCompatActivity {

    Button loginButton;
    EditText emailField;
    EditText passwordField;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.loginButton);
        emailField = findViewById(R.id.emailForm);
        passwordField = findViewById(R.id.passwordForm);
        // Initialize Firebase Auth
        //mAuth = FirebaseAuth.getInstance();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Login Details Sent",Toast.LENGTH_SHORT).show();

                /*
                mAuth.signInWithEmailAndPassword(emailField.getText().toString(),passwordField.getText().toString()).addOnCompleteListener(task -> {

                    if(task.isSuccessful()){
                        Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT).show();
                    }

                });
                */
            }
        });




    }


}