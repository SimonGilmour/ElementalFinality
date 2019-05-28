package com.example.elementalfinality;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView playerHealth;
    ImageButton[] obButton = new ImageButton[5];
    String obBossCard;
    Player player1 = new Player(30, false, false, false, false, false);
    Player obBoss = new Player(50, false, false, false, false, false);

    int playerPoisonCount = 0;
    int bossPoisonCount = 0;
    int playerCurseCount = 0;
    int bossCurseCount = 0;

    int totalPlayerDamage = 0;
    int totalBossDamage = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createCardField();
        playerHealth = (TextView)findViewById(R.id.currentHealth);

        View obView = new View(getApplicationContext());
        obView.setRotationY(180f);


        obButton[0].setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                generateBossCard();
                switch (obBossCard)
                {
                    case "Freeze":
                        bossPicksFreeze(obButton[0]);
                        break;
                    case "Fire":
                        bossPicksFire(obButton[0]);
                            break;
                    case "Poison":
                        bossPicksPoison(obButton[0]);
                        break;
                    case "Dark":
                        bossPicksDark(obButton[0]);
                        break;
                    case "Light":
                        bossPicksLight(obButton[0]);
                        break;
                    case "Wild":
                        bossPicksWild(obButton[0]);
                        break;

                }

                checkIfDead();
                obButton[0].setTag("Empty");
                obButton[0].setBackgroundResource(R.drawable.ic_launcher_background);
            }
        });



        obButton[1].setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                generateBossCard();
                switch (obBossCard)
                {
                    case "Freeze":
                        bossPicksFreeze(obButton[1]);
                        break;
                    case "Fire":
                        bossPicksFire(obButton[1]);
                        break;
                    case "Poison":
                        bossPicksPoison(obButton[1]);
                        break;
                    case "Dark":
                        bossPicksDark(obButton[1]);
                        break;
                    case "Light":
                        bossPicksLight(obButton[1]);
                        break;
                    case "Wild":
                        bossPicksWild(obButton[1]);
                        break;

                }
            }
        });



        obButton[2].setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                generateBossCard();
                switch (obBossCard)
                {
                    case "Freeze":
                        bossPicksFreeze(obButton[2]);
                        break;
                    case "Fire":
                        bossPicksFire(obButton[2]);
                        break;
                    case "Poison":
                        bossPicksPoison(obButton[2]);
                        break;
                    case "Dark":
                        bossPicksDark(obButton[2]);
                        break;
                    case "Light":
                        bossPicksLight(obButton[2]);
                        break;
                    case "Wild":
                        bossPicksWild(obButton[2]);
                        break;

                }
            }
        });



        obButton[3].setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                generateBossCard();
                switch (obBossCard)
                {
                    case "Freeze":
                        bossPicksFreeze(obButton[3]);
                        break;
                    case "Fire":
                        bossPicksFire(obButton[3]);
                        break;
                    case "Poison":
                        bossPicksPoison(obButton[3]);
                        break;
                    case "Dark":
                        bossPicksDark(obButton[3]);
                        break;
                    case "Light":
                        bossPicksLight(obButton[3]);
                        break;
                    case "Wild":
                        bossPicksWild(obButton[3]);
                        break;

                }
            }
        });



        obButton[4].setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                generateBossCard();
                switch (obBossCard)
                {
                    case "Freeze":
                        bossPicksFreeze(obButton[4]);
                        break;
                    case "Fire":
                        bossPicksFire(obButton[4]);
                        break;
                    case "Poison":
                        bossPicksPoison(obButton[4]);
                        break;
                    case "Dark":
                        bossPicksDark(obButton[4]);
                        break;
                    case "Light":
                        bossPicksLight(obButton[4]);
                        break;
                    case "Wild":
                        bossPicksWild(obButton[4]);
                        break;

                }
            }
        });


    }

    private void checkIfDead() {
        if(player1.isDead(player1.health))
        {
            Intent playerDied = new Intent(this, game_over.class);
            startActivity(playerDied);
        }
        if(obBoss.isDead(obBoss.health))
        {

        }
    }

    private void generateBossCard() {
        int getRandom = (int) (Math.random() * 6);
        switch (getRandom) {
            case 0:
                obBossCard = "Freeze";
                break;
            case 1:
                obBossCard = "Fire";
                break;
            case 2:

                obBossCard = "Poison";
                break;
            case 3:
                obBossCard = "Light";
                break;
            case 4:
                obBossCard = "Dark";
                break;
            case 5:
                obBossCard = "Wild";
                break;

        }
    }

    private void createCardField() {



        for(int i = 0; i < 5; i++)
        {
            final int ID = R.id.cardSlot0;
            int getRandom = (int)(Math.random() * 6);
            if(i != 0) {
                obButton[i] = (ImageButton) findViewById(ID + i);
                Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                obButton[i].startAnimation(rotate);
            }
            else
            {
                obButton[i] = (ImageButton) findViewById(ID);
                Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                obButton[i].startAnimation(rotate);
            }

            switch (getRandom){
                case 0:

                    obButton[i].setTag("Freeze");
                    obButton[i].setBackgroundResource(R.drawable.freeze);
                    break;
                case 1:

                    obButton[i].setTag("Fire");
                    obButton[i].setBackgroundResource(R.drawable.fire);
                    break;
                case 2:

                    obButton[i].setTag("Poison");
                    obButton[i].setBackgroundResource(R.drawable.freeze);
                    break;
                case 3:

                    obButton[i].setTag("Light");
                    obButton[i].setBackgroundResource(R.drawable.freeze);
                    break;
                case 4:
                    obButton[i].setTag("Dark");
                    obButton[i].setBackgroundResource(R.drawable.dark);
                    break;
                case 5:
                    obButton[i].setTag("Wild");
                    obButton[i].setBackgroundResource(R.drawable.freeze);
                    break;
            }


        }
    }

    private void bossPicksFire(ImageButton obButton2)
    {

      totalPlayerDamage = 0;
      totalBossDamage = 0;
      int FIRE_DAMAGE = 5;
      int DARK_DAMAGE = 2;
      int ICE_MULTIPLIER = 2;
      int HEAL = 3;


      if(player1.isUsedWild())
      {
          FIRE_DAMAGE = 10;
          ICE_MULTIPLIER = 3;
          DARK_DAMAGE = 4;
          HEAL = 6;

      }

          if(obButton2.getTag().equals("Fire"))
          {

              player1.health -= FIRE_DAMAGE;
              totalPlayerDamage += FIRE_DAMAGE;
              obBoss.health -= FIRE_DAMAGE;
              totalBossDamage += FIRE_DAMAGE;
          }
          if(obButton2.getTag().equals("Freeze"))
          {
              int damageCalculation = FIRE_DAMAGE * ICE_MULTIPLIER;


              obBoss.health -= damageCalculation;
              totalBossDamage += damageCalculation;
          }
          if(obButton2.getTag().equals("Poison"))
          {
              int damageCalculation = FIRE_DAMAGE;
              obBoss.setPoisoned(true);
              player1.health -= damageCalculation;
          }
          if(obButton2.getTag().equals("Light"))
          {
              int damageCalculation = FIRE_DAMAGE;
              if(player1.isCursed() || player1.isPoisoned())
              {
                  player1.setCursed(false);
                  player1.setPoisoned(false);
                  player1.health += HEAL;
              }
              else
              {
                  player1.health += HEAL + 3;
              }
              player1.health -= damageCalculation;
              totalPlayerDamage += damageCalculation;
          }
          if(obButton2.getTag().equals("Dark"))
          {
              int damageCalculation = FIRE_DAMAGE;

              player1.health -= damageCalculation;
              obBoss.health -= DARK_DAMAGE;
              player1.setCursed(true);
              obBoss.setCursed(true);
              totalBossDamage += DARK_DAMAGE;
              totalPlayerDamage += damageCalculation;

          }
          if(obButton2.getTag().equals("Wild"))
          {
              player1.setUsedWild(true);
              makeCard(obButton2);
              bossPicksFire(obButton2);
          }


      checkPoisonStatus();
      checkCurseStatus();
  }

    private void makeCard(ImageButton obButton2) {
        int getRandom = (int)(Math.random() * 6);
        switch (getRandom){
            case 0:

                obButton2.setTag("Freeze");
                obButton2.setBackgroundResource(R.drawable.freeze);
                break;
            case 1:

                obButton2.setTag("Fire");
                obButton2.setBackgroundResource(R.drawable.freeze);
                break;
            case 2:

                obButton2.setTag("Poison");
                obButton2.setBackgroundResource(R.drawable.freeze);
                break;
            case 3:

                obButton2.setTag("Light");
                obButton2.setBackgroundResource(R.drawable.freeze);
                break;
            case 4:
                obButton2.setTag("Dark");
                obButton2.setBackgroundResource(R.drawable.freeze);
                break;
            case 5:
                obButton2.setTag("Wild");
                obButton2.setBackgroundResource(R.drawable.freeze);
                break;
        }

    }

    private void bossPicksFreeze(ImageButton obButton2)
    {

        totalPlayerDamage = 0;
        totalBossDamage = 0;

        int FIRE_DAMAGE = 5;
        int DARK_DAMAGE = 2;
        int ICE_MULTIPLIER = 2;
        int HEAL = 3;



        if(player1.isUsedWild())
        {
            FIRE_DAMAGE = 10;
            ICE_MULTIPLIER = 3;
            DARK_DAMAGE = 4;
            HEAL = 6;

        }

            if(obButton2.getTag().equals("Fire"))
            {

                player1.health -= FIRE_DAMAGE * ICE_MULTIPLIER;
                totalPlayerDamage += FIRE_DAMAGE * ICE_MULTIPLIER;
            }
            if(obButton2.getTag().equals("Freeze"))
            {
                Toast.makeText(this, "Both players stunned", Toast.LENGTH_LONG).show();
            }
            if(obButton2.getTag().equals("Poison"))
            {
                obBoss.setPoisoned(true);
                obBoss.setStunned(true);
            }
            if(obButton2.getTag().equals("Light"))
            {
                if(player1.isCursed() || player1.isPoisoned())
                {
                    player1.setCursed(false);
                    player1.setPoisoned(false);
                    player1.health += HEAL;
                }
                else
                {
                    player1.health += HEAL + 3;
                }
                obBoss.setStunned(true);
            }
            if(obButton2.getTag().equals("Dark"))
            {
                player1.health -= DARK_DAMAGE;
                player1.setCursed(true);
                obBoss.setCursed(true);
                totalPlayerDamage += DARK_DAMAGE;

            }
            if(obButton2.getTag().equals("Wild"))
            {
                player1.setUsedWild(true);
                makeCard(obButton2);
                bossPicksFreeze(obButton2);
            }


        checkPoisonStatus();
        checkCurseStatus();
    }

    private void bossPicksPoison(ImageButton obButton2)
    {

        totalPlayerDamage = 0;
        totalBossDamage = 0;

        int FIRE_DAMAGE = 5;
        int DARK_DAMAGE = 2;
        int ICE_MULTIPLIER = 2;
        int HEAL = 3;

        if(player1.isUsedWild())
        {
            FIRE_DAMAGE = 10;
            ICE_MULTIPLIER = 3;
            DARK_DAMAGE = 4;
            HEAL = 6;

        }

            if(obButton2.getTag().equals("Fire"))
            {

                player1.health -= FIRE_DAMAGE * ICE_MULTIPLIER;
                totalPlayerDamage += FIRE_DAMAGE * ICE_MULTIPLIER;
            }
            if(obButton2.getTag().equals("Freeze"))
            {
                Toast.makeText(this, "Both players stunned", Toast.LENGTH_LONG).show();
            }
            if(obButton2.getTag().equals("Poison"))
            {
                obBoss.setPoisoned(true);
                obBoss.setStunned(true);
            }
            if(obButton2.getTag().equals("Light"))
            {
                if(player1.isCursed() || player1.isPoisoned())
                {
                    player1.setCursed(false);
                    player1.setPoisoned(false);
                    player1.health += HEAL;
                }
                else
                {
                    player1.health += HEAL + 3;
                }
                obBoss.setStunned(true);
            }
            if(obButton2.getTag().equals("Dark"))
            {
                player1.health -= DARK_DAMAGE;
                player1.setCursed(true);
                obBoss.setCursed(true);
                totalPlayerDamage += DARK_DAMAGE;

            }
            if(obButton2.getTag().equals("Wild"))
            {
                player1.setUsedWild(true);
                makeCard(obButton2);
                bossPicksFreeze(obButton2);
            }


        checkPoisonStatus();
        checkCurseStatus();
    }


    private void bossPicksDark(ImageButton obButton2)
    {
        totalPlayerDamage = 0;
        totalBossDamage = 0;

        int FIRE_DAMAGE = 5;
        int DARK_DAMAGE = 2;
        int ICE_MULTIPLIER = 2;
        int HEAL = 3;

        if(player1.isUsedWild())
        {
            FIRE_DAMAGE = 10;
            ICE_MULTIPLIER = 3;
            DARK_DAMAGE = 4;
            HEAL = 6;

        }

        if(obButton2.getTag().equals("Fire"))
        {
            obBoss.health -= FIRE_DAMAGE;
            player1.health -= DARK_DAMAGE;
            player1.setCursed(true);
            obBoss.setCursed(true);

            totalPlayerDamage += DARK_DAMAGE;
            totalBossDamage += FIRE_DAMAGE;

        }
        if(obButton2.getTag().equals("Freeze"))
        {
            obBoss.setStunned(true);
            obBoss.health -= DARK_DAMAGE * ICE_MULTIPLIER;
            obBoss.setCursed(true);
            totalBossDamage += DARK_DAMAGE * ICE_MULTIPLIER;
        }
        if(obButton2.getTag().equals("Poison"))
        {
            obBoss.setPoisoned(true);
            player1.health -= DARK_DAMAGE;
            player1.setCursed(true);
            obBoss.setCursed(true);

            totalPlayerDamage += DARK_DAMAGE;

        }
        if(obButton2.getTag().equals("Light"))
        {
            if(player1.isCursed() || player1.isPoisoned())
            {
                player1.setCursed(false);
                player1.setPoisoned(false);
                player1.health += HEAL;
            }
            else
            {
                player1.health += HEAL + 3;
            }


            player1.setCursed(true);
            player1.health -= DARK_DAMAGE;
            obBoss.setCursed(true);

            totalPlayerDamage += DARK_DAMAGE;
        }
        if(obButton2.getTag().equals("Dark"))
        {
            player1.health -= DARK_DAMAGE;
            obBoss.health -= DARK_DAMAGE;
            player1.setCursed(true);
            obBoss.setCursed(true);

            totalPlayerDamage += DARK_DAMAGE;
            totalBossDamage += DARK_DAMAGE;

        }
        if(obButton2.getTag().equals("Wild"))
        {
            player1.setUsedWild(true);
            makeCard(obButton2);
            bossPicksDark(obButton2);
        }


        checkPoisonStatus();
        checkCurseStatus();
    }

    private void bossPicksLight(ImageButton obButton2)
    {
        totalPlayerDamage = 0;
        totalBossDamage = 0;

        int FIRE_DAMAGE = 5;
        int DARK_DAMAGE = 2;
        int ICE_MULTIPLIER = 2;
        int HEAL = 3;

        if(player1.isUsedWild())
        {
            FIRE_DAMAGE = 10;
            ICE_MULTIPLIER = 3;
            DARK_DAMAGE = 4;
            HEAL = 6;

        }

        if(obButton2.getTag().equals("Fire"))
        {
            if(obBoss.isCursed() || obBoss.isPoisoned())
            {
                obBoss.setCursed(false);
                obBoss.setPoisoned(false);
                obBoss.health += HEAL;
            }
            else
            {
                obBoss.health += HEAL + 3;
            }

            obBoss.health -= FIRE_DAMAGE;
            totalBossDamage += FIRE_DAMAGE;

        }
        if(obButton2.getTag().equals("Freeze"))
        {
            if(obBoss.isCursed() || obBoss.isPoisoned())
            {
                obBoss.setCursed(false);
                obBoss.setPoisoned(false);
                obBoss.health += HEAL;
            }
            else
            {
                obBoss.health += HEAL + 3;
            }
            player1.setStunned(true);
        }
        if(obButton2.getTag().equals("Poison"))
        {
            if(obBoss.isCursed() || obBoss.isPoisoned())
            {
                obBoss.setCursed(false);
                obBoss.setPoisoned(false);
                obBoss.health += HEAL;
            }
            else
            {
                obBoss.health += HEAL + 3;
            }

            obBoss.setPoisoned(true);

        }
        if(obButton2.getTag().equals("Light"))
        {
            if(player1.isCursed() || player1.isPoisoned())
            {
                player1.setCursed(false);
                player1.setPoisoned(false);
                player1.health += HEAL;
            }
            else
            {
                player1.health += HEAL + 3;
            }

            if(obBoss.isCursed() || obBoss.isPoisoned())
            {
                obBoss.setCursed(false);
                obBoss.setPoisoned(false);
                obBoss.health += HEAL;
            }
            else
            {
                obBoss.health += HEAL + 3;
            }
        }
        if(obButton2.getTag().equals("Dark"))
        {
            if(obBoss.isCursed() || obBoss.isPoisoned())
            {
                obBoss.setCursed(false);
                obBoss.setPoisoned(false);
                obBoss.health += HEAL;
            }
            else
            {
                obBoss.health += HEAL + 3;
            }

            obBoss.health -= DARK_DAMAGE;
            totalBossDamage += DARK_DAMAGE;
            player1.setCursed(true);
            obBoss.setCursed(true);

        }
        if(obButton2.getTag().equals("Wild"))
        {
            player1.setUsedWild(true);
            makeCard(obButton2);
            bossPicksLight(obButton2);
        }


        checkPoisonStatus();
        checkCurseStatus();
    }

    private void bossPicksWild(ImageButton obButton2)
    {
       obBoss.setUsedWild(true);
        generateBossCard();
        switch (obBossCard)
        {
            case "Freeze":
                bossPicksFreeze(obButton2);
                break;
            case "Fire":
                bossPicksFire(obButton2);
                break;
            case "Poison":
                bossPicksPoison(obButton2);
                break;
            case "Dark":
                bossPicksDark(obButton2);
                break;
            case "Light":
                bossPicksLight(obButton2);
                break;
            case "Wild":
                break;

        }
    }

    private void checkPoisonStatus()
    {
        if(totalBossDamage > 0 && obBoss.isPoisoned()) {
            if (player1.isUsedWild()) {
                obBoss.health -= (3 + bossPoisonCount * 2);
            } else {
                obBoss.health -= (3 + bossPoisonCount);
            }
        }
        else
        {
            if(obBoss.isPoisoned()) {
                bossPoisonCount++;
            }
        }

        if(bossPoisonCount > 3) {
            obBoss.setPoisoned(false);
            bossPoisonCount = 0;
        }
    }

    private void checkCurseStatus()
    {
        if(totalBossDamage > 0 && obBoss.isCursed())
        {
            if(player1.isUsedWild())
            {
                obBoss.health -= (totalBossDamage * 2);
            }
            else
            {
                obBoss.health -= totalBossDamage;
            }

        }
        else
        {
            if(obBoss.isCursed()) {
                bossCurseCount++;
            }
        }

        if(bossCurseCount > 2)
        {
            obBoss.setCursed(false);
            bossCurseCount = 0;
        }
    }
}
