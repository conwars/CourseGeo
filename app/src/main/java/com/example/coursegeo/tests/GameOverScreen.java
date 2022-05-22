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

        final AppCompatButton startNewQuiz = findViewById(R.id.startNewQuizBTN);
        final AppCompatButton GoToMainMenu = findViewById(R.id.GoToMainMenuBTN);
//        final TextView correctAnswers = findViewById(R.id.txtRightAnsContent);
        final TextView wrongAnswers = findViewById(R.id.txtWrongAnsContent);
        final TextView scoreResults = findViewById(R.id.txtTotalScore);

//        final int getCorrectAnswers = getIntent().getIntExtra("correct", 0);
        final int getWrongAnswers = getIntent().getIntExtra("wrong", 0);
        final int getScoreResults = getIntent().getIntExtra("score", 0);

//        correctAnswers.setText(String.valueOf(getCorrectAnswers));
        wrongAnswers.setText(String.valueOf(getWrongAnswers));
        scoreResults.setText((String.valueOf(getScoreResults)));



        startNewQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GameOverScreen.this, testTasks1.class));
                finish();
            }
        });

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
