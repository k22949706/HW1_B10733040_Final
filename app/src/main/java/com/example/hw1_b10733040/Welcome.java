package com.example.hw1_b10733040;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    private Button toBlueTooth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        toBlueTooth = (Button) findViewById(R.id.button_BlueTooth);

        toBlueTooth.setOnClickListener(v -> {
            Context context = Welcome.this;
            Intent startActivityIntent = new Intent(context, MainActivity.class);
            startActivity(startActivityIntent);
        });
    }
}