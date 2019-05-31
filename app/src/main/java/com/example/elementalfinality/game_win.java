package com.example.elementalfinality;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class game_win extends Fragment implements View.OnClickListener {
    private PlayerScoreHelper db;
        Button obPlayAgain;
        Button obSendScore;

    EditText enterName;
    public game_win() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState)
    {



        db = new PlayerScoreHelper(getContext());
        return inflater.inflate(R.layout.fragment_game_win,parent,false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        TextView tvWinner = (TextView) view.findViewById(R.id.tvWin);
        ImageView obPlayerImage = (ImageView)view.findViewById(R.id.imgFinality);
         enterName = (EditText)view.findViewById(R.id.editText);
         obPlayAgain = (Button)view.findViewById(R.id.btnPlayAgain);
         obPlayAgain.setOnClickListener(this);

         obSendScore = (Button)view.findViewById(R.id.btnSaveScore);
         obSendScore.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {

        db = new PlayerScoreHelper(getContext());

        db.onOpen();

        if(view.equals(obPlayAgain)) {
            Intent i = new Intent(this.getActivity(), MainActivity.class);
            startActivity(i);
        }


                 if(view.equals(obSendScore)) {
                     int score = getArguments().getInt("score");
                     Toast.makeText(this.getContext(), "Score Sent", Toast.LENGTH_SHORT).show();
                     PlayerScore playerScore = new PlayerScore(enterName.getText().toString(),score );
                     db.createScore(playerScore);
                     Intent i = new Intent(this.getActivity(), MainMenu.class);
                     startActivity(i);
                 }
                 db.close();
        }

    }


