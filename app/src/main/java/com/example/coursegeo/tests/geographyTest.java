package com.example.coursegeo.tests;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.coursegeo.R;

public class geographyTest extends AppCompatActivity {

    ImageButton backBtn;
    Button chapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obj_test);

        // Hooks
        backBtn = findViewById(R.id.back_pressed);
        chapter1 = findViewById(R.id.nav_all_categories);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                geographyTest.super.onBackPressed();
            }
        });
    }

    public void click2(View view) {
        Intent intent = new Intent(this, objTestMenu.class);
        startActivity(intent);
    }
}