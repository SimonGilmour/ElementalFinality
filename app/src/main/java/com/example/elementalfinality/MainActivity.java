package com.example.elementalfinality;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createCardField();

        View obView = new View(getApplicationContext());
        obView.setRotationY(180f);
        Player player1 = new Player(30, false, false, false, false, false);
        Player obBoss = new Player(50, false, false, false, false, false);
//        cardSlot1 = (ImageButton)findViewById(R.id.cardSlot1);
//        cardSlot1.setBackgroundResource(R.drawable.freeze);
//        cardSlot1.setTag("Freeze");

    }

    private void createCardField() {

        ImageButton[] obButton = new ImageButton[5];

        for(int i = 0; i < 5; i++)
        {
            final int ID = R.id.cardSlot0;
            int getRandom = (int)(Math.random() * 6);

            switch (getRandom){
                case 0:
                    if(i != 0) {
                        obButton[i] = (ImageButton) findViewById(ID + i);
                    }
                    else
                    {
                        obButton[i] = (ImageButton) findViewById(ID);
                    }
                        obButton[i].setTag("Freeze");
                        obButton[i].setBackgroundResource(R.drawable.freeze);

                    break;
                case 1:
                    if(i != 0) {
                        obButton[i] = (ImageButton) findViewById(ID + i);
                    }
                    else
                    {
                        obButton[i] = (ImageButton) findViewById(ID);
                    }
                    obButton[i].setTag("Freeze");
                    obButton[i].setBackgroundResource(R.drawable.freeze);
                    break;
                case 2:
                    if(i != 0) {
                        obButton[i] = (ImageButton) findViewById(ID + i);
                    }
                    else
                    {
                        obButton[i] = (ImageButton) findViewById(ID);
                    }
                    obButton[i].setTag("Freeze");
                    obButton[i].setBackgroundResource(R.drawable.freeze);
                    break;
                case 3:
                    if(i != 0) {
                        obButton[i] = (ImageButton) findViewById(ID + i);
                    }
                    else
                    {
                        obButton[i] = (ImageButton) findViewById(ID);
                    }
                    obButton[i].setTag("Freeze");
                    obButton[i].setBackgroundResource(R.drawable.freeze);
                    break;
                case 5:
                    if(i != 0) {
                        obButton[i] = (ImageButton) findViewById(ID + i);
                    }
                    else
                    {
                        obButton[i] = (ImageButton) findViewById(ID);
                    }
                    obButton[i].setTag("Freeze");
                    obButton[i].setBackgroundResource(R.drawable.freeze);
                    break;
            }


        }
    }
}
