package com.satish.lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI Elements
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        btnLogin = findViewById(R.id.btnLogin);

        // Button Click Listener
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateUser();
            }
        });
    }

    private void validateUser() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        if ( email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this,
                    "Email and Password are required", Toast.LENGTH_SHORT).show();
            return;
        }
        // Validate Email
        if (!isValidEmail(email)) {
            Toast.makeText(this,
                    "Invalid Email Address", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validate Password (Minimum 6 characters)
        if (password.length() < 6) {
            Toast.makeText(this,
                    "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
            return;
        }

        // If everything is correct
        Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();
    }

    // Email Validation Function
    private boolean isValidEmail(String email) {
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.compile(emailPattern).matcher(email).matches();
    }
}
