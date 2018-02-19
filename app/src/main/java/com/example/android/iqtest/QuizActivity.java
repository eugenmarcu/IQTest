package com.example.android.iqtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;


public class QuizActivity extends AppCompatActivity {

    private int score;
    private String name;

    RadioButton radioBtnMath;
    RadioButton radioBtnSport;
    RadioButton radioBtnGeography;
    RadioButton radioBtnCars;
    //Math2 question
    CheckBox checkBoxMath1;
    CheckBox checkBoxMath2;
    CheckBox checkBoxMath3;
    CheckBox checkBoxMath4;
    //Eu question
    CheckBox checkBoxEU1;
    CheckBox checkBoxEU2;
    CheckBox checkBoxEU3;
    CheckBox checkBoxEU4;
    //Car brands question
    CheckBox checkBoxCars1;
    CheckBox checkBoxCars2;
    CheckBox checkBoxCars3;
    CheckBox checkBoxCars4;
    //Sports question
    CheckBox checkBoxSports1;
    CheckBox checkBoxSports2;
    CheckBox checkBoxSports3;
    CheckBox checkBoxSports4;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        radioBtnMath = findViewById(R.id.right_answer_math);
        radioBtnSport = findViewById(R.id.right_answer_usain);
        radioBtnGeography = findViewById(R.id.right_answer_geography);
        radioBtnCars = findViewById(R.id.right_answer_cars);
        //Math2 question
        checkBoxMath1 = findViewById(R.id.wrong_answer_math2);
        checkBoxMath2 = findViewById(R.id.right_answer_math2_1);
        checkBoxMath3 = findViewById(R.id.right_answer_math2_2);
        checkBoxMath4 = findViewById(R.id.right_answer_math2_3);
        //EU question
        checkBoxEU1 = findViewById(R.id.wrong_answer_eu1);
        checkBoxEU2 = findViewById(R.id.wrong_answer_eu2);
        checkBoxEU3 = findViewById(R.id.right_answer_eu);
        checkBoxEU4 = findViewById(R.id.wrong_answer_eu3);
        //cars brands question
        checkBoxCars1 = findViewById(R.id.wrong_answer_car_brands1);
        checkBoxCars2 = findViewById(R.id.wrong_answer_car_brands2);
        checkBoxCars3 = findViewById(R.id.wrong_answer_car_brands3);
        checkBoxCars4 = findViewById(R.id.right_answer_car_brands);
        //Sports question
        checkBoxSports1 = findViewById(R.id.right_answer_sports);
        checkBoxSports2 = findViewById(R.id.wrong_answer_sports1);
        checkBoxSports3 = findViewById(R.id.wrong_answer_sports2);
        checkBoxSports4 = findViewById(R.id.wrong_answer_sports3);

        Intent intent = getIntent();
        name = intent.getExtras().getString("name");

        Button submitBtn = findViewById(R.id.button_submit);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = calculateScore();
                //Start Result activity
                Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("score", score);
                startActivity(intent);
            }
        });
    }

    private int calculateScore(){
        int score = 0;
        if(radioBtnMath.isChecked()) score++;
        if(radioBtnGeography.isChecked()) score++;
        if(radioBtnSport.isChecked()) score++;
        if(radioBtnCars.isChecked()) score++;
        //Math2 correct: b c d
        if(!checkBoxMath1.isChecked()&&checkBoxMath2.isChecked()&&checkBoxMath3.isChecked()&&checkBoxMath4.isChecked()) score++;
        //EU correct: c
        if(!checkBoxEU1.isChecked()&&!checkBoxEU2.isChecked()&&checkBoxEU3.isChecked()&&!checkBoxEU4.isChecked()) score++;
        //Car brands correct: d
        if(!checkBoxCars1.isChecked()&&!checkBoxCars2.isChecked()&&!checkBoxCars3.isChecked()&&checkBoxCars4.isChecked()) score++;
        //Sports correct: a
        if(checkBoxSports1.isChecked()&&!checkBoxSports2.isChecked()&&!checkBoxSports3.isChecked()&&!checkBoxSports4.isChecked()) score++;
        return score;
    }
}
