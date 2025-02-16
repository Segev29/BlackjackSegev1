package com.example.blackjacksegev;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.blackjacksegev.Card;

import java.util.ArrayList;

public class GameView extends View {
    private ArrayList<Card> player;
    private ArrayList<Card> computer;
    private Bitmap bitmap;
    public GameView(Context context,ArrayList<Card> player,ArrayList<Card> computer) {
        super(context);
        this.player = player;
        this.computer = computer;
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        int height = canvas.getHeight();
        int width = canvas.getWidth();
        int width2 = 0;
        Paint paint = new Paint();
        Bitmap cardontable;
        for (int i = 0; i < player.size(); i++) {
            cardontable = Bitmap.createScaledBitmap(player.get(i).getBitmap(), width/player.size(), width/player.size(), true);
            canvas.drawBitmap(cardontable,width2,height/2,paint);
            width2 = width2 + width/player.size();

        }
        width2 = 0;
        for (int i = 0; i < computer.size(); i++) {
            cardontable = Bitmap.createScaledBitmap(computer.get(i).getBitmap(), width/computer.size(), width/computer.size(), true);
            canvas.drawBitmap(cardontable,width2,0,paint);
            width2 = width2 + width/player.size();
        }

    }
}