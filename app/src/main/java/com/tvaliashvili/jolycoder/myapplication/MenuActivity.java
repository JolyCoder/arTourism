package com.tvaliashvili.jolycoder.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setTitle("                        AR Tourism");
    }

    public void onB(View view) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.CoolCompany.ARtourism");
        if (launchIntent != null) {
            startActivity(launchIntent);//null pointer check in case package name was not found
        }
    }

    public void onA(View view) {
        Intent intent = new Intent(MenuActivity.this, discountActivity.class);
        startActivity(intent);
    }

    public void onE(View view) {
        Intent intent = new Intent(MenuActivity.this, toActivity.class);
        startActivity(intent);
    }
}
