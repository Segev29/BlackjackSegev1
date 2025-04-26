package com.example.blackjacksegev;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class MiniGameView extends View {
    private ArrayList<Card> player;
    public MiniGameView(Context context, ArrayList<Card> player) {
        super(context);
        this.player = player;
    }

    public void setPlayer(ArrayList<Card> player) {
        this.player = player;
        invalidate();
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        Bitmap cardontable;
        Bitmap cardontable2;
        Paint paint = new Paint();
        cardontable = Bitmap.createScaledBitmap(player.get(0).getBitmap(), canvas.getWidth()/2 - 20, canvas.getHeight(), true);
        cardontable2 = Bitmap.createScaledBitmap(player.get(1).getBitmap(), canvas.getWidth()/2 - 20, canvas.getHeight(), true);
        canvas.drawBitmap(cardontable,0,0,paint);
        canvas.drawBitmap(cardontable2,canvas.getWidth()/2+20,0,paint);
    }
}
