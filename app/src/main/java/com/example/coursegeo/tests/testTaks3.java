package com.example.coursegeo.tests;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coursegeo.R;


public class testTaks3 extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener, View.OnDragListener {

    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD, ansE, ansF;
    Button submitBtn;
    TextView dropdrag;
    Dialog customDialog;

    String answers;
    int wrong2 = 0;
    int score = 5;
    int correct = 0;
    int green1 = 0;
    int green2 = 0;
    int totalQuestion = QuestionAnswer.question3.length;
    int currentQuestionIndex = 0;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_taks3);


        LayoutInflater inflater = (LayoutInflater) getLayoutInflater();
        View customView = inflater.inflate(R.layout.helper3, null);

        customDialog = new Dialog(this, R.style.CustomDialog);
        customDialog.setContentView(customView);

        ImageButton btn = (ImageButton)customDialog.findViewById(R.id.btnHelperX3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog.dismiss();
            }
        });

        ImageButton BH2 = (ImageButton) findViewById(R.id.btnHelper3);

        BH2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog.show();
            }
        });


        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        ansE = findViewById(R.id.ans_E);
        ansF = findViewById(R.id.ans_F);
        submitBtn = findViewById(R.id.submit_btn);
        dropdrag = findViewById(R.id.question);


        submitBtn.setOnClickListener(this);
        ansA.setOnTouchListener(this);
        ansB.setOnTouchListener(this);
        ansC.setOnTouchListener(this);
        ansD.setOnTouchListener(this);
        ansE.setOnTouchListener(this);
        ansF.setOnTouchListener(this);
        dropdrag.setOnDragListener(this);

        loadNewQuestion();

    }

    @Override
    public void onClick(View view) {

        Button clickedButton = (Button) view;
        if (clickedButton.getId() == R.id.submit_btn) {
                if (correct == 2) {

                SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
                int wrong1 = save.getInt("Score1",0);

                int result = wrong1 + wrong2;
                SharedPreferences save2 = getSharedPreferences("Save", MODE_PRIVATE);
                int result1 = save2.getInt("Score1",0);

                SharedPreferences.Editor editor = save2.edit();

                editor.putInt("Score1",result);
                editor.commit();

                finishQuiz();
            } else {
                    Toast.makeText(testTaks3.this, "Нужно выбрать правильный ответ!", Toast.LENGTH_SHORT).show();
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
            case R.id.ans_E:
            case R.id.ans_F:


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
                    case "ans_E":
                        break;
                    case "ans_F":
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

                v.invalidate();
                return true;


            case DragEvent.ACTION_DRAG_ENDED:

                if (event.getResult()) {
                    if (currentQuestionIndex == 0) {
                        switch (answers) {
                            case "ans_A":
                                if (ansA.getText().toString().equals(QuestionAnswer.correctAnswers3[0])) {
                                    questionTextView.setText(QuestionAnswer.question3[1]);
                                    Toast.makeText(testTaks3.this, "Правильно!", Toast.LENGTH_SHORT).show();
                                    ansA.setBackgroundColor(Color.GREEN);
                                    correct++;
                                    green1 = 1;
                                    setxtx2();
                                } else if (ansA.getText().toString().equals(QuestionAnswer.correctAnswers3[1])) {
                                    questionTextView.setText(QuestionAnswer.question3[2]);
                                    Toast.makeText(testTaks3.this, "Правильно!", Toast.LENGTH_SHORT).show();
                                    ansA.setBackgroundColor(Color.GREEN);
                                    correct++;
                                    green2 = 1;
                                    setxtx1();
                                } else {
                                    Toast.makeText(testTaks3.this, "Неправильно!", Toast.LENGTH_SHORT).show();
                                    score--;
                                    wrong2++;
                                    ansA.setBackgroundColor(Color.RED);
                                }
                                break;
                            case "ans_B":
                                if (ansB.getText().toString().equals(QuestionAnswer.correctAnswers3[0])) {
                                    questionTextView.setText(QuestionAnswer.question3[1]);
                                    Toast.makeText(testTaks3.this, "Правильно!", Toast.LENGTH_SHORT).show();
                                    ansB.setBackgroundColor(Color.GREEN);
                                    correct++;
                                    green1 = 1;
                                    setxtx2();
                                } else if (ansB.getText().toString().equals(QuestionAnswer.correctAnswers3[1])) {
                                    questionTextView.setText(QuestionAnswer.question3[2]);
                                    Toast.makeText(testTaks3.this, "Правильно!", Toast.LENGTH_SHORT).show();
                                    ansB.setBackgroundColor(Color.GREEN);
                                    correct++;
                                    green2 = 1;
                                    setxtx1();
                                } else {
                                    Toast.makeText(testTaks3.this, "Неправильно!", Toast.LENGTH_SHORT).show();
                                    score--;
                                    wrong2++;
                                    ansB.setBackgroundColor(Color.RED);
                                }
                                break;
                            case "ans_C":
                                if (ansC.getText().toString().equals(QuestionAnswer.correctAnswers3[0])) {
                                    questionTextView.setText(QuestionAnswer.question3[1]);
                                    Toast.makeText(testTaks3.this, "Правильно!", Toast.LENGTH_SHORT).show();
                                    ansC.setBackgroundColor(Color.GREEN);
                                    correct++;
                                    green1 = 1;
                                    setxtx2();
                                } else if (ansC.getText().toString().equals(QuestionAnswer.correctAnswers3[1])) {
                                    questionTextView.setText(QuestionAnswer.question3[2]);
                                    Toast.makeText(testTaks3.this, "Правильно!", Toast.LENGTH_SHORT).show();
                                    ansC.setBackgroundColor(Color.GREEN);
                                    correct++;
                                    green2 = 1;
                                    setxtx1();
                                } else {
                                    Toast.makeText(testTaks3.this, "Неправильно!", Toast.LENGTH_SHORT).show();
                                    score--;
                                    wrong2++;
                                    ansC.setBackgroundColor(Color.RED);
                                }
                                break;
                            case "ans_D":
                                if (ansD.getText().toString().equals(QuestionAnswer.correctAnswers3[0])) {
                                    questionTextView.setText(QuestionAnswer.question3[1]);
                                    Toast.makeText(testTaks3.this, "Правильно!", Toast.LENGTH_SHORT).show();
                                    ansD.setBackgroundColor(Color.GREEN);
                                    correct++;
                                    green1 = 1;
                                    setxtx2();
                                } else if (ansD.getText().toString().equals(QuestionAnswer.correctAnswers3[1])) {
                                    questionTextView.setText(QuestionAnswer.question3[2]);
                                    Toast.makeText(testTaks3.this, "Правильно!", Toast.LENGTH_SHORT).show();
                                    ansD.setBackgroundColor(Color.GREEN);
                                    correct++;
                                    green2 = 1;
                                    setxtx1();
                                } else {
                                    Toast.makeText(testTaks3.this, "Неправильно!", Toast.LENGTH_SHORT).show();
                                    score--;
                                    wrong2++;
                                    ansD.setBackgroundColor(Color.RED);
                                }
                                break;
                            case "ans_E":
                                if (ansE.getText().toString().equals(QuestionAnswer.correctAnswers3[0])) {
                                    questionTextView.setText(QuestionAnswer.question3[1]);
                                    Toast.makeText(testTaks3.this, "Правильно!", Toast.LENGTH_SHORT).show();
                                    ansE.setBackgroundColor(Color.GREEN);
                                    correct++;
                                    green1 = 1;
                                    setxtx2();
                                } else if (ansE.getText().toString().equals(QuestionAnswer.correctAnswers3[1])) {
                                    questionTextView.setText(QuestionAnswer.question3[2]);
                                    Toast.makeText(testTaks3.this, "Правильно!", Toast.LENGTH_SHORT).show();
                                    ansE.setBackgroundColor(Color.GREEN);
                                    correct++;
                                    green2 = 1;
                                    setxtx1();
                                } else {
                                    Toast.makeText(testTaks3.this, "Неправильно!", Toast.LENGTH_SHORT).show();
                                    score--;
                                    wrong2++;
                                    ansE.setBackgroundColor(Color.RED);
                                }
                                break;
                            case "ans_F":
                                if (ansF.getText().toString().equals(QuestionAnswer.correctAnswers3[0])) {
                                    questionTextView.setText(QuestionAnswer.question3[1]);
                                    Toast.makeText(testTaks3.this, "Правильно!", Toast.LENGTH_SHORT).show();
                                    ansF.setBackgroundColor(Color.GREEN);
                                    correct++;
                                    green1 = 1;
                                    setxtx2();
                                } else if (ansF.getText().toString().equals(QuestionAnswer.correctAnswers3[1])) {
                                    questionTextView.setText(QuestionAnswer.question3[2]);
                                    Toast.makeText(testTaks3.this, "Правильно!", Toast.LENGTH_SHORT).show();
                                    ansF.setBackgroundColor(Color.GREEN);
                                    correct++;
                                    green2 = 1;
                                    setxtx1();
                                } else {
                                    Toast.makeText(testTaks3.this, "Неправильно!", Toast.LENGTH_SHORT).show();
                                    score--;
                                    wrong2++;
                                    ansF.setBackgroundColor(Color.RED);
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


    void setxtx1() {
    if(green1 == 1) {
        questionTextView.setText(QuestionAnswer.question3[3]);
        }
    }

    void setxtx2() {
        if(green2 == 1) {
            questionTextView.setText(QuestionAnswer.question3[3]);
        }
    }




    void loadNewQuestion() {


        questionTextView.setText(QuestionAnswer.question3[currentQuestionIndex]);
        ansA.setText(QuestionAnswer.choices3[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer.choices3[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer.choices3[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswer.choices3[currentQuestionIndex][3]);
        ansE.setText(QuestionAnswer.choices3[currentQuestionIndex][4]);
        ansF.setText(QuestionAnswer.choices3[currentQuestionIndex][5]);


    }

    void finishQuiz() {
        Intent resultIntent = new Intent(testTaks3.this, testTasks2.class);
        startActivity(resultIntent);
        finish();
    }
}