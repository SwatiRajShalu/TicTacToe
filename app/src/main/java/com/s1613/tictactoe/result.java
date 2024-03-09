package com.s1613.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class result extends AppCompatActivity {
  Intent from_ma;
  TextView results;
  TextView down;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        results=findViewById(R.id.winner);
        down=findViewById(R.id.down);
        from_ma=getIntent();
        String winner= from_ma.getStringExtra("winner");
        if(winner.equals("X") || winner.equals("O"))
        results.setText(winner);
        else {
            results.setText("Oh!");
            down.setText("Draw");
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent to_ma=new Intent(result.this,MainActivity.class);
                startActivity(to_ma);
                finish();
            }
        },2000);
    }
}