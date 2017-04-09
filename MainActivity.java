package com.example.android.ukrainequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.android.ukrainequiz.R;

public class MainActivity extends AppCompatActivity {

    int scoreTotal = 0;
    int numberOfQuestions = 5;
    int answer = 0;
    int answer1 = 0;
    int answer2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    public void submitAnswers(View view) {
        submit(getScore());
        scoreTotal = 0;
    }

    public int getScore() {
            /* Q1 */
        EditText q1 = (EditText) findViewById(R.id.question1);
        try {
            answer = Integer.parseInt(q1.getText().toString());
        } catch (NumberFormatException nfe) {
            answer = 0;
        }
        if (answer == 2008) {
            scoreTotal = scoreTotal + 1;
        }

        /* Q2 */
        RadioButton q2 = (RadioButton) findViewById(R.id.capital2);
        if (q2.isChecked()) {
            scoreTotal = scoreTotal + 1;
        }

        /* Q3 */
        CheckBox q3p1 = (CheckBox) findViewById(R.id.person1);
        CheckBox q3p2 = (CheckBox) findViewById(R.id.person2);
        CheckBox q3p3 = (CheckBox) findViewById(R.id.person3);
        CheckBox q3p4 = (CheckBox) findViewById(R.id.person4);
        CheckBox q3p5 = (CheckBox) findViewById(R.id.person5);
        CheckBox q3p6 = (CheckBox) findViewById(R.id.person6);
        if (!(q3p2.isChecked() || q3p3.isChecked() || q3p6.isChecked()) && q3p1.isChecked() && q3p4.isChecked() && q3p5.isChecked()) {
            scoreTotal = scoreTotal + 1;
        }

        /* Q4 */
        EditText q4a1 = (EditText) findViewById(R.id.number1);
        try {
            answer1 = Integer.parseInt(q4a1.getText().toString());
        } catch (NumberFormatException nfe) {
            answer1 = 0;
        }
        EditText q4a2 = (EditText) findViewById(R.id.number2);
        try {
            answer2 = Integer.parseInt(q4a2.getText().toString());
        } catch (NumberFormatException nfe) {
            answer2 = 0;
        }

        if (answer1 == 27) if (answer2 == 24) {
            scoreTotal = scoreTotal + 1;
        }

        /* Q5 */
        RadioButton q5 = (RadioButton) findViewById(R.id.button_coat1);
        if (q5.isChecked()) {
            scoreTotal = scoreTotal + 1;
        }

        return scoreTotal;
    }


    public void submit(int score) {
        String toastMessage = score + " out of " + numberOfQuestions + " correct! ";
        if (score == numberOfQuestions) {
            toastMessage = toastMessage + "Congratulations! It seems like you know too much about Ukraine.";
        } else if ((score < numberOfQuestions) && (scoreTotal > (numberOfQuestions - 3))) {
            toastMessage = toastMessage + "Not bad! Do you want to try again?";
        } else {
            toastMessage = toastMessage + "Do you want to try again?";
        }
        Toast.makeText(this, toastMessage,
                Toast.LENGTH_LONG).show();
    }


}