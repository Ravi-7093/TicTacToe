package com.example.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    //0 - X
    //1 - O
    boolean gameactive = true;
    int activePlayer = 0;
    int gameState[] = {2,2,2,2,2,2,2,2,2,2};

    int winningPostions[][]= {{1,2,3} ,{4,6,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gameReset(View view){
        gameactive = true;
        activePlayer=0;
        for (int i=0;i<gameState.length;i++){
            gameState [i]=2;

        }
        ( (ImageView)findViewById(R.id.img1)).setImageResource(0);
        ( (ImageView)findViewById(R.id.img2)).setImageResource(0);
        ( (ImageView)findViewById(R.id.img3)).setImageResource(0);
        ( (ImageView)findViewById(R.id.img4)).setImageResource(0);
        ( (ImageView)findViewById(R.id.img5)).setImageResource(0);
        ( (ImageView)findViewById(R.id.img6)).setImageResource(0);
        ( (ImageView)findViewById(R.id.img7)).setImageResource(0);
        ( (ImageView)findViewById(R.id.img8)).setImageResource(0);
        ( (ImageView)findViewById(R.id.img0)).setImageResource(0);
        TextView status = findViewById(R.id.status);
        status.setText("Tap to play");


    }
    public void PlayerClick(View view ){

        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        System.out.println(tappedImage);

        if (!gameactive){
            gameReset(view);
        }

        if (gameState[tappedImage]==2  ) {
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn - Tap to Play");
            } else {
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn - Tap to Play");
            }
            for(int[] winPostion: winningPostions){

            }
            img.animate().translationYBy(1000f).setDuration(300);
            for (int [] winPosition:winningPostions){
                if(gameState[winPosition[0]]==gameState[winPosition[1]]&&
                gameState[winPosition[1]] == gameState[winPosition[2]]&&
                gameState[winPosition[0]]!=2){

                    System.out.println("Hello");

                    String winner ;
                    gameactive=false;
                    if(gameState[winPosition[0]]==0){
                        winner = "X has won";
                    }
                    else{
                        winner = "Y has won";
                    }
                    TextView status = findViewById(R.id.status);
                    status.setText(winner);
                }
            }
        }



    }
}