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
    //private Drawable drawable;

    //private boolean isUsed;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public Card(int number, int color, int shape, Context context1) {
        this.number = number;
        this.color = color;
        this.shape = shape;
        this.context = context1;

        if (this.number == 1 && this.color == Color.RED && this.shape == 1) { // Red Ace of Hearts
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.r11);
        } else if (this.number == 2 && this.color == Color.RED && this.shape == 1) { // Red 2 of Hearts
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.r21);
        }

        else if (this.number == 3 && this.color == Color.RED && this.shape == 1) { // Red 3 of Hearts
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.r31);
        } else if (this.number == 4 && this.color == Color.RED && this.shape == 1) { // Red 4 of Hearts
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.r41);
        } else if (this.number == 5 && this.color == Color.RED && this.shape == 1) { // Red 5 of Hearts
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.r51);
        } else if (this.number == 6 && this.color == Color.RED && this.shape == 1) { // Red 6 of Hearts
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.r61);
        } else if (this.number == 7 && this.color == Color.RED && this.shape == 1) { // Red 7 of Hearts
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.r71);
        } else if (this.number == 8 && this.color == Color.RED && this.shape == 1) { // Red 8 of Hearts
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.r81);
        } else if (this.number == 9 && this.color == Color.RED && this.shape == 1) { // Red 9 of Hearts
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.r91);
        } else if (this.number == 10 && this.color == Color.RED && this.shape == 1) { // Red 10 of Hearts
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.r101);
        } else if (this.number == 11 && this.color == Color.RED && this.shape == 1) { // Red Jack of Hearts
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.r111);
        } else if (this.number == 12 && this.color == Color.RED && this.shape == 1) { // Red Queen of Hearts
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.r121);
        } else if (this.number == 13 && this.color == Color.RED && this.shape == 1) { // Red King of Hearts
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.r131);
        } else if (this.number == 1 && this.color == Color.RED && this.shape == 2) { // Red Ace of Diamonds
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.r12);
        } else if (this.number == 2 && this.color == Color.RED && this.shape == 2) { // Red 2 of Diamonds
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.r22);
        } else if (this.number == 3 && this.color == Color.RED && this.shape == 2) { // Red 3 of Diamonds
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.r32);
        } else if (this.number == 4 && this.color == Color.RED && this.shape == 2) { // Red 4 of Diamonds
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.r42);
        } else if (this.number == 5 && this.color == Color.RED && this.shape == 2) { // Red 5 of Diamonds
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.r52);
        } else if (this.number == 6 && this.color == Color.RED && this.shape == 2) { // Red 6 of Diamonds
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.r62);
        } else if (this.number == 7 && this.color == Color.RED && this.shape == 2) { // Red 7 of Diamonds
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.r72);
        } else if (this.number == 8 && this.color == Color.RED && this.shape == 2) { // Red 8 of Diamonds
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.r82);
        } else if (this.number == 9 && this.color == Color.RED && this.shape == 2) { // Red 9 of Diamonds
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.r92);
        } else if (this.number == 10 && this.color == Color.RED && this.shape == 2) { // Red 10 of Diamonds
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.r102);
        } else if (this.number == 11 && this.color == Color.RED && this.shape == 2) { // Red Jack of Diamonds
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.r112);
        } else if (this.number == 12 && this.color == Color.RED && this.shape == 2) { // Red Queen of Diamonds
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.r122);
        } else if (this.number == 13 && this.color == Color.RED && this.shape == 2) { // Red King of Diamonds
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.r132);
        } else if (this.number == 1 && this.color == Color.BLACK && this.shape == 3) { // Black Ace of Clubs
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.b13);
        } else if (this.number == 2 && this.color == Color.BLACK && this.shape == 3) { // Black 2 of Clubs
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.b23);
        } else if (this.number == 3 && this.color == Color.BLACK && this.shape == 3) { // Black 3 of Clubs
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.b33);
        } else if (this.number == 4 && this.color == Color.BLACK && this.shape == 3) { // Black 4 of Clubs
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.b43);
        } else if (this.number == 5 && this.color == Color.BLACK && this.shape == 3) { // Black 5 of Clubs
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.b53);
        } else if (this.number == 6 && this.color == Color.BLACK && this.shape == 3) { // Black 6 of Clubs
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.b63);
        } else if (this.number == 7 && this.color == Color.BLACK && this.shape == 3) { // Black 7 of Clubs
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.b73);
        } else if (this.number == 8 && this.color == Color.BLACK && this.shape == 3) { // Black 8 of Clubs
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.b83);
        } else if (this.number == 9 && this.color == Color.BLACK && this.shape == 3) { // Black 9 of Clubs
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.b93);
        } else if (this.number == 10 && this.color == Color.BLACK && this.shape == 3) { // Black 10 of Clubs
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.b103);
        } else if (this.number == 11 && this.color == Color.BLACK && this.shape == 3) { // Black Jack of Clubs
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.b113);
        } else if (this.number == 12 && this.color == Color.BLACK && this.shape == 3) { // Black Queen of Clubs
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.b123);
        } else if (this.number == 13 && this.color == Color.BLACK && this.shape == 3) { // Black King of Clubs
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.b133);
        } else if (this.number == 1 && this.color == Color.BLACK && this.shape == 4) { // Black Ace of Spades
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.b14);
        } else if (this.number == 2 && this.color == Color.BLACK && this.shape == 4) { // Black 2 of Spades
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.b24);
        } else if (this.number == 3 && this.color == Color.BLACK && this.shape == 4) { // Black 3 of Spades
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.b34);
        } else if (this.number == 4 && this.color == Color.BLACK && this.shape == 4) { // Black 4 of Spades
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.b44);
        } else if (this.number == 5 && this.color == Color.BLACK && this.shape == 4) { // Black 5 of Spades
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.b54);
        } else if (this.number == 6 && this.color == Color.BLACK && this.shape == 4) { // Black 6 of Spades
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.b64);
        } else if (this.number == 7 && this.color == Color.BLACK && this.shape == 4) { // Black 7 of Spades
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.b74);
        } else if (this.number == 8 && this.color == Color.BLACK && this.shape == 4) { // Black 8 of Spades
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.b84);
        } else if (this.number == 9 && this.color == Color.BLACK && this.shape == 4) { // Black 9 of Spades
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.b94);
        } else if (this.number == 10 && this.color == Color.BLACK && this.shape == 4) { // Black 10 of Spades
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.b104);
        } else if (this.number == 11 && this.color == Color.BLACK && this.shape == 4) { // Black Jack of Spades
        this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.b114);
        } else if (this.number == 12 && this.color == Color.BLACK && this.shape == 4) { // Black Queen of Spades
        this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.b124);
        } else if (this.number == 13 && this.color == Color.BLACK && this.shape == 4) { // Black King of Spades
        this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.b134);
        }

        /*if(color == Color.RED)
        {
            this.id = "r" + shape + number;
            id = R.drawable.b13;
        }
        else
        {
            this.id = "b" + shape + number;
        }*/

        //Bitmap bitmap = BitmapFactory.decodeResource(context.context.getResources(),id);
        //this.isUsed = false;
        //this.drawable = ContextCompat.getDrawable(context, R.drawable.jack_of_diamonds2);//?
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

    public void draw(Canvas canvas)
    {


        canvas.drawBitmap(bitmap,10,10,null);

    }
    public void setShape(int shape) {
        this.shape = shape;
    }
    /*public void setUsed()
    {
        this.isUsed = true;
    }*/
}
