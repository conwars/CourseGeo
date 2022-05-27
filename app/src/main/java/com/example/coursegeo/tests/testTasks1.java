package com.example.coursegeo.tests;

import android.annotation.SuppressLint;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import com.example.coursegeo.R;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class testTasks1 extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener, View.OnDragListener {

        TextView totalQuestionsTextView;
        TextView questionTextView;
        Button ansA, ansB, ansC, ansD;
        Button submitBtn;
        TextView dropdrag;
        Dialog customDialog;
        Dialog customDialog2;
        ScrollView myScroll;

        String answers;
        int score = 5;
        int wrong = 0;
        int correct = 0;
        int totalQuestion = QuestionAnswer.question.length;
        int currentQuestionIndex = 0;

        @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_tasks1);

        ImageButton backBtn2 = (ImageButton) findViewById(R.id.back_pressed2);
        backBtn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        testTasks1.super.onBackPressed();
                }
        });

        LayoutInflater inflater = (LayoutInflater) getLayoutInflater();
        View customView = inflater.inflate(R.layout.mission, null);
        // Build the dialog
        customDialog = new Dialog(this, R.style.CustomDialog);
        customDialog.setContentView(customView);

        Button btncontinue = (Button)customDialog.findViewById(R.id.continueuni);

        btncontinue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        myScroll = (ScrollView)customDialog.findViewById(R.id.scroll1);
                        myScroll.scrollTo(0, 0);
                        customDialog.dismiss();
                }
        });
        customDialog.show();

        LayoutInflater inflater2 = (LayoutInflater) getLayoutInflater();
        View customView2 = inflater2.inflate(R.layout.helper, null);

        customDialog2 = new Dialog(this, R.style.CustomDialog2);
        customDialog2.setContentView(customView2);

        ImageButton BH = (ImageButton)customDialog2.findViewById(R.id.btnHelperX);

        BH.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        customDialog2.dismiss();
                }
        });


        ImageButton BH2 = (ImageButton) findViewById(R.id.btnHelper);

        BH2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        customDialog2.show();
                }
        });

        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);
        dropdrag = findViewById(R.id.question);



        submitBtn.setOnClickListener(this);
        ansA.setOnTouchListener(this);
        ansB.setOnTouchListener(this);
        ansC.setOnTouchListener(this);
        ansD.setOnTouchListener(this);
        dropdrag.setOnDragListener(this);


        loadNewQuestion();

        }
        @Override
        public void onClick(View view) {

        Button clickedButton = (Button) view;
        if (clickedButton.getId() == R.id.submit_btn) {
                if (correct == 1) {
//                currentQuestionIndex = currentQuestionIndex + 2;
                        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
                        int wrong1 = save.getInt("Score1", 0);
                        SharedPreferences.Editor editor = save.edit();
                        editor.putInt("Score1", wrong);
                        editor.commit();
                        finishQuiz();
                        System.out.println(correct);
                } else {
                        Toast.makeText(testTasks1.this, "Нужно выбрать правильный ответ!", Toast.LENGTH_SHORT).show();
                }
        }


 }



@SuppressLint({"ClickableViewAccessibility", "NonConstantResourceId"})
@Override
public boolean onTouch(View v, MotionEvent event) {


        View.DragShadowBuilder mShadow = new View.DragShadowBuilder(v);
        ClipData.Item item = new ClipData.Item(v.getTag().toString());
        String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
        ClipData data = new ClipData(v.getTag().toString(), mimeTypes, item);


        switch (v.getId()) {
           case R.id.ans_A:
           case R.id.ans_B:
           case R.id.ans_C:
           case R.id.ans_D:


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                v.startDragAndDrop(data, mShadow, null, 0);
        } else {
          v.startDrag(data, mShadow, null, 0);
        }

           break;
        }
          return false;
        }

@Override
public boolean onDrag(View v, DragEvent event) {
        switch (event.getAction()) {
        case DragEvent.ACTION_DRAG_STARTED:

          v.invalidate();
        return true;

        case DragEvent.ACTION_DRAG_ENTERED:

          String clipData = event.getClipDescription().getLabel().toString();

        switch (clipData) {
                case "ans_A":
                  break;
                case "ans_B":
                  break;
                case "ans_C":
                  break;
                case "ans_D":
                  break;
        }
        v.invalidate();
        return true;

        case DragEvent.ACTION_DRAG_LOCATION:

        return true;

        case DragEvent.ACTION_DRAG_EXITED:

        case DragEvent.ACTION_DROP:

        clipData = event.getClipDescription().getLabel().toString();

        answers = clipData;
                System.out.println(answers);

        v.invalidate();
        return true;


        case DragEvent.ACTION_DRAG_ENDED:

        if (event.getResult()) {
                if (currentQuestionIndex == 0) {
        switch (answers) {
        case "ans_A":
                if (ansA.getText().toString().equals(QuestionAnswer.correctAnswers[0])) {
                        ansA.setBackgroundColor(Color.GREEN);
                        Toast.makeText(testTasks1.this, "Правильно!", Toast.LENGTH_SHORT).show();
                        correct++;
                        currentQuestionIndex++;
                        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
                        currentQuestionIndex--;
                } else {
                        ansA.setBackgroundColor(Color.RED);
                        Toast.makeText(testTasks1.this, "Неправильно!", Toast.LENGTH_SHORT).show();
                        score--;
                        wrong++;
                }
                break;
        case "ans_B":
                if (ansB.getText().toString().equals(QuestionAnswer.correctAnswers[0])) {
                        ansB.setBackgroundColor(Color.GREEN);
                        Toast.makeText(testTasks1.this, "Правильно!", Toast.LENGTH_SHORT).show();
                        correct++;
                        currentQuestionIndex++;
                        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
                        currentQuestionIndex--;
                } else {
                        ansB.setBackgroundColor(Color.RED);
                        Toast.makeText(testTasks1.this, "Неправильно!", Toast.LENGTH_SHORT).show();
                        score--;
                        wrong++;
                }
                break;
        case "ans_C":
                if (ansC.getText().toString().equals(QuestionAnswer.correctAnswers[0])) {
                        ansC.setBackgroundColor(Color.GREEN);
                        Toast.makeText(testTasks1.this, "Правильно!", Toast.LENGTH_SHORT).show();
                        correct++;
                        currentQuestionIndex++;
                        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
                        currentQuestionIndex--;
                } else {
                        ansC.setBackgroundColor(Color.RED);
                        Toast.makeText(testTasks1.this, "Неправильно!", Toast.LENGTH_SHORT).show();
                        score--;
                        wrong++;
                }
                break;
        case "ans_D":
                if (ansD.getText().toString().equals(QuestionAnswer.correctAnswers[0])) {
                        ansD.setBackgroundColor(Color.GREEN);
                        Toast.makeText(testTasks1.this, "Правильно!", Toast.LENGTH_SHORT).show();
                        correct++;
                        currentQuestionIndex++;
                        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
                        currentQuestionIndex--;
                } else {
                        ansD.setBackgroundColor(Color.RED);
                        Toast.makeText(testTasks1.this, "Неправильно!", Toast.LENGTH_SHORT).show();
                        score--;
                        wrong++;
                }
                break;
        }

        }

         }
        return true;
default:
        return false;
        }
        }


        void loadNewQuestion() {

        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
        ansA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswer.choices[currentQuestionIndex][3]);

        }

        void finishQuiz() {

        Intent resultIntent = new Intent(testTasks1.this, testTaks3.class);
        startActivity(resultIntent);
        finish();
        }
}