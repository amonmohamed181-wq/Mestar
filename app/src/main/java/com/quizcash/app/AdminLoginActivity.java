package com.quizcash.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdminLoginActivity extends AppCompatActivity {

    private EditText usernameField, passwordField;
    private Button loginBtn;

    private final String ADMIN_USER = "admin";
    private final String ADMIN_PASS = "asdfghjkl";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        usernameField = findViewById(R.id.username);
        passwordField = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = usernameField.getText().toString().trim();
                String pass = passwordField.getText().toString().trim();

                if (user.equals(ADMIN_USER) && pass.equals(ADMIN_PASS)) {
                    Intent intent = new Intent(AdminLoginActivity.this, AdminActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(AdminLoginActivity.this, "خطأ في بيانات الدخول", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
