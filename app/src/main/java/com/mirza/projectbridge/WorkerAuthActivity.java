package com.mirza.projectbridge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WorkerAuthActivity extends AppCompatActivity {

    private Button buttonWorkerGoogleLogin;
    private EditText editTextWorkerEmailLogin;
    private EditText editTextWorkerPasswordLogin;
    private Button buttonWorkerEmailPasswordLogin;
    private TextView textViewWorkerRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_auth);

        buttonWorkerGoogleLogin = findViewById(R.id.buttonWorkerGoogleLogin);
        editTextWorkerEmailLogin = findViewById(R.id.editTextWorkerEmailLogin);
        editTextWorkerPasswordLogin = findViewById(R.id.editTextWorkerPasswordLogin);
        buttonWorkerEmailPasswordLogin = findViewById(R.id.buttonWorkerEmailPasswordLogin);
        textViewWorkerRegister = findViewById(R.id.textViewWorkerRegister);

        // TODO: Implement Google Login functionality for workers
        buttonWorkerGoogleLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement Google Sign-in for workers here
            }
        });

        // TODO: Implement Email/Password Login functionality for workers
        buttonWorkerEmailPasswordLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextWorkerEmailLogin.getText().toString().trim();
                String password = editTextWorkerPasswordLogin.getText().toString().trim();
                // Implement Firebase Email/Password login for workers here
            }
        });

        textViewWorkerRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Worker Registration screen
                Intent intent = new Intent(WorkerAuthActivity.this, WorkerRegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}