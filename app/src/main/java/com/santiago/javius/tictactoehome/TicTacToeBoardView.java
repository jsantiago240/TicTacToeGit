package com.santiago.javius.tictactoehome;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
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
    //this array will hold the values of each tiles boundaries
    private int[][] myBoardCoordinates;

    final int LEFT_BOUNDARY = 0;
    final int TOP_BOUNDARY = 1;
    final int RIGHT_BOUNDARY = 2;
    final int BOTTOM_BOUNDARY = 3;

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

        //sets screen information
        myScreenWidth = getWidth();
        myScreenHeight = getHeight();
        myThirdOfScreen = myScreenWidth/3;
        myTwoThirdsOfScreen = myThirdOfScreen*2;

        //Draws tic tac toe board
        drawBoard(canvas);

        //TODO: Update according to board values

    }

    //Sets the board coordinates
    public void setBoardCoordinates()
    {
        //Board coordinates are set in this method because if they were initialized at runtime, the variables neccessary would not have yet been initialized
        //TODO// account for action bar
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

    //Draws Tic Tac Toe board on screen with blue lines
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

    public int[][] getBoardCoordinates()
    {
        return myBoardCoordinates;
    }

    //Checks to see if x&y(user's input coordinates) is within one of the tiles
    //if the user did click within one of the tiles coordinates, that tile is returned, otherwise a -1 is returned
    public int inputIsWithinATile(double x, double y)
    {
        setBoardCoordinates();

        for (int i=0;i<myBoardCoordinates.length;i++)
        {
            if(x>=myBoardCoordinates[i][LEFT_BOUNDARY]&&x<=myBoardCoordinates[i][RIGHT_BOUNDARY]&&y>=myBoardCoordinates[i][TOP_BOUNDARY]&&y<=myBoardCoordinates[i][BOTTOM_BOUNDARY])
            {
                return i;   //returns tile if within a tile
            }
        }

        return -1;//returns -1 if input doesn't fit in a tile
    }

    //Screen information accessors *****************************************************************
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