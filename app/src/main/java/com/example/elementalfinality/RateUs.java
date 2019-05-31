package com.example.elementalfinality;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RateUs extends AppCompatActivity implements View.OnClickListener {

    Button obSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us);
        obSend = (Button)findViewById(R.id.btnSendRate);
        obSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if(view.equals(obSend))
        {
            Toast.makeText(this, "Rating message sent", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, MainMenu.class);
            startActivity(i);
        }
    }

}
