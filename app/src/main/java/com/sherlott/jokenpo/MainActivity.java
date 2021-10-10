package com.sherlott.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Animatable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView play1;
    ImageView play2;

    ImageButton btnJo;
    ImageButton btnKen;
    ImageButton btnPo;

    Animation hide;
    Animation visible;

    int[] playerChoice = new int[2];

    String[][] result = new String[3][3];

    MediaPlayer mediaplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play1 = findViewById(R.id.play1);
        play2 = findViewById(R.id.play2);

        btnJo = findViewById(R.id.btnJo);
        btnKen = findViewById(R.id.btnKen);
        btnPo = findViewById(R.id.btnPo);

        result[0][0] = "Draw";
        result[0][1] = "Lose";
        result[0][2] = "Win";

        result[1][0] = "Win";
        result[1][1] = "Draw";
        result[1][2] = "Lose";

        result[2][0] = "Lose";
        result[2][1] = "Win";
        result[2][2] = "Draw";

        hide = new AlphaAnimation(1, 0);
        visible = new AlphaAnimation(0, 1);

        hide.setDuration(1500);
        visible.setDuration(10);

        mediaplayer = MediaPlayer.create(MainActivity.this, R.raw.alex_play);

        hide.setAnimationListener(new Animation.AnimationListener(){
            @Override
            public void onAnimationStart(Animation animation) {
                play2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                play2.setVisibility(View.INVISIBLE);
                play2.startAnimation(visible);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        visible.setAnimationListener(new Animation.AnimationListener(){
            @Override
            public void onAnimationStart(Animation animation) {
                drawPlay();
                play2.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                comparePlay();
                play2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
    }

    public void selectBtn(View view) {
        startSong();

        play1.setScaleX(-1);
        switch(view.getId()) {
            case(R.id.btnJo):
                play1.setImageResource(R.drawable.pedra);
                playerChoice[0] = 0;
                break;
            case(R.id.btnKen):
                play1.setImageResource(R.drawable.papel);
                playerChoice[0] = 1;
                break;
            case(R.id.btnPo):
                play1.setImageResource(R.drawable.tesoura);
                playerChoice[0] = 2;
                break;
        }

        play2.setImageResource(R.drawable.interrogacao);
        play2.startAnimation(hide);
    }

    public void drawPlay() {
        Random r = new Random();
        int numberRandom = r.nextInt(3);

        switch(numberRandom) {
            case 0:
                play2.setImageResource(R.drawable.pedra);
                playerChoice[1] = 0;
                break;
            case 1:
                play2.setImageResource(R.drawable.papel);
                playerChoice[1] = 1;
                break;
            case 2:
                play2.setImageResource(R.drawable.tesoura);
                playerChoice[1] = 2;
                break;
        }
    };

    public void comparePlay() {
        switch (result[playerChoice[0]][playerChoice[1]]) {
            case "Win":
                Toast.makeText(this, "Você Ganhou", Toast.LENGTH_SHORT).show();
                break;
            case "Draw":
                Toast.makeText(this, "Você Empatou", Toast.LENGTH_SHORT).show();
                break;
            case "Lose":
                Toast.makeText(this, "Você Perdeu", Toast.LENGTH_SHORT).show();
                break;
        };
    };

    public void startSong() {
        if(mediaplayer != null) {
            mediaplayer.start();
        }
    }
}