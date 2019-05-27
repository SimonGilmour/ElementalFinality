package com.example.elementalfinality;

public class Player {

    public int health;

    public boolean frozen;
    public boolean cursed;
    public boolean poisoned;




    public boolean isStunned() {
        return stunned;
    }

    public boolean stunned;
    public boolean usedWild;


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    public boolean isFrozen() {
        return frozen;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    public boolean isCursed() {
        return cursed;
    }

    public void setCursed(boolean cursed) {
        this.cursed = cursed;
    }

    public boolean isPoisoned() {
        return poisoned;
    }

    public void setPoisoned(boolean poisoned) {
        this.poisoned = poisoned;
    }

    public boolean isNoDamage() {
        return stunned;
    }

    public void setStunned(boolean stunned) {
        this.stunned = stunned;
    }

    public boolean isUsedWild() {
        return usedWild;
    }

    public void setUsedWild(boolean usedWild) {
        this.usedWild = usedWild;
    }


    public Player(int health, boolean frozen,
                  boolean cursed, boolean poisoned, boolean stunned, boolean usedWild)
    {
        this.health = health;
        this.frozen = frozen;
        this.cursed = cursed;
        this.poisoned = poisoned;
        this.stunned = stunned;
        this.usedWild = usedWild;

    }

    public boolean isDead(int health)
    {
        if(health <= 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("%s\n", this.health);
    }
}
