package com.example.elementalfinality;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;



public class game_win extends Fragment implements View.OnClickListener {
    private PlayerScoreHelper db;
    EditText enterName;
    public game_win() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState)
    {
        displayNotification();
        db = new PlayerScoreHelper(getContext());

        return inflater.inflate(R.layout.fragment_game_win,parent,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        displayNotification();
        TextView tvWinner = (TextView) view.findViewById(R.id.tvWin);
        ImageView obPlayerImage = (ImageView)view.findViewById(R.id.imgFinality);
         enterName = (EditText)view.findViewById(R.id.editText);


    }


    @Override
    public void onClick(View view) {
        db.onOpen();
        switch(view.getId())
        {
            case R.id.btnPlayAgain:
                break;
            case R.id.btnSaveScore:
                PlayerScore playerScore = new PlayerScore(enterName.getText().toString(), 10);
                db.createScore(playerScore);
                break;
            case R.id.btnViewScore:

        }
        db.close();
    }

    private void displayNotification() {
        String sChannel = "1";

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(), sChannel)
                .setSmallIcon(R.drawable.freeze)
                .setContentTitle("Rate Us!")
                .setContentText("Like the game? Rate us on our website \n https://www.ElementalFinality.com")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            CharSequence name = "channel1";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(sChannel,name,importance);


            NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(getActivity().NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);

            NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getContext());
            notificationManagerCompat.notify(1, builder.build());
        }

    }
}
