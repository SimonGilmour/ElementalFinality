package com.example.elementalfinality;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class game_over extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.activity_game_over,parent,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        TextView tvWinner = (TextView)view.findViewById(R.id.tvWinner);
        TextView tvQuote = (TextView)view.findViewById(R.id.tvQuote);

    }


}
