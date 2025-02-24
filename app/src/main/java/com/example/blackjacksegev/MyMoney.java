package com.example.blackjacksegev;

public class MyMoney {
    private String name;
    private int score;

    public MyMoney(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public MyMoney() {
    }

    // MUST generate getters and setters for the FireBase
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
