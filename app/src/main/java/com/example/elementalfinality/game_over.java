package com.example.elementalfinality;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class game_over extends Fragment implements View.OnClickListener {

    Button obMainLose;
    public game_over()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.activity_game_over,parent,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        TextView tvWinner = (TextView)view.findViewById(R.id.tvLose);
        TextView tvQuote = (TextView)view.findViewById(R.id.tvLoseQuote);
        ImageView obBossImage = (ImageView)view.findViewById(R.id.imgBoss);
        obMainLose = (Button)view.findViewById(R.id.btnLoseMain);
        obMainLose.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        if(view.equals(obMainLose))
        {
            Intent i = new Intent(this.getActivity(), MainMenu.class);
            startActivity(i);
        }
    }
}
