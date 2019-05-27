package com.example.elementalfinality;

public class Dark {
    boolean setCursed;
    int damage = 2;
    int damageMultiplier = 2;
    String name;

    public Dark(int damage, int damageMultiplier, boolean setCursed)
    {
        this.damage = damage;
        this.damageMultiplier = damageMultiplier;
        this.setCursed = setCursed;
        this.name = "Dark";
    }
}
