package com.example.geoquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Test2 extends AppCompatActivity implements View.OnClickListener {

    TextView totalQuestionsTextView2;
    TextView questionTextView2;
    Button ansA2, ansB2, ansC2, ansD2;
    Button submitBtn2;

    int score=0;
    int totalQuestion2 = QuestionAnswer2.question2.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        totalQuestionsTextView2 = findViewById(R.id.total_question2);
        questionTextView2 = findViewById(R.id.question2);
        ansA2 = findViewById(R.id.ans_A2);
        ansB2 = findViewById(R.id.ans_B2);
        ansC2 = findViewById(R.id.ans_C2);
        ansD2 = findViewById(R.id.ans_D2);
        submitBtn2 = findViewById(R.id.submit_btn2);

        ansA2.setOnClickListener(this);
        ansB2.setOnClickListener(this);
        ansC2.setOnClickListener(this);
        ansD2.setOnClickListener(this);
        submitBtn2.setOnClickListener(this);

        totalQuestionsTextView2.setText("Total questions : "+totalQuestion2);

        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {
        ansA2.setBackgroundColor(Color.WHITE);
        ansB2.setBackgroundColor(Color.WHITE);
        ansC2.setBackgroundColor(Color.WHITE);
        ansD2.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.submit_btn2){
            if(selectedAnswer.equals(QuestionAnswer2.correctAnswers2[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();

        }else{
            //choices button clicked
            selectedAnswer  = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.BLUE);
        }

    }

    void  loadNewQuestion(){

        if(currentQuestionIndex == totalQuestion2 ){
            finishQuiz();
            return;
        }

        questionTextView2.setText(QuestionAnswer2.question2[currentQuestionIndex]);
        ansA2.setText(QuestionAnswer2.choices2[currentQuestionIndex][0]);
        ansB2.setText(QuestionAnswer2.choices2[currentQuestionIndex][1]);
        ansC2.setText(QuestionAnswer2.choices2[currentQuestionIndex][2]);
        ansD2.setText(QuestionAnswer2.choices2[currentQuestionIndex][3]);

    }
    void finishQuiz(){
        String passStatus = "";
        if(score > totalQuestion2*0.60){
            passStatus = "Passed";
        }else{
            passStatus = "Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is "+ score+" out of "+ totalQuestion2)
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz() )
                .setCancelable(false)
                .show();

    }
    void restartQuiz(){
        score = 0;
        currentQuestionIndex =0;
        loadNewQuestion();
    }
}

