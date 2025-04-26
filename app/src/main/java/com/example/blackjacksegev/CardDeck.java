package com.example.blackjacksegev;

import android.content.Context;
import android.graphics.Color;

import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {
    private ArrayList <Card> arrCard;
    private Context context;

    public CardDeck(Context context1) {
        arrCard = new ArrayList<Card>();
        context = context1;
        for(int i = 1; i < 14; i++)
        {
            arrCard.add(new Card(i, Color.RED, 1,context));
            arrCard.add(new Card(i, Color.RED, 2,context));
            arrCard.add(new Card(i, Color.BLACK, 3,context));
            arrCard.add(new Card(i, Color.BLACK, 4,context));
        }
        //shuffle -
        Collections.shuffle(arrCard);
    }
    public int getLength()
    {
        return arrCard.size();
    }


    public ArrayList<Card> getArrCard() {
        return arrCard;
    }

    public Card remover()
    {
        Card c1 = arrCard.remove(arrCard.size()-1);
        return c1;
    }
    public void add(Card card)
    {
        arrCard.add(card);
        Collections.shuffle(arrCard);
    }

}
