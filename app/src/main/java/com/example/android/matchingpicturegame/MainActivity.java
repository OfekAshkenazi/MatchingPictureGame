package com.example.android.matchingpicturegame;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    View lastClick=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void setOnClickListeners(){
        ImageView ImageScissors=(ImageView) findViewById(R.id.scissors);
        ImageView ImageBell=(ImageView) findViewById(R.id.bell);
        ImageView ImageLetter=(ImageView) findViewById(R.id.Letter);
        ImageView ImageStar=(ImageView) findViewById(R.id.star);
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.equals(lastClick)){
                    lastClick=null;
                    view.setBackgroundColor(Color.GRAY);
                    return;
                }
                if (lastClick==null){
                    view.setBackgroundColor(Color.GREEN);
                    lastClick=view;
                    return;
                }
                if (recognizeView(view).equals(recognizeView(lastClick))){

                }
            }
        };

    }
    public String recognizeView(View view){
        switch (view.getId()){
            case (R.id.bell):
            case R.id.bellButton:{
                return "bell";
            }
            case R.id.Letter:
            case R.id.LetterButton:{
                return "letter";
            }
            case R.id.scissors:
            case R.id.ScissorsButton:{
                return "scissors";
            }
            case R.id.star:
            case R.id.StarButton:{
                return "star";
            }
        }
    }

}
