package com.rajgm.communitycalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Switch logInSignUpSwitch;
    Button logInSignUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logInSignUpSwitch = findViewById(R.id.logInSignUpSwitch);
        logInSignUpButton = findViewById(R.id.logInSignUpButton);

        logInSignUpButton.setText("SignUp");

        logInSignUpSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    logInSignUpButton.setText("LogIn");
                }else{
                    logInSignUpButton.setText("SignUp");
                }

            }
        });

        logInSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChecked = logInSignUpSwitch.isChecked();

                if(isChecked){
                    Toast.makeText(getApplicationContext(),"Launch Login:"+isChecked,Toast.LENGTH_SHORT).show();
                    Intent loginIntent = new Intent(MainActivity.this,loginActivity.class);
                    startActivity(loginIntent);
                }else{
                    Toast.makeText(getApplicationContext(),"Launch Signup:"+isChecked,Toast.LENGTH_SHORT).show();
                }


            }
        });





    }
}