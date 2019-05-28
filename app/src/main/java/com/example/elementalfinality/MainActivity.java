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
    TextView cardDescription;
    ImageButton[] obButton = new ImageButton[5];
    String obBossCard;
    Player player1 = new Player(0, false, false, false, false, false);
    Player obBoss = new Player(0, false, false, false, false, false);

    int playerPoisonCount = 0;
    int bossPoisonCount = 0;
    int playerCurseCount = 0;
    int bossCurseCount = 0;

    int totalPlayerDamage = 0;
    int totalBossDamage = 0;
    int playerHealthPoints = player1.getHealth();
    int bossHealthPoints = obBoss.getHealth();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        player1.setHealth(50);
        obBoss.setHealth(50);
         playerHealthPoints = player1.getHealth();
         bossHealthPoints = obBoss.getHealth();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createCardField();
        playerHealth = (TextView)findViewById(R.id.currentHealth);
        cardDescription = (TextView)findViewById(R.id.cardDescription);

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

                playerHealth.setText(String.format("%s\n", playerHealthPoints));
                makeCard(obButton[0]);
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
                checkIfDead();
                playerHealth.setText(String.format("%s\n", playerHealthPoints));
                makeCard(obButton[1]);
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
                checkIfDead();
                playerHealth.setText(String.format("%s\n", playerHealthPoints));
                makeCard(obButton[2]);
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
                checkIfDead();
                playerHealth.setText(String.format("%s\n", playerHealthPoints));
                makeCard(obButton[3]);
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
                checkIfDead();
                playerHealth.setText(String.format("%s\n", playerHealthPoints));
                makeCard(obButton[4]);
            }
        });


    }


    private void checkIfDead() {
        if(player1.isDead(playerHealthPoints))
        {
            Intent playerDied = new Intent(this, GameDoneScreen.class);
            playerDied.putExtra("playerDied", 1);
            startActivity(playerDied);
        }
        if(obBoss.isDead(bossHealthPoints))
        {
            Intent playerDied = new Intent(this, GameDoneScreen.class);
            playerDied.putExtra("bossDied", 2);
            startActivity(playerDied);
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
                    obButton[i].setBackgroundResource(R.drawable.freeze);
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
                    obButton[i].setBackgroundResource(R.drawable.freeze);
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

              playerHealthPoints -= FIRE_DAMAGE;
              totalPlayerDamage += FIRE_DAMAGE;
              bossHealthPoints -= FIRE_DAMAGE;
              totalBossDamage += FIRE_DAMAGE;
              cardDescription.setText("You chose fire, the boss chose fire");
          }
          if(obButton2.getTag().equals("Freeze"))
          {
              int damageCalculation = FIRE_DAMAGE * ICE_MULTIPLIER;
              cardDescription.setText("You chose ice, the boss chose fire");

              bossHealthPoints -= damageCalculation;
              totalBossDamage += damageCalculation;
          }
          if(obButton2.getTag().equals("Poison"))
          {
              int damageCalculation = FIRE_DAMAGE;
              cardDescription.setText("You chose poison, the boss chose fire");
              obBoss.setPoisoned(true);
              playerHealthPoints -= damageCalculation;
          }
          if(obButton2.getTag().equals("Light"))
          {
              int damageCalculation = FIRE_DAMAGE;
              cardDescription.setText("You chose light, the boss chose fire");
              if(player1.isCursed() || player1.isPoisoned())
              {
                  player1.setCursed(false);
                  player1.setPoisoned(false);
                  playerHealthPoints += HEAL;
              }
              else
              {
                  playerHealthPoints += HEAL + 3;
              }
              playerHealthPoints -= damageCalculation;
              totalPlayerDamage += damageCalculation;
          }
          if(obButton2.getTag().equals("Dark"))
          {
              int damageCalculation = FIRE_DAMAGE;
              cardDescription.setText("You chose dark, the boss chose fire");
              playerHealthPoints -= damageCalculation;
              bossHealthPoints -= DARK_DAMAGE;
              player1.setCursed(true);
              obBoss.setCursed(true);
              totalBossDamage += DARK_DAMAGE;
              totalPlayerDamage += damageCalculation;

          }
          if(obButton2.getTag().equals("Wild"))
          {
              cardDescription.setText("You chose wild, the boss chose fire");
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

                playerHealthPoints -= FIRE_DAMAGE * ICE_MULTIPLIER;
                totalPlayerDamage += FIRE_DAMAGE * ICE_MULTIPLIER;
                cardDescription.setText("You chose fire, the boss chose ice");

            }
            if(obButton2.getTag().equals("Freeze"))
            {
                Toast.makeText(this, "Both players stunned", Toast.LENGTH_LONG).show();
            }
            if(obButton2.getTag().equals("Poison"))
            {
                obBoss.setPoisoned(true);
                obBoss.setStunned(true);
                cardDescription.setText("You chose poison, the boss chose ice");
            }
            if(obButton2.getTag().equals("Light"))
            {
                if(player1.isCursed() || player1.isPoisoned())
                {
                    player1.setCursed(false);
                    player1.setPoisoned(false);
                    playerHealthPoints += HEAL;
                    cardDescription.setText("You chose light, the boss chose ice");
                }
                else
                {
                    playerHealthPoints += HEAL + 3;
                }
                obBoss.setStunned(true);
            }
            if(obButton2.getTag().equals("Dark"))
            {
                playerHealthPoints -= DARK_DAMAGE;
                player1.setCursed(true);
                obBoss.setCursed(true);
                totalPlayerDamage += DARK_DAMAGE;
                cardDescription.setText("You chose dark, the boss chose ice");

            }
            if(obButton2.getTag().equals("Wild"))
            {
                player1.setUsedWild(true);
                makeCard(obButton2);
                cardDescription.setText("You chose wild, the boss chose ice");
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
                cardDescription.setText("You chose fire, the boss chose poison");
                bossHealthPoints -= FIRE_DAMAGE ;
                totalBossDamage += FIRE_DAMAGE ;
                player1.setPoisoned(true);

            }
            if(obButton2.getTag().equals("Freeze"))
            {
                cardDescription.setText("You chose ice, the boss chose poison");
                player1.setPoisoned(true);
                player1.setStunned(true);
            }
            if(obButton2.getTag().equals("Poison"))
            {
                cardDescription.setText("You chose poison, the boss chose poison");
                obBoss.setPoisoned(true);
                player1.setPoisoned(true);
            }
            if(obButton2.getTag().equals("Light"))
            {
                cardDescription.setText("You chose light, the boss chose poison");
                if(player1.isCursed() || player1.isPoisoned())
                {
                    player1.setCursed(false);
                    player1.setPoisoned(false);
                    playerHealthPoints += HEAL;
                }
                else
                {
                    playerHealthPoints += HEAL + 3;
                }
                player1.setPoisoned(true);
            }
            if(obButton2.getTag().equals("Dark"))
            {
                cardDescription.setText("You chose dark, the boss chose poison");
                playerHealthPoints -= DARK_DAMAGE;
                player1.setCursed(true);
                obBoss.setCursed(true);
                totalPlayerDamage += DARK_DAMAGE;

            }
            if(obButton2.getTag().equals("Wild"))
            {
                Toast.makeText(this, "Picked a wild card", Toast.LENGTH_SHORT).show();
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
            cardDescription.setText("You chose fire, the boss chose dark");
            bossHealthPoints -= FIRE_DAMAGE;
            playerHealthPoints -= DARK_DAMAGE;
            player1.setCursed(true);
            obBoss.setCursed(true);

            totalPlayerDamage += DARK_DAMAGE;
            totalBossDamage += FIRE_DAMAGE;

        }
        if(obButton2.getTag().equals("Freeze"))
        {
            cardDescription.setText("You chose ice, the boss chose dark");
            bossHealthPoints -= DARK_DAMAGE * ICE_MULTIPLIER;
            obBoss.setCursed(true);
            totalBossDamage += DARK_DAMAGE * ICE_MULTIPLIER;
        }
        if(obButton2.getTag().equals("Poison"))
        {
            cardDescription.setText("You chose poison, the boss chose dark");
            obBoss.setPoisoned(true);
            playerHealthPoints -= DARK_DAMAGE;
            player1.setCursed(true);
            obBoss.setCursed(true);

            totalPlayerDamage += DARK_DAMAGE;

        }
        if(obButton2.getTag().equals("Light"))
        {
            cardDescription.setText("You chose light, the boss chose dark");
            if(player1.isCursed() || player1.isPoisoned())
            {
                player1.setCursed(false);
                player1.setPoisoned(false);
                playerHealthPoints += HEAL;
            }
            else
            {
                playerHealthPoints += HEAL + 3;
            }


            player1.setCursed(true);
            playerHealthPoints -= DARK_DAMAGE;
            obBoss.setCursed(true);

            totalPlayerDamage += DARK_DAMAGE;
        }
        if(obButton2.getTag().equals("Dark"))
        {
            cardDescription.setText("You chose dark, the boss chose dark");
            playerHealthPoints -= DARK_DAMAGE;
            bossHealthPoints -= DARK_DAMAGE;
            player1.setCursed(true);
            obBoss.setCursed(true);

            totalPlayerDamage += DARK_DAMAGE;
            totalBossDamage += DARK_DAMAGE;

        }
        if(obButton2.getTag().equals("Wild"))
        {
            Toast.makeText(this, "Played a wild card", Toast.LENGTH_SHORT).show();
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
            cardDescription.setText("You chose fire, the boss chose light");
            if(obBoss.isCursed() || obBoss.isPoisoned())
            {
                obBoss.setCursed(false);
                obBoss.setPoisoned(false);
                bossHealthPoints += HEAL;
            }
            else
            {
                bossHealthPoints += HEAL + 3;
            }

            bossHealthPoints -= FIRE_DAMAGE;
            totalBossDamage += FIRE_DAMAGE;

        }
        if(obButton2.getTag().equals("Freeze"))
        {
            cardDescription.setText("You chose ice, the boss chose light");
            if(obBoss.isCursed() || obBoss.isPoisoned())
            {
                obBoss.setCursed(false);
                obBoss.setPoisoned(false);
                bossHealthPoints += HEAL;
            }
            else
            {
                bossHealthPoints += HEAL + 3;
            }
            player1.setStunned(true);
        }
        if(obButton2.getTag().equals("Poison"))
        {
            cardDescription.setText("You chose poison, the boss chose light");
            if(obBoss.isCursed() || obBoss.isPoisoned())
            {
                obBoss.setCursed(false);
                obBoss.setPoisoned(false);
                bossHealthPoints += HEAL;
            }
            else
            {
                bossHealthPoints += HEAL + 3;
            }

            obBoss.setPoisoned(true);

        }
        if(obButton2.getTag().equals("Light"))
        {
            cardDescription.setText("You chose light, the boss chose light");
            if(player1.isCursed() || player1.isPoisoned())
            {
                player1.setCursed(false);
                player1.setPoisoned(false);
                playerHealthPoints += HEAL;
            }
            else
            {
                playerHealthPoints += HEAL + 3;
            }

            if(obBoss.isCursed() || obBoss.isPoisoned())
            {
                obBoss.setCursed(false);
                obBoss.setPoisoned(false);
                bossHealthPoints += HEAL;
            }
            else
            {
                bossHealthPoints += HEAL + 3;
            }
        }
        if(obButton2.getTag().equals("Dark"))
        {
            cardDescription.setText("You chose dark, the boss chose light");
            if(obBoss.isCursed() || obBoss.isPoisoned())
            {
                obBoss.setCursed(false);
                obBoss.setPoisoned(false);
                bossHealthPoints += HEAL;
            }
            else
            {
                bossHealthPoints += HEAL + 3;
            }

            bossHealthPoints -= DARK_DAMAGE;
            totalBossDamage += DARK_DAMAGE;
            player1.setCursed(true);
            obBoss.setCursed(true);

        }
        if(obButton2.getTag().equals("Wild"))
        {
            Toast.makeText(this, "Played a wild card", Toast.LENGTH_SHORT).show();
            player1.setUsedWild(true);
            makeCard(obButton2);
            bossPicksLight(obButton2);
        }


        checkPoisonStatus();
        checkCurseStatus();
    }

    private void bossPicksWild(ImageButton obButton2)
    {
        Toast.makeText(this, "Played a wild card", Toast.LENGTH_SHORT).show();
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
                bossHealthPoints -= (3 + bossPoisonCount * 2);
            } else {
                bossHealthPoints -= (3 + bossPoisonCount);
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
                bossHealthPoints -= (totalBossDamage * 2);
            }
            else
            {
                bossHealthPoints -= totalBossDamage;
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
