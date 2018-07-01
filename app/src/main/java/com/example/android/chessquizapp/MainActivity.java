package com.example.android.chessquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void markQuiz(View view) {
        EditText name = (EditText) findViewById(R.id.username);
        username = String.valueOf(name.getText());

        RadioButton question1 = (RadioButton) findViewById(R.id.no);
        boolean answer1 = question1.isChecked();

        RadioButton question2 = (RadioButton) findViewById(R.id.pawn);
        boolean answer2 = question2.isChecked();

        RadioButton question3 = (RadioButton) findViewById(R.id.carlsen);
        boolean answer3 = question3.isChecked();

        RadioButton question4 = (RadioButton) findViewById(R.id.qg8);
        boolean answer4 = question4.isChecked();

        CheckBox firstCheckBox = (CheckBox) findViewById(R.id.q5_first_checkbox);
        boolean answer5a = firstCheckBox.isChecked();

        CheckBox secondCheckBox = (CheckBox) findViewById(R.id.q5_second_checkbox);
        boolean answer5b = secondCheckBox.isChecked();

        CheckBox thirdCheckBox = (CheckBox) findViewById(R.id.q5_third_checkbox);
        boolean answer5c = thirdCheckBox.isChecked();

        CheckBox fourthCheckBox = (CheckBox) findViewById(R.id.q5_fourth_checkbox);
        boolean answer5d = fourthCheckBox.isChecked();
        boolean answer5 = false;
        if (answer5a && answer5b && answer5c && !answer5d) {
            answer5 = true;
        }

        EditText check = (EditText) findViewById(R.id.check);
        String checkInput = String.valueOf(check.getText()).toLowerCase();
        boolean answer6 = false;
        if (checkInput.equals("check")) {
            answer6 = true;
        }

        EditText sixtyFour = (EditText) findViewById(R.id.sixtyfour);
        String sixtyFourInput = String.valueOf(check.getText());
        boolean answer7 = false;
        if (sixtyFourInput.equals("64")) {
            answer7 = true;
        }

        int score = 0;

        //the following lines Check if answers were correct and increments score
        if (answer1) {
            score++;
        }

        if (answer2) {
            score++;
        }

        if (answer3) {
            score++;
        }

        if (answer4) {
            score++;
        }

        if (answer5) {
            score++;
        }

        if (answer6) {
            score++;
        }

        if (answer7) {
            score++;
        }

        displayResult(score, username);
    }

    public void displayResult(int score, String name) {
        if (score == 0) {
            Toast.makeText(this, "Oops, " + name + "! You scored 0 points! Don't give up chess just yet! Visit chess.com for some beginner lessons!", Toast.LENGTH_LONG).show();
        } else if (score == 7) {
            Toast.makeText(this, "Excellent!!, " + name + "! Your score is: " + score + "/7. You did a pretty good job!", Toast.LENGTH_LONG).show();
        } else if (score >= 5) {
            Toast.makeText(this, "Good, " + name + "! Your score is: " + score + "/7. You did a pretty good job!", Toast.LENGTH_LONG).show();
        } else if (score < 5) {
            Toast.makeText(this, "Not bad, " + name + "! Your score is: " + score + "/7. Learn about more basic chess concepts and news!", Toast.LENGTH_LONG).show();
        }
    }
}
