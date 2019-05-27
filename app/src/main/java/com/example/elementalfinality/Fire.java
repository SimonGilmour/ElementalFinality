package com.example.elementalfinality;

public class Fire {
    boolean playedDamage;
    int damage = 5;
    int damageMultiplier = 2;
    String name;

    public Fire(int damage, int damageMultiplier, boolean playedDamage)
    {
        this.damage = damage;
        this.damageMultiplier = damageMultiplier;
        this.playedDamage = playedDamage;
        this.name = "Fire";
    }
}
