package com.tvaliashvili.jolycoder.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class toActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to);
    }

    public void send(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Отправлено",
                Toast.LENGTH_SHORT);
        Intent intent = new Intent(toActivity.this, MenuActivity.class);
        startActivity(intent);
    }
}
