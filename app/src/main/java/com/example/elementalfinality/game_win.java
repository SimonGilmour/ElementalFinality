package com.example.elementalfinality;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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



        db = new PlayerScoreHelper(getContext());
        return inflater.inflate(R.layout.fragment_game_win,parent,false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

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

        }
        db.close();
    }


}
