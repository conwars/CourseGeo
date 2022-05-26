package com.example.coursegeo.tests;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coursegeo.R;

import java.util.concurrent.TimeUnit;

public class testTasks2 extends AppCompatActivity implements View.OnClickListener {


    TextView totalQuestionsTextView2;
    TextView questionTextView2;
    Button ansA2, ansB2, ansC2, ansD2, ansE2, ansF2, ansG2, ansH2, ansI2, ansJ2, ansK2, ansL2;
    Button submitBtn2;
    Dialog customDialog;


    boolean check = false;
    boolean check1 = false;
    boolean check2 = false;
    boolean check3 = false;
    boolean check4 = false;
    boolean check5 = false;
    int passtatus = 0;
    int score = 5;
    int wrong = 0;
    int correct = 0;
    int allscore = 0;
    int clickA = 0;
    int greenA = 0;
    int greenB = 0;
    int greenC = 0;
    int greenD = 0;
    int greenE = 0;
    int greenF = 0;
    int totalQuestion = QuestionAnswer.question2.length;
    int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_tasks2);


        totalQuestionsTextView2 = findViewById(R.id.total_question2);
        questionTextView2 = findViewById(R.id.question2);
        ansA2 = findViewById(R.id.ans_A2);
        ansB2 = findViewById(R.id.ans_B2);
        ansC2 = findViewById(R.id.ans_C2);
        ansD2 = findViewById(R.id.ans_D2);
        ansE2 = findViewById(R.id.ans_E2);
        ansF2 = findViewById(R.id.ans_F2);
        ansG2 = findViewById(R.id.ans_G2);
        ansH2 = findViewById(R.id.ans_H2);
        ansI2 = findViewById(R.id.ans_I2);
        ansJ2 = findViewById(R.id.ans_J2);
        ansK2 = findViewById(R.id.ans_K2);
        ansL2 = findViewById(R.id.ans_L2);
        submitBtn2 = findViewById(R.id.submit_btn2);


        submitBtn2.setOnClickListener(this);
        ansA2.setOnClickListener(this);
        ansB2.setOnClickListener(this);
        ansC2.setOnClickListener(this);
        ansD2.setOnClickListener(this);
        ansE2.setOnClickListener(this);
        ansF2.setOnClickListener(this);
        ansG2.setOnClickListener(this);
        ansH2.setOnClickListener(this);
        ansI2.setOnClickListener(this);
        ansJ2.setOnClickListener(this);
        ansK2.setOnClickListener(this);
        ansL2.setOnClickListener(this);

        LayoutInflater inflater = (LayoutInflater) getLayoutInflater();
        View customView = inflater.inflate(R.layout.helper2, null);

        customDialog = new Dialog(this, R.style.CustomDialog);
        customDialog.setContentView(customView);

        ImageButton btn = (ImageButton)customDialog.findViewById(R.id.btnHelperX2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog.dismiss();
            }
        });

        ImageButton BH2 = (ImageButton) findViewById(R.id.btnHelper2);

        BH2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog.show();
            }
        });



        Button ansA = (Button) findViewById(R.id.ans_A2);
        ansA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (check == true && greenA == 0) {
                    ansA2.setBackgroundColor(Color.WHITE);
                    ansG2.setBackgroundColor(Color.WHITE);
                    ansH2.setBackgroundColor(Color.WHITE);
                    ansJ2.setBackgroundColor(Color.WHITE);
                    ansK2.setBackgroundColor(Color.WHITE);
                    ansL2.setBackgroundColor(Color.WHITE);
                }
                clickA = 1;

                        if(greenA == 0) {

                            Button ansI = (Button) findViewById(R.id.ans_I2);
                            ansI.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (greenA == 0) {
                                        ansA.setBackgroundColor(Color.GREEN);
                                        ansI.setBackgroundColor(Color.GREEN);
                                        ansB2.setBackgroundColor(Color.WHITE);
                                        correct++;
                                        greenA = 1;
                                        clickA = 0;
                                    }
                                }
                            });
                            Button ansH = (Button) findViewById(R.id.ans_H2);
                            ansH.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (greenA == 0) {
                                        ansA.setBackgroundColor(Color.RED);
                                        ansH.setBackgroundColor(Color.RED);
                                        wrong++;
                                        clickA = 0;
                                        check = true;
                                    }
                                }
                            });
                            Button ansG = (Button) findViewById(R.id.ans_G2);
                            ansG.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (greenA == 0) {
                                        ansA.setBackgroundColor(Color.RED);
                                        ansG.setBackgroundColor(Color.RED);
                                        wrong++;
                                        clickA = 0;
                                        check = true;
                                    }
                                }
                            });
                            Button ansJ = (Button) findViewById(R.id.ans_J2);
                            ansJ.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (greenA == 0) {
                                        ansA.setBackgroundColor(Color.RED);
                                        ansJ.setBackgroundColor(Color.RED);
                                        wrong++;
                                        clickA = 0;
                                        check = true;
                                    }
                                }
                            });
                            Button ansK = (Button) findViewById(R.id.ans_K2);
                            ansK.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (greenA == 0) {
                                        ansA.setBackgroundColor(Color.RED);
                                        ansK.setBackgroundColor(Color.RED);
                                        wrong++;
                                        clickA = 0;
                                        check = true;
                                    }
                                }
                            });
                            Button ansL = (Button) findViewById(R.id.ans_L2);
                            ansL.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (greenA == 0) {
                                        ansA.setBackgroundColor(Color.RED);
                                        ansL.setBackgroundColor(Color.RED);
                                        wrong++;
                                        clickA = 0;
                                        check = true;
                                    }
                                }
                            });
                        }
                }
        });

        Button ansB = (Button) findViewById(R.id.ans_B2);
        ansB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check1 == true && greenB == 0 && greenA == 1) {
                    ansB2.setBackgroundColor(Color.WHITE);
                    ansG2.setBackgroundColor(Color.WHITE);
                    ansJ2.setBackgroundColor(Color.WHITE);
                    ansK2.setBackgroundColor(Color.WHITE);
                    ansH2.setBackgroundColor(Color.WHITE);
                }

                clickA = 1;
                if(greenB == 0 && greenA == 1) {


                    Button ansL = (Button) findViewById(R.id.ans_L2);
                    ansL.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (greenB == 0) {
                                ansB.setBackgroundColor(Color.GREEN);
                                ansL.setBackgroundColor(Color.GREEN);
                                ansC2.setBackgroundColor(Color.WHITE);
                                correct++;
                                greenB = 1;
                                clickA = 0;
                            }
                        }
                    });
                    Button ansG = (Button) findViewById(R.id.ans_G2);
                    ansG.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (greenB == 0) {
                                ansB.setBackgroundColor(Color.RED);
                                ansG.setBackgroundColor(Color.RED);
                                wrong++;
                                clickA = 0;
                                check1 = true;
                            }
                        }
                    });
                    Button ansJ = (Button) findViewById(R.id.ans_J2);
                    ansJ.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (greenB == 0) {
                                ansB.setBackgroundColor(Color.RED);
                                ansJ.setBackgroundColor(Color.RED);
                                wrong++;
                                clickA = 0;
                                check1 = true;
                            }
                        }
                    });
                    Button ansK = (Button) findViewById(R.id.ans_K2);
                    ansK.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (greenB == 0) {
                                ansB.setBackgroundColor(Color.RED);
                                ansK.setBackgroundColor(Color.RED);
                                wrong++;
                                clickA = 0;
                                check1 = true;
                            }
                        }
                    });
                    Button ansH = (Button) findViewById(R.id.ans_H2);
                    ansH.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (greenB == 0) {
                                ansB.setBackgroundColor(Color.RED);
                                ansH.setBackgroundColor(Color.RED);
                                wrong++;
                                clickA = 0;
                                check1 = true;
                            }
                        }
                    });
                }
            }
        });

        Button ansC = (Button) findViewById(R.id.ans_C2);
        ansC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check2 == true && greenC == 0 && greenB == 1) {
                    ansC2.setBackgroundColor(Color.WHITE);
                    ansG2.setBackgroundColor(Color.WHITE);
                    ansK2.setBackgroundColor(Color.WHITE);
                    ansH2.setBackgroundColor(Color.WHITE);
                }

                clickA = 1;
                if(greenC == 0 && greenB == 1) {


                    Button ansJ = (Button) findViewById(R.id.ans_J2);
                    ansJ.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (greenC == 0) {
                                ansC.setBackgroundColor(Color.GREEN);
                                ansJ.setBackgroundColor(Color.GREEN);
                                ansD2.setBackgroundColor(Color.WHITE);
                                correct++;
                                greenC = 1;
                                clickA = 0;
                            }
                        }
                    });

                    Button ansG = (Button) findViewById(R.id.ans_G2);
                    ansG.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (greenC == 0) {
                                ansC.setBackgroundColor(Color.RED);
                                ansG.setBackgroundColor(Color.RED);
                                wrong++;
                                clickA = 0;
                                check2 = true;
                            }
                        }
                    });
                    Button ansK = (Button) findViewById(R.id.ans_K2);
                    ansK.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (greenC == 0) {
                                ansC.setBackgroundColor(Color.RED);
                                ansK.setBackgroundColor(Color.RED);
                                wrong++;
                                clickA = 0;
                                check2 = true;
                            }
                        }
                    });
                    Button ansH = (Button) findViewById(R.id.ans_H2);
                    ansH.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (greenC == 0) {
                                ansC.setBackgroundColor(Color.RED);
                                ansH.setBackgroundColor(Color.RED);
                                wrong++;
                                clickA = 0;
                                check2 = true;
                            }
                        }
                    });
                }
            }
        });
        Button ansD = (Button) findViewById(R.id.ans_D2);
        ansD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check3 == true && greenD == 0 && greenC == 1) {
                    ansD2.setBackgroundColor(Color.WHITE);
                    ansH2.setBackgroundColor(Color.WHITE);
                    ansG2.setBackgroundColor(Color.WHITE);
                }

                clickA = 1;
                if(greenD == 0 && greenC == 1) {

                    Button ansK = (Button) findViewById(R.id.ans_K2);
                    ansK.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (greenD == 0) {
                                ansD.setBackgroundColor(Color.GREEN);
                                ansK.setBackgroundColor(Color.GREEN);
                                ansE2.setBackgroundColor(Color.WHITE);
                                correct++;
                                greenD = 1;
                                clickA = 0;
                            }
                        }
                    });

                    Button ansG = (Button) findViewById(R.id.ans_G2);
                    ansG.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (greenD == 0) {
                                ansD.setBackgroundColor(Color.RED);
                                ansG.setBackgroundColor(Color.RED);
                                wrong++;
                                clickA = 0;
                                check3 = true;
                            }
                        }
                    });
                    Button ansH = (Button) findViewById(R.id.ans_H2);
                    ansH.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (greenD == 0) {
                                ansD.setBackgroundColor(Color.RED);
                                ansH.setBackgroundColor(Color.RED);
                                wrong++;
                                clickA = 0;
                                check3 = true;
                            }
                        }
                    });
                }
            }
        });
        Button ansE = (Button) findViewById(R.id.ans_E2);
        ansE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check4 == true && greenE == 0 && greenD == 1) {
                    ansE2.setBackgroundColor(Color.WHITE);
                    ansH2.setBackgroundColor(Color.WHITE);
                }

                clickA = 1;
                if(greenE == 0 && greenD == 1) {

                    Button ansG = (Button) findViewById(R.id.ans_G2);
                    ansG.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (greenE == 0) {
                                ansE.setBackgroundColor(Color.GREEN);
                                ansG.setBackgroundColor(Color.GREEN);
                                ansF2.setBackgroundColor(Color.WHITE);
                                correct++;
                                greenE = 1;
                                clickA = 0;
                            }
                        }
                    });

                    Button ansH = (Button) findViewById(R.id.ans_H2);
                    ansH.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (greenE == 0) {
                                ansE.setBackgroundColor(Color.RED);
                                ansH.setBackgroundColor(Color.RED);
                                wrong++;
                                clickA = 0;
                                check4 = true;
                            }
                        }
                    });
                }
            }
        });
        Button ansF = (Button) findViewById(R.id.ans_F2);
        ansF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickA = 1;
                if(greenF == 0 && greenE == 1) {

                    Button ansH = (Button) findViewById(R.id.ans_H2);
                    ansH.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (greenF == 0) {
                                ansF.setBackgroundColor(Color.GREEN);
                                ansH.setBackgroundColor(Color.GREEN);
                                correct++;
                                greenF = 1;
                                clickA = 0;
                            }
                        }
                    });
                }
            }
        });



        loadNewQuestion();

    }


    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;
        if (clickedButton.getId() == R.id.submit_btn2) {
            if (correct == 6) {

                currentQuestionIndex++;
                SharedPreferences save2 = getSharedPreferences("Save", MODE_PRIVATE);
                int result1 = save2.getInt("Score1", 0);

                allscore = result1 + wrong;
                finishQuiz();
            }
        }
    }

    void loadNewQuestion() {

        questionTextView2.setText(QuestionAnswer.question2[currentQuestionIndex]);
        ansA2.setText(QuestionAnswer.choices2[currentQuestionIndex][0]);
        ansB2.setText(QuestionAnswer.choices2[currentQuestionIndex][1]);
        ansC2.setText(QuestionAnswer.choices2[currentQuestionIndex][2]);
        ansD2.setText(QuestionAnswer.choices2[currentQuestionIndex][3]);
        ansE2.setText(QuestionAnswer.choices2[currentQuestionIndex][4]);
        ansF2.setText(QuestionAnswer.choices2[currentQuestionIndex][5]);
        ansG2.setText(QuestionAnswer.choices2[currentQuestionIndex][6]);
        ansH2.setText(QuestionAnswer.choices2[currentQuestionIndex][7]);
        ansI2.setText(QuestionAnswer.choices2[currentQuestionIndex][8]);
        ansJ2.setText(QuestionAnswer.choices2[currentQuestionIndex][9]);
        ansK2.setText(QuestionAnswer.choices2[currentQuestionIndex][10]);
        ansL2.setText(QuestionAnswer.choices2[currentQuestionIndex][11]);

    }

    void finishQuiz() {

        if (allscore <= 1) {
            passtatus = 5;

        } else if (allscore <= 3) {
            passtatus = 4;

        } else if (allscore <= 5) {
            passtatus = 3;

        } else if (allscore >= 6) {
            passtatus = 2;

        }


        Intent resultIntent = new Intent(testTasks2.this, GameOverScreen.class);

        resultIntent.putExtra("score", passtatus);
        resultIntent.putExtra("wrong", allscore);

        startActivity(resultIntent);
        finish();
    }
}