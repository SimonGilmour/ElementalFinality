package com.example.elementalfinality;

import android.widget.ImageButton;

public class Freeze{
    boolean setFreeze;
    int damage = 0;
    int damageMultiplier = 2;
    String name;
    ImageButton imgFreeze;

    public Freeze(int damage, int damageMultiplier, boolean setFreeze)
    {
        this.damage = damage;
        this.damageMultiplier = damageMultiplier;
        this.setFreeze = setFreeze;
       this.name = "Freeze";
       imgFreeze.setBackgroundResource(R.drawable.freeze);
    }
}
