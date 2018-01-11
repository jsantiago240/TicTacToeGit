package com.santiago.javius.tictactoehome;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by Javius on 1/11/2018.
 */

public class TicTacToeBoardView extends View
{
    int screenWidth;
    //int screenHeight = getHeight();
    int thirdOfScreen;
    int twoThirdsOfScreen;

    int actionBarHeight;

    public TicTacToeBoardView(Context context)
    {
        super(context);
        //Height of action bar
        TypedValue tv = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true);
        actionBarHeight = getResources().getDimensionPixelSize(tv.resourceId);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        screenWidth = getWidth();
        thirdOfScreen = screenWidth/3;
        twoThirdsOfScreen = thirdOfScreen*2;

        drawBoard(canvas);
    }
    private void drawBoard(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setStrokeWidth(3);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);

        //Draws Board
        //Vertical Lines
        canvas.drawLine(screenWidth/3, 0, screenWidth/3, 900, paint);
        canvas.drawLine((screenWidth/3)*2, 0,(screenWidth/3)*2, 900, paint);
        //Horizontal Lines
        canvas.drawLine(0,300,screenWidth,300,paint);
        canvas.drawLine(0,600,screenWidth,600,paint);
        canvas.drawLine(0,900,screenWidth,900,paint);
    }
}// end of TicTacToeBoardView class