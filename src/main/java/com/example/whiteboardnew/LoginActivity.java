package com.example.whiteboardnew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


public class LoginActivity extends AppCompatActivity {

    private EditText loginUsername, loginPassword;
    private Button loginSubmit;

    private void initComponents(){
        loginSubmit = findViewById(R.id.loginSubmit);
        loginUsername = findViewById(R.id.loginUsername);
        loginPassword = findViewById(R.id.loginPassword);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initComponents();
        loginSubmit.setOnClickListener(v -> {
            new LoginClass(
                    loginUsername.getText().toString(),
                    loginPassword.getText().toString()).LogIn(this);

        });


    }
}
