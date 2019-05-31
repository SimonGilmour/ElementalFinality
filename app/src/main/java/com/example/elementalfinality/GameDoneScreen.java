package com.example.elementalfinality;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GameDoneScreen extends AppCompatActivity {
    int playerDied;
    int bossDied;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_done_screen);




        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
             playerDied = extras.getInt("playerDied");
            bossDied = extras.getInt("bossDied");
            score = extras.getInt("score");
        }


        game_win finalityWon = new game_win();
        game_over bossWon = new game_over();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();


        if(playerDied == 1)
        {
            transaction.replace(R.id.contentFragment, bossWon);
        }
        else
        {
            Bundle b = new Bundle();
            b.putInt("score", score);
            transaction.replace(R.id.contentFragment, finalityWon);
            finalityWon.setArguments(b);
        }
        transaction.commit();
    }


}
