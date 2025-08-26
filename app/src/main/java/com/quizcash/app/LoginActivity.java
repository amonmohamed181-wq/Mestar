package com.quizcash.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText phone = findViewById(R.id.phoneInput);
        Button login = findViewById(R.id.loginButton);

        login.setOnClickListener(v -> {
            Intent i = new Intent(LoginActivity.this, WalletActivity.class);
            startActivity(i);
        });
    }
}
