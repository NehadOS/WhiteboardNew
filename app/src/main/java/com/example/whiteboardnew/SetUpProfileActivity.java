package com.example.whiteboardnew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SetUpProfileActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    boolean CreationStatus;

    private EditText newName, newEmail, newPassword, confirmNewPassword;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up_profile);
        init();
        mAuth = FirebaseAuth.getInstance();
        button.setOnClickListener(v -> {
            String newEmailString = newEmail.getText().toString().isEmpty() ? "" : newEmail.getText().toString();
            String newPasswordString = newPassword.getText().toString().isEmpty() ? "" : newPassword.getText().toString();
            String confirmNewPasswordString =  confirmNewPassword.getText().toString().isEmpty() ? "" : confirmNewPassword.getText().toString();
            if (new CredentialsValidation(this).emailValidation(newEmailString)){
                if (new CredentialsValidation(this).passwordValidation(newPasswordString,confirmNewPasswordString)) {
                    mAuth.createUserWithEmailAndPassword(newEmail.getText().toString(), newPassword.getText().toString())
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(SetUpProfileActivity.this, "New Profile creation successful.",
                                                Toast.LENGTH_SHORT).show();
                                        finish();
                                    } else {
                                        Toast.makeText(SetUpProfileActivity.this, "New Profile creation failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }
    private void init() {
        newName = findViewById(R.id.newUsername);
        newEmail = findViewById(R.id.newEmail);
        newPassword = findViewById(R.id.newPassword);
        confirmNewPassword = findViewById(R.id.confirmNewPassword);
        button = findViewById(R.id.registerNewUser);
    }

}
