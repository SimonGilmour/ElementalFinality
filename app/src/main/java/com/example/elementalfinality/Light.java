package com.example.elementalfinality;

public class Light {
    boolean playedDamage;
    int damage = 0;
    int healMultiplier = 2;
    int heal = 6;
    String name;

    public Light(int damage, int damageMultiplier, boolean playedDamage, int heal)
    {
        this.damage = damage;
        this.playedDamage = playedDamage;
        this.heal = heal;
        this.name = "Light";
    }
}
