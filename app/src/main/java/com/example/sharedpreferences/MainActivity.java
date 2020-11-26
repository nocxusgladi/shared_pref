package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.username);
        etPassword = findViewById(R.id.password);
        TextView btn_signup = (TextView) findViewById(R.id.btnsignup);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Signup.class);
                startActivity(intent);
            }
        });

    }

    public void login(View view) {
        String user = etName.getText().toString();
        String password = etPassword.getText().toString();
        if (TextUtils.isEmpty(user) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Check empty fields", Toast.LENGTH_LONG).show();
        }
        else {
            SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

            String userDetails = preferences.getString(user + password + "data", "Username or Password is Incorrect.");
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("display", userDetails);
            editor.commit();

            Intent intent = new Intent(MainActivity.this, welcome.class);
            startActivity(intent);
        }
    }
}