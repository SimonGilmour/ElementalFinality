package com.example.elementalfinality;

public class Poison {
    boolean setPoison;
    int damage = 3;
    int damageMultiplier[] = {1,2,3};
    String name;

    public Poison(int damage, int[] damageMultiplier, boolean setPoison)
    {
        this.damage = damage;
        this.damageMultiplier = damageMultiplier;
        this.setPoison = setPoison;
        this.name = "Poison";
    }
}
