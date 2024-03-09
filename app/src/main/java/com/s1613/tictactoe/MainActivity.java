package com.s1613.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    String b1,b2,b3,b4,b5,b6,b7,b8,b9;
    Button reset;
    int flag=0;
    int count=0;
    Animation alpha;

    TextView winner;
    TextView down;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intit();
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetblank();
            }
        });
        alpha=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha);
    }
    private void intit() {
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        reset=findViewById(R.id.reset);
        winner=findViewById(R.id.winner);
        down=findViewById(R.id.down);
    }
    public void check(View view){
         Button btn_curr=(Button) view;
         //1.baar baar ekk hi jagah pe input na kare
         //2.ekk baar jo jeet gya to game reset kar do
         //3.draw condition me reset daal do
         if(btn_curr.getText().toString().equals("")){
             count++;
             if(flag==0){
                 btn_curr.setText("X");
                 flag=1;
             }else{
                 btn_curr.setText("O");
                 flag=0;
             }
             if(count>4){
                 b1=btn1.getText().toString();
                 b2=btn2.getText().toString();
                 b3=btn3.getText().toString();
                 b4=btn4.getText().toString();
                 b5=btn5.getText().toString();
                 b6=btn6.getText().toString();
                 b7=btn7.getText().toString();
                 b8=btn8.getText().toString();
                 b9=btn9.getText().toString();


                 Intent result= new Intent(MainActivity.this,com.s1613.tictactoe.result.class);

                 if(b1.equals(b2)&&b2.equals(b3)&&!b1.equals("")){
                     start(btn1,btn2,btn3,b1);
//                     result.putExtra("winner",b1);
//                     startActivity(result);finish();
//                     Toast.makeText(this, "Winner is : "+ b1, Toast.LENGTH_SHORT).show();
                     blank();
                 }else if(b4.equals(b5)&&b5.equals(b6)&&!b4.equals("")){
                     start(btn4,btn5,btn6,b4);
//                     result.putExtra("winner",b4);
//                     startActivity(result); finish();
//                     Toast.makeText(this, "Winner is : "+ b4, Toast.LENGTH_SHORT).show();
                     blank();
                 }else if(b7.equals(b8)&&b8.equals(b9)&&!b7.equals("")){
                     start(btn7,btn8,btn9,b7);
//                     result.putExtra("winner",b7);
//                     startActivity(result);finish();
//                     Toast.makeText(this, "Winner is : "+ b7, Toast.LENGTH_SHORT).show();
                     blank();
                 }else if(b1.equals(b4)&&b4.equals(b7)&&!b1.equals("")){
                     start(btn1,btn4,btn7,b7);
//                     result.putExtra("winner",b4);
//                     startActivity(result);finish();
//                     Toast.makeText(this, "Winner is : "+ b1, Toast.LENGTH_SHORT).show();
                     blank();
                 }else if(b2.equals(b5)&&b5.equals(b8)&&!b2.equals("")){
                     start(btn2,btn5,btn8,b8);
//                     result.putExtra("winner",b2);
//                     startActivity(result);finish();
//                     Toast.makeText(this, "Winner is : "+ b2, Toast.LENGTH_SHORT).show();
                     blank();
                 }else if(b3.equals(b6)&&b6.equals(b9)&&!b3.equals("")){
                     start(btn3,btn6,btn9,b9);
//                     result.putExtra("winner",b3);
//                     startActivity(result);
//                     Toast.makeText(this, "Winner is : "+ b3, Toast.LENGTH_SHORT).show();
                     blank();
                 }else if(b1.equals(b5)&&b5.equals(b9)&&!b1.equals("")){
                     start(btn1,btn5,btn9,b9);
//                     result.putExtra("winner",b1);
//                     startActivity(result);finish();
//                     Toast.makeText(this, "Winner is : "+ b1, Toast.LENGTH_SHORT).show();
                     blank();
                 }else if(b3.equals(b5)&&b5.equals(b7)&&!b3.equals("")){
                     start(btn3,btn5,btn7,b7);
//                     result.putExtra("winner",b3);
//                     startActivity(result);finish();
//                     Toast.makeText(this, "Winner is : "+ b3, Toast.LENGTH_SHORT).show();
                     blank();
                 }else if(count==9){
                       down.setText("Draw");
//                     result.putExtra("winner","Draw");
//                     startActivity(result);finish();
//                     Toast.makeText(this , "DRAW", Toast.LENGTH_SHORT).show();
                     blank();
                 }
             }
         }
    }

    private void start(Button a,Button b, Button c,String s){
        a.startAnimation(alpha);
        b.startAnimation(alpha);
        c.startAnimation(alpha);
        winner.setText(s);
        down.setText("Winner");
    }

    private void blank() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                resetblank();
            }
        },2000);
    }
    private void resetblank(){
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        winner.setText("");
        down.setText("");
        count=0; flag=0;
    }
}