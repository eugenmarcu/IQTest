package com.example.android.iqtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import static com.example.android.iqtest.MainActivity.PLAYER_NAME_STRING;
import static com.example.android.iqtest.MainActivity.PLAYER_SCORE_STRING;


public class ResultActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String name;
        int score;

        Intent intent = getIntent();
        name = intent.getExtras().getString(PLAYER_NAME_STRING);
        score  = intent.getExtras().getInt(PLAYER_SCORE_STRING);

        TextView textViewCongrats = findViewById(R.id.textView_congrats);
        textViewCongrats.setText(getString(R.string.congrats) + name + "!!!");
        TextView textViewScore = findViewById(R.id.textView_score);
        textViewScore.setText(getString(R.string.you_scored)+ score + getString(R.string.out_of));
        ImageView imageView = findViewById(R.id.imageView_result);

        switch (score) {
            case 0:
                imageView.setImageResource(R.drawable.negative_result);
                Toast.makeText(this, getString(R.string.negative_result), Toast.LENGTH_LONG).show();
                break;
            case 1:
                imageView.setImageResource(R.drawable.chimp);
                Toast.makeText(this, getString(R.string.you_smart) + getString(R.string.chimp), Toast.LENGTH_LONG).show();
            case 2:
                imageView.setImageResource(R.drawable.chimp);
                Toast.makeText(this, getString(R.string.you_smart) + getString(R.string.chimp), Toast.LENGTH_LONG).show();
                break;
            case 3:
                imageView.setImageResource(R.drawable.trump);
                Toast.makeText(this, getString(R.string.you_smart) + getString(R.string.donald), Toast.LENGTH_LONG).show();
            case 4:
                imageView.setImageResource(R.drawable.trump);
                Toast.makeText(this, getString(R.string.you_smart) + getString(R.string.donald), Toast.LENGTH_LONG).show();
                break;
            case 5:
                imageView.setImageResource(R.drawable.elon_musk);
                Toast.makeText(this, getString(R.string.you_smart) + getString(R.string.elon), Toast.LENGTH_LONG).show();
            case 6:
                imageView.setImageResource(R.drawable.elon_musk);
                Toast.makeText(this, getString(R.string.you_smart) + getString(R.string.elon), Toast.LENGTH_LONG).show();
                break;
            case 7:
                imageView.setImageResource(R.drawable.albert_einstein);
                Toast.makeText(this, getString(R.string.you_smart) + getString(R.string.albert), Toast.LENGTH_LONG).show();
            case 8:
                imageView.setImageResource(R.drawable.albert_einstein);
                Toast.makeText(this, getString(R.string.you_smart) + getString(R.string.albert), Toast.LENGTH_LONG).show();
                break;
        }

        Button buttonRestart = findViewById(R.id.button_reset);
        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
