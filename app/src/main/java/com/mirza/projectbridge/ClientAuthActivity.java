package com.mirza.projectbridge; // Replace with your actual package name

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ClientAuthActivity extends AppCompatActivity {

    private Button buttonClientGoogleLogin;
    private EditText editTextClientEmailLogin;
    private EditText editTextClientPasswordLogin;
    private Button buttonClientEmailPasswordLogin;
    private TextView textViewClientRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_auth);

        buttonClientGoogleLogin = findViewById(R.id.buttonClientGoogleLogin);
        editTextClientEmailLogin = findViewById(R.id.editTextClientEmailLogin);
        editTextClientPasswordLogin = findViewById(R.id.editTextClientPasswordLogin);
        buttonClientEmailPasswordLogin = findViewById(R.id.buttonClientEmailPasswordLogin);
        textViewClientRegister = findViewById(R.id.textViewClientRegister);

        // TODO: Implement Google Login functionality
        buttonClientGoogleLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement Google Sign-in here
            }
        });

        // TODO: Implement Email/Password Login functionality
        buttonClientEmailPasswordLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextClientEmailLogin.getText().toString().trim();
                String password = editTextClientPasswordLogin.getText().toString().trim();
                // Implement Firebase Email/Password login here
            }
        });

        textViewClientRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Client Registration screen
                Intent intent = new Intent(ClientAuthActivity.this, ClientRegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}