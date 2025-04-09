package com.mirza.projectbridge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class WorkerRegisterActivity extends AppCompatActivity {

    private Button buttonWorkerGoogleRegister;
    private EditText editTextWorkerEmailRegister;
    private EditText editTextWorkerPasswordRegister;
    private Button buttonWorkerEmailPasswordRegister;
    private TextView textViewWorkerLogin;

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_register);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        buttonWorkerGoogleRegister = findViewById(R.id.buttonWorkerGoogleRegister);
        editTextWorkerEmailRegister = findViewById(R.id.editTextWorkerEmailRegister);
        editTextWorkerPasswordRegister = findViewById(R.id.editTextWorkerPasswordRegister);
        buttonWorkerEmailPasswordRegister = findViewById(R.id.buttonWorkerEmailPasswordRegister);
        textViewWorkerLogin = findViewById(R.id.textViewWorkerLogin);

        // TODO: Implement Google Registration functionality for workers
        buttonWorkerGoogleRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement Google Sign-up for workers here
            }
        });

        buttonWorkerEmailPasswordRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextWorkerEmailRegister.getText().toString().trim();
                String password = editTextWorkerPasswordRegister.getText().toString().trim();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(WorkerRegisterActivity.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(WorkerRegisterActivity.this, task -> {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                if (user != null) {
                                    Map<String, Object> worker = new HashMap<>();
                                    worker.put("role", "worker");
                                    // You might want to add other worker-specific fields here

                                    db.collection("users").document(user.getUid())
                                            .set(worker)
                                            .addOnSuccessListener(aVoid -> {
                                                Toast.makeText(WorkerRegisterActivity.this, "Registration successful.",
                                                        Toast.LENGTH_SHORT).show();
                                                // Navigate to the main worker area of the app
                                                // Intent intent = new Intent(WorkerRegisterActivity.this, WorkerMainActivity.class);
                                                // startActivity(intent);
                                                finish(); // Go back to the login screen for now
                                            })
                                            .addOnFailureListener(e -> {
                                                Toast.makeText(WorkerRegisterActivity.this, "Error storing user data: " + e.getMessage(),
                                                        Toast.LENGTH_SHORT).show();
                                                user.delete();
                                            });
                                }
                            } else {
                                Toast.makeText(WorkerRegisterActivity.this, "Registration failed: " + task.getException().getMessage(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        textViewWorkerLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to Worker Login screen
                finish(); // Simply finish the current activity to go back
            }
        });
    }
}