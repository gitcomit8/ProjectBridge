package com.mirza.projectbridge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonClient;
    private Button buttonWorker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonClient = findViewById(R.id.buttonClient);
        buttonWorker = findViewById(R.id.buttonWorker);

        buttonClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Client Login/Registration screen
                Intent intent = new Intent(MainActivity.this, ClientAuthActivity.class);
                startActivity(intent);
            }
        });

        buttonWorker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Worker Login/Registration screen
                Intent intent = new Intent(MainActivity.this, WorkerAuthActivity.class);
                startActivity(intent);
            }
        });
    }
}