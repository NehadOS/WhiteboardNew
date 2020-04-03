package com.example.whiteboardnew;

import android.content.Context;
import android.widget.Toast;

class CredentialsValidation {
    Context ctx;

    CredentialsValidation(Context ct){
        this.ctx = ct;
    }

    boolean emailValidation(String email) {
        if (email.contains("@")) {
            if (email.endsWith(".com") || email.endsWith(".uk")) {
                return true;
            } else {
                Toast.makeText(ctx, "Wrong Domain, use .com or .uk", Toast.LENGTH_LONG).show();
                return false;
            }
        } else {
            Toast.makeText(ctx, "Wrong Email Format", Toast.LENGTH_LONG).show();
            return false;
        }
    }




    boolean passwordValidation(String pass, String confirmPass) {
        if (pass.length() >= 6) {
            if (pass.equals(confirmPass)) {
                return true;
            } else {
                Toast.makeText(ctx, "Make Sure Passwords Match", Toast.LENGTH_LONG).show();
                return false;
            }
        } else {
            Toast.makeText(ctx, "Password Must be At least 6 characters Long", Toast.LENGTH_LONG).show();
            return false;
        }
    }

    boolean passwordValidation(String pass) {
        if (pass.length() >= 6) {
            return true;
        } else {
            Toast.makeText(ctx, "Password Must be At least 6 characters Long", Toast.LENGTH_LONG).show();
            return false;
        }
    }
}
