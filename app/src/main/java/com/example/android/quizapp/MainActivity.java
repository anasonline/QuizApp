package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the "Submit" button is clicked. It checks the answers then
     * calculates the final score
     *
     * @param view
     */

    public void calculateScore(View view) {

        int numOfQuestions = 5;

        int q1Score = questionOneScore(view);
        int q2Score = questionTwoScore(view);
        int q3Score = questionThreeScore(view);
        int q4Score = questionFourScore(view);
        int q5Score = questionFiveScore(view);

        int score = q1Score + q2Score + q3Score + q4Score + q5Score;

        int percentScore = (100 * score) / numOfQuestions;

        Toast.makeText(this, "Your score is: " + percentScore + "%", Toast.LENGTH_LONG).show();

    }

    /**
     * Get the answer for Q1 and calculate its score (1 = correct answer, 0 = wrong answer)
     *
     * @param view
     * @return Score for Question 1
     */

    public int questionOneScore(View view) {

        int q1Score = 0;

        RadioGroup rg = (RadioGroup) findViewById(R.id.q1_radio_group);
        String selectedAnswer = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();

        if (selectedAnswer.equals("Berlin")) {
            q1Score = 1;
        }

        return q1Score;
    }

    /**
     * Get the answer for Q2 and calculate its score (1 = correct answer, 0 = wrong answer)
     *
     * @param view
     * @return Score for Question 2
     */

    public int questionTwoScore(View view) {
        int q2score = 0;

        EditText txt = (EditText) findViewById(R.id.q2_txt);
        String q2Answer = txt.getText().toString();

        if (q2Answer.trim().toLowerCase().equals("europe")) {
            q2score = 1;
        }

        return q2score;
    }

    /**
     * Get the answer for Q3 and calculate its score (1 = correct answer, 0 = wrong answer)
     *
     * @param view
     * @return Score for Question 3
     */

    public int questionThreeScore(View view) {

        int q3Score = 0;

        RadioGroup rg = (RadioGroup) findViewById(R.id.q3_radio_group);
        String selectedAnswer = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();

        if (selectedAnswer.equals("1989")) {
            q3Score = 1;
        }

        return q3Score;
    }

    /**
     * Get the answer for Q4 and calculate its score (1 = correct answer, 0 = wrong answer)
     *
     * @param view
     * @return Score for Question 4
     */

    public int questionFourScore(View view) {

        int q4score = 0;

        CheckBox op1 = (CheckBox) findViewById(R.id.angela_merkel);
        boolean angelaMerkel = op1.isChecked();

        CheckBox op2 = (CheckBox) findViewById(R.id.joachim_guack);
        boolean joachimGuack = op2.isChecked();

        CheckBox op3 = (CheckBox) findViewById(R.id.michael_muller);
        boolean michaelMuller = op3.isChecked();

        if (angelaMerkel && joachimGuack && !michaelMuller) {

            q4score = 1;
        }

        return q4score;

    }

    /**
     * Get the answer for Q5 and calculate its score (1 = correct answer, 0 = wrong answer)
     *
     * @param view
     * @return Score for Question 5
     */

    public int questionFiveScore(View view) {

        int q5Score = 0;

        RadioGroup rg = (RadioGroup) findViewById(R.id.q5_radio_group);
        String selectedAnswer = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();

        if (selectedAnswer.equals("North Rhine-Westphalia")) {
            q5Score = 1;
        }

        return q5Score;
    }

}
