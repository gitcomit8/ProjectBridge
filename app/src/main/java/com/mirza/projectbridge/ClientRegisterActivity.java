package com.mirza.projectbridge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class ClientRegisterActivity extends AppCompatActivity {

    private Button buttonClientGoogleRegister;
    private EditText editTextClientEmailRegister;
    private EditText editTextClientPasswordRegister;
    private Button buttonClientEmailPasswordRegister;
    private TextView textViewClientLogin;

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_register);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        buttonClientGoogleRegister = findViewById(R.id.buttonClientGoogleRegister);
        editTextClientEmailRegister = findViewById(R.id.editTextClientEmailRegister);
        editTextClientPasswordRegister = findViewById(R.id.editTextClientPasswordRegister);
        buttonClientEmailPasswordRegister = findViewById(R.id.buttonClientEmailPasswordRegister);
        textViewClientLogin = findViewById(R.id.textViewClientLogin);

        // TODO: Implement Google Registration functionality
        buttonClientGoogleRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement Google Sign-up here
            }
        });

        buttonClientEmailPasswordRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextClientEmailRegister.getText().toString().trim();
                String password = editTextClientPasswordRegister.getText().toString().trim();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(ClientRegisterActivity.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Create user with email and password
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(ClientRegisterActivity.this, task -> {
                            if (task.isSuccessful()) {
                                // Registration success
                                FirebaseUser user = mAuth.getCurrentUser();
                                if (user != null) {
                                    // Store additional user info in Firestore
                                    Map<String, Object> client = new HashMap<>();
                                    client.put("role", "client");
                                    // You might want to add other fields like 'collegeId' here

                                    db.collection("users").document(user.getUid())
                                            .set(client)
                                            .addOnSuccessListener(aVoid -> {
                                                Toast.makeText(ClientRegisterActivity.this, "Registration successful.",
                                                        Toast.LENGTH_SHORT).show();
                                                // Navigate to the main client area of the app
                                                // Intent intent = new Intent(ClientRegisterActivity.this, ClientMainActivity.class);
                                                // startActivity(intent);
                                                finish(); // Go back to the login screen for now
                                            })
                                            .addOnFailureListener(e -> {
                                                Toast.makeText(ClientRegisterActivity.this, "Error storing user data: " + e.getMessage(),
                                                        Toast.LENGTH_SHORT).show();
                                                // Optionally, you might want to delete the user if data storage fails
                                                user.delete();
                                            });
                                }
                            } else {
                                // If registration fails, display a message to the user.
                                Toast.makeText(ClientRegisterActivity.this, "Registration failed: " + task.getException().getMessage(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        textViewClientLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to Client Login screen
                finish(); // Simply finish the current activity to go back
            }
        });
    }
}