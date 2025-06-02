package com.example.forgetpasswordbackend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView welcomeText = findViewById(R.id.welcomeText);
        CardView cardView = findViewById(R.id.cardView_GUI);
        cardView.setVisibility(View.GONE);

        welcomeText.postDelayed(() -> {
            AlphaAnimation fadeOut = new AlphaAnimation(1, 0);
            fadeOut.setDuration(2000);
            fadeOut.setFillAfter(true);
            welcomeText.startAnimation(fadeOut);
            welcomeText.setVisibility(View.GONE);

            cardView.setVisibility(View.VISIBLE);
            AlphaAnimation fadeIn = new AlphaAnimation(0, 1);
            fadeIn.setDuration(2000);
            cardView.startAnimation(fadeIn);
        }, 3000);

        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnRegister = findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(v -> {
            Intent Login = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(Login);
        });

        btnRegister.setOnClickListener(v -> {
            Intent registration = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(registration);
        });
    }
}