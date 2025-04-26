package com.example.blackjacksegev;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;

public class Card {
    private int number; // 1 - 13
    private int color;
    private int shape; // 1 - לבבות, 2 - מעויין, 3 - תלתן, 4 - עלה
    private Bitmap bitmap;
    private Context context;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public Card(int number, int color, int shape, Context context1) {
        this.number = number;
        this.color = color;
        this.shape = shape;
        this.context = context1;

        String color1 = "";
        if(color == Color.RED)
        {
            color1 = "r";
        }
        else
        {
            color1 = "b";
        }
        String resourceName = color1 + number + shape;

        int identifier = context.getResources().getIdentifier(resourceName, "drawable", context.getPackageName());
        if (identifier != 0) {
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), identifier);
        }

    }

    /*public String getId() {
        return id;
    }*/

    public int getNumber() {
        return number;
    }

    public Context getContext() {
        return context;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getShape() {
        return shape;
    }

    public void setShape(int shape) {
        this.shape = shape;
    }
    /*public void setUsed()
    {
        this.isUsed = true;
    }*/
}
