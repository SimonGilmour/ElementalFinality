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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_done_screen);

        displayNotification();



        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
             playerDied = extras.getInt("playerDied");
            bossDied = extras.getInt("bossDied");
        }


        game_win finalityWon = new game_win();
        game_over bossWon = new game_over();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        if(playerDied == 1)
        {
            transaction.replace(R.id.contentFragment, finalityWon);
        }
        else
        {
            transaction.replace(R.id.contentFragment, bossWon);
        }
        transaction.commit();
    }

    private void displayNotification() {
        String sChannel = "1";

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, sChannel)
                .setSmallIcon(R.drawable.freeze)
                .setContentTitle("Rate Us!")
                .setContentText("Like the game? Rate us on our website \n https://www.ElementalFinality.com")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            CharSequence name = "channel1";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(sChannel,name,importance);


            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

            NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
            notificationManagerCompat.notify(1, builder.build());
        }

    }
}
