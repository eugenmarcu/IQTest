package com.example.android.iqtest;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.example.android.iqtest.databinding.ActivityQuizBinding;

import static com.example.android.iqtest.MainActivity.PLAYER_NAME_STRING;
import static com.example.android.iqtest.MainActivity.PLAYER_SCORE_STRING;


public class QuizActivity extends AppCompatActivity {

    private int score;
    private String name;
    private ActivityQuizBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_quiz);

        Intent intent = getIntent();
        name = intent.getExtras().getString(PLAYER_NAME_STRING);

        Button submitBtn = findViewById(R.id.button_submit);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = calculateScore();
                //Start Result activity
                Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                intent.putExtra(PLAYER_NAME_STRING, name);
                intent.putExtra(PLAYER_SCORE_STRING, score);
                startActivity(intent);
            }
        });
    }

    private int calculateScore(){
        int score = 0;
        if(binding.question1.rightAnswerMath.isChecked()) score++;
        if(binding.question2.rightAnswerUsain.isChecked()) score++;
        if(binding.question3.rightAnswerGeography.isChecked()) score++;
        if(binding.question4.rightAnswerCars.isChecked()) score++;
        //Math2 correct: b c d
        if(!binding.question5.wrongAnswerMath2.isChecked()&&binding.question5.rightAnswerMath21.isChecked()&&binding.question5.rightAnswerMath22.isChecked()&&binding.question5.rightAnswerMath23.isChecked()) score++;
        //EU correct: c
        if(!binding.question6.wrongAnswerEu1.isChecked()&&!binding.question6.wrongAnswerEu2.isChecked()&&binding.question6.rightAnswerEu.isChecked()&&!binding.question6.wrongAnswerEu3.isChecked()) score++;
        //Car brands correct: d
        if(!binding.question7.wrongAnswerCarGer1.isChecked()&&!binding.question7.wrongAnswerCarGer2.isChecked()&&!binding.question7.wrongAnswerCarGer3.isChecked()&&binding.question7.rightAnswerCarGer.isChecked()) score++;
        //Sports correct: a
        if(binding.question8.rightAnswerVolley.isChecked()&&!binding.question8.wrongAnswerVolley1.isChecked()&&!binding.question8.wrongAnswerVolley2.isChecked()&&!binding.question8.wrongAnswerVolley3.isChecked()) score++;
        return score;
    }
}
