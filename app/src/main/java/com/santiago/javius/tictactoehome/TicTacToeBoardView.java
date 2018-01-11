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
    private int myScreenWidth;
    private int myScreenHeight;
    private int myThirdOfScreen;
    private int myTwoThirdsOfScreen;
    private int myActionBarHeight;
    //private int[][] myBoardCoordinates = new int[8][3];
    private int[][] myBoardCoordinates;

    //move
    public int[][] getBoardCoordinates()
    {
        return myBoardCoordinates;
    }

    public TicTacToeBoardView(Context context)
    {
        super(context);

        //find height of action bar
        TypedValue tv = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true);
        myActionBarHeight = getResources().getDimensionPixelSize(tv.resourceId);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        myScreenWidth = getWidth();
        myScreenHeight = getHeight();
        myThirdOfScreen = myScreenWidth/3;
        myTwoThirdsOfScreen = myThirdOfScreen*2;

        drawBoard(canvas);

    }
    public void setBoardCoordinates()
    {
        myBoardCoordinates = new int[][]{{0,0,myThirdOfScreen,600},
                {myThirdOfScreen,0,myTwoThirdsOfScreen,600},
                {myTwoThirdsOfScreen,0,myScreenWidth,600},
                {0,600,myThirdOfScreen,900},
                {myThirdOfScreen,600,myTwoThirdsOfScreen,900},
                {myTwoThirdsOfScreen,600,myScreenWidth,900},
                {0,900,myThirdOfScreen,1200},
                {myThirdOfScreen,900,myTwoThirdsOfScreen,1200},
                {myTwoThirdsOfScreen,900,myScreenWidth,1200}};
    }

    private void drawBoard(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setStrokeWidth(3);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);

        //Draws Board
        //Vertical Lines
        canvas.drawLine(myScreenWidth/3, 0, myScreenWidth/3, 900, paint);
        canvas.drawLine((myScreenWidth/3)*2, 0,(myScreenWidth/3)*2, 900, paint);
        //Horizontal Lines
        canvas.drawLine(0,300,myScreenWidth,300,paint);
        canvas.drawLine(0,600,myScreenWidth,600,paint);
        canvas.drawLine(0,900,myScreenWidth,900,paint);
    }

    public int getScreenWidth()
    {
        return myScreenWidth;
    }
    public int getScreenHeight()
    {
        return myScreenHeight;
    }
    public int getThirdOfScreen()
    {
        return myThirdOfScreen;
    }
    public int getTwoThirdsOfScreen()
    {
        return myTwoThirdsOfScreen;
    }
    public int getActionBarHeight()
    {
        return myActionBarHeight;
    }

}// end of TicTacToeBoardView class