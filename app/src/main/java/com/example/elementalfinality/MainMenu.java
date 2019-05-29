package com.example.elementalfinality;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainMenu extends AppCompatActivity {

    Button obStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        obStart = (Button)findViewById(R.id.btnStartGame);

        obStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent goToGame = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(goToGame);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if(id == R.id.viewScoreboard)
        {
            return true;
        }
        if(id == R.id.resetScoreboard)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
