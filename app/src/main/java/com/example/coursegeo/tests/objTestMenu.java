package com.example.coursegeo.tests;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.coursegeo.R;

public class objTestMenu extends AppCompatActivity {

    ImageButton backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obj_test_menu);

        backBtn = findViewById(R.id.back_pressed);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objTestMenu.super.onBackPressed();
            }
        });

    }

    public void click3(View view) {
        Intent intent = new Intent(objTestMenu.this, testTasks1.class);
        System.out.println(intent);
        startActivity(intent);
    }
}