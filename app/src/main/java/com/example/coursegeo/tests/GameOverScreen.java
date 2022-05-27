package com.example.coursegeo.tests;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.coursegeo.R;
import com.example.coursegeo.ui.home.HomeFragment;

public class GameOverScreen extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover_screen);

        final AppCompatButton GoToMainMenu = findViewById(R.id.GoToMainMenuBTN);

        final TextView wrongAnswers = findViewById(R.id.txtWrongAnsContent);
        final TextView scoreResults = findViewById(R.id.txtTotalScore);


        final int getWrongAnswers = getIntent().getIntExtra("wrong", 0);
        final int getScoreResults = getIntent().getIntExtra("score", 0);

        wrongAnswers.setText(String.valueOf(getWrongAnswers));
        scoreResults.setText((String.valueOf(getScoreResults)));




        GoToMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GameOverScreen.this, objTestMenu.class));
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(GameOverScreen.this, testTaks3.class));
        finish();
    }
}
