package com.example.elementalfinality;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class game_win extends Fragment {


    public game_win() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_game_win,parent,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        TextView tvWinner = (TextView) view.findViewById(R.id.tvWin);
        TextView tvQuote = (TextView) view.findViewById(R.id.tvWin);
        ImageView obBossImage = (ImageView)view.findViewById(R.id.imgFinality);

    }


    }
