package com.example.android.matchingpicturegame;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    View lastClick=null;
    Button restart;
    ImageView ImageScissors,ImageBell,ImageLetter,ImageStar;
    Button buttonStar,buttonBell,buttonScissors,buttonLetter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageScissors=(ImageView) findViewById(R.id.scissors);
        ImageBell=(ImageView) findViewById(R.id.bell);
        ImageLetter=(ImageView) findViewById(R.id.Letter);
        ImageStar=(ImageView) findViewById(R.id.star);
        buttonStar=(Button) findViewById(R.id.StarButton);
        buttonBell=(Button) findViewById(R.id.bellButton);
        buttonScissors=(Button) findViewById(R.id.ScissorsButton);
        buttonLetter=(Button) findViewById(R.id.LetterButton);
        restart=(Button) findViewById(R.id.restartB);
        setOnClickListeners();
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageScissors.setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
                ImageBell.setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
                ImageLetter.setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
                ImageStar.setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
                buttonStar.setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
                buttonBell.setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
                buttonScissors.setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
                buttonLetter.setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
            }
        });
    }
    public void setOnClickListeners(){
        ImageScissors.setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
        ImageBell.setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
        ImageLetter.setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
        ImageStar.setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
        buttonStar.setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
        buttonBell.setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
        buttonScissors.setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
        buttonLetter.setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorDrawable color = (ColorDrawable) view.getBackground();
                if (color.getColor() == Color.BLUE) {
                    return;
                }
                if (view.equals(lastClick)||(lastClick!=null&&recognizeView(view)!=recognizeView(lastClick))){
                    lastClick.setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
                    view.setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
                    lastClick=null;
                    return;
                }
                if (lastClick==null){
                    view.setBackgroundDrawable(new ColorDrawable(Color.GREEN));
                    lastClick=view;
                    return;
                }
                if (recognizeView(view)==recognizeView(lastClick)){
                    view.setBackgroundDrawable(new ColorDrawable(Color.BLUE));
                    lastClick.setBackgroundDrawable(new ColorDrawable(Color.BLUE));
                    lastClick=null;
                    return;
                }
            }
        };
        buttonStar.setOnClickListener(listener);
        buttonBell.setOnClickListener(listener);
        buttonScissors.setOnClickListener(listener);
        buttonLetter.setOnClickListener(listener);

        ImageStar.setOnClickListener(listener);
        ImageLetter.setOnClickListener(listener);
        ImageBell.setOnClickListener(listener);
        ImageScissors.setOnClickListener(listener);

    }
    public int recognizeView(View view){
        switch (view.getId()){
            case (R.id.bell):
            case R.id.bellButton:{
                return 1;
            }
            case R.id.Letter:
            case R.id.LetterButton:{
                return 2;
            }
            case R.id.scissors:
            case R.id.ScissorsButton:{
                return 3;
            }
            case R.id.star:
            case R.id.StarButton:{
                return 4;
            }
        }
        return -1;
    }

}
