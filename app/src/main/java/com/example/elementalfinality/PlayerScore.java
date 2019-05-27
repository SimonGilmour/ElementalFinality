package com.example.elementalfinality;

public class PlayerScore {

    public long id;

    public String name = "";
    public int score = 0;

    public PlayerScore(String name, int score)
    {
        this.id = -1;
        this.name = name;
        this.score = score;
    }

    public PlayerScore(long id, String name, int score)
    {
        this(name, score);
        this.id = id;
    }
}
