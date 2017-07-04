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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setOnClickListeners();
    }
    public void setOnClickListeners(){
        ImageView ImageScissors=(ImageView) findViewById(R.id.scissors);
        ImageView ImageBell=(ImageView) findViewById(R.id.bell);
        ImageView ImageLetter=(ImageView) findViewById(R.id.Letter);
        ImageView ImageStar=(ImageView) findViewById(R.id.star);
        Button buttonStar=(Button) findViewById(R.id.StarButton);
        Button buttonBell=(Button) findViewById(R.id.bellButton);
        Button buttonScissors=(Button) findViewById(R.id.ScissorsButton);
        Button buttonLetter=(Button) findViewById(R.id.LetterButton);
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getBackground() instanceof ColorDrawable) {
                    ColorDrawable color = (ColorDrawable) view.getBackground();
                    if (color.getColor() == Color.BLUE)
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
