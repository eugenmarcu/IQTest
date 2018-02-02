package com.example.android.iqtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class ResultActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String name;
        int score;

        Intent intent = getIntent();
        name = intent.getExtras().getString("name");
        score  = intent.getExtras().getInt("score");

        TextView textViewCongrats = findViewById(R.id.textView_congrats);
        textViewCongrats.setText("Congratulations " + name + "!!!");
        TextView textViewScore = findViewById(R.id.textView_score);
        textViewScore.setText("You scored "+ score + " out of 8");
        ImageView imageView = findViewById(R.id.imageView_result);
        TextView textViewScoreName = findViewById(R.id.textView_score_name);
        textViewScoreName.setVisibility(View.VISIBLE);

        switch (score) {
            case 0:
                imageView.setImageResource(R.drawable.negative_result);
                textViewScoreName.setVisibility(View.GONE);
                break;
            case 1:
                imageView.setImageResource(R.drawable.chimp);
                textViewScoreName.setText("You are as smart as " + "a chimp");
            case 2:
                imageView.setImageResource(R.drawable.chimp);
                textViewScoreName.setText("You are as smart as " + "a chimp");
                break;
            case 3:
                imageView.setImageResource(R.drawable.trump);
                textViewScoreName.setText("You are as smart as " + "Donald Trump");
            case 4:
                imageView.setImageResource(R.drawable.trump);
                textViewScoreName.setText("You are as smart as " + "Donald Trump");
                break;
            case 5:
                imageView.setImageResource(R.drawable.elon_musk);
                textViewScoreName.setText("You are as smart as " + "Elon Musk");
            case 6:
                imageView.setImageResource(R.drawable.elon_musk);
                textViewScoreName.setText("You are as smart as " + "Elon Musk");
                break;
            case 7:
                imageView.setImageResource(R.drawable.albert_einstein);
                textViewScoreName.setText("You are as smart as " + "Albert Einstein");
            case 8:
                imageView.setImageResource(R.drawable.albert_einstein);
                textViewScoreName.setText("You are as smart as " + "Albert Einstein");
                break;
        }

    }
}
