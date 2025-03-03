package com.example.blackjacksegev;

public class MyMoney {

    private int score;

    public MyMoney(int score) {
        this.score = score;
    }

    public MyMoney() {
    }

    // MUST generate getters and setters for the FireBase

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
