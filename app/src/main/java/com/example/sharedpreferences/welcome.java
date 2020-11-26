package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String display = preferences.getString("display", "");

        TextView displayInfo = (TextView)findViewById(R.id.welcome_msg);
        displayInfo.setText(display);
    }
}