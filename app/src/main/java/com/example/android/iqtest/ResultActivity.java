package com.example.android.iqtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
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
        textViewCongrats.setText(getString(R.string.congrats) + name + "!!!");
        TextView textViewScore = findViewById(R.id.textView_score);
        textViewScore.setText(getString(R.string.you_scored)+ score + getString(R.string.out_of));
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
                textViewScoreName.setText(getString(R.string.you_smart) + getString(R.string.chimp));
            case 2:
                imageView.setImageResource(R.drawable.chimp);
                textViewScoreName.setText(getString(R.string.you_smart) + getString(R.string.chimp));
                break;
            case 3:
                imageView.setImageResource(R.drawable.trump);
                textViewScoreName.setText(getString(R.string.you_smart) + getString(R.string.donald));
            case 4:
                imageView.setImageResource(R.drawable.trump);
                textViewScoreName.setText(getString(R.string.you_smart) + getString(R.string.donald));
                break;
            case 5:
                imageView.setImageResource(R.drawable.elon_musk);
                textViewScoreName.setText(getString(R.string.you_smart) + getString(R.string.elon));
            case 6:
                imageView.setImageResource(R.drawable.elon_musk);
                textViewScoreName.setText(getString(R.string.you_smart) + getString(R.string.elon));
                break;
            case 7:
                imageView.setImageResource(R.drawable.albert_einstein);
                textViewScoreName.setText(getString(R.string.you_smart) + getString(R.string.albert));
            case 8:
                imageView.setImageResource(R.drawable.albert_einstein);
                textViewScoreName.setText(getString(R.string.you_smart) + getString(R.string.albert));
                break;
        }

        Button buttonRestart = findViewById(R.id.button_reset);
        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ResultActivity.super.onBackPressed();
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
