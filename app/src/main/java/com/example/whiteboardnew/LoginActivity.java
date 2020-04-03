package com.example.whiteboardnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText loginUsername, loginPassword;
    private Button loginSubmit;
    private TextView notAUserText;

    private void initComponents() {
        loginSubmit = findViewById(R.id.loginSubmit);
        loginUsername = findViewById(R.id.loginUsername);
        loginPassword = findViewById(R.id.loginPassword);
        notAUserText = findViewById(R.id.notAUserText);
    }

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        initComponents();
        loginSubmit.setOnClickListener(v -> {
            String username = loginUsername.getText().toString().isEmpty() ? "" : loginUsername.getText().toString();
            String password = loginPassword.getText().toString().isEmpty() ? "" : loginPassword.getText().toString();
            if (new CredentialsValidation(this).emailValidation(username)) {
                if (new CredentialsValidation(this).passwordValidation(password)) {
                    mAuth.signInWithEmailAndPassword(username, password)
                            .addOnCompleteListener(LoginActivity.this, task -> {
                                if (task.isSuccessful()) {
                                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                                    startMainMenu(username.substring(0, username.indexOf("@")));
                                } else {
                                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_LONG).show();
                                }
                            });
                }
            }

        });

        notAUserText.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, SetUpProfileActivity.class);
            startActivity(intent);
        });
    }

    public void startMainMenu(String studentID) {
        Intent intent = new Intent(LoginActivity.this, Main_menu.class);
        intent.putExtra("studnetID", studentID);
        startActivity(intent);
    }
}
