package com.santiago.javius.tictactoehome;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

/**
 * Created by Javius Santiago on 12/4/17.
 */

public class TicTacToeBoard
{
    //private String myBoardArr[][] = {{"","",""},{"","",""},{"","",""}};  // tic tac toe board
    private String myBoardArr[] = {"","","","","","","","",""};
    //                              0, 1, 2, 3, 4, 5, 6, 7, 8
    int myBoardCoordinates[][];
    private int myWidth;
    private int myHeight;
    private Canvas myCanvas;
    private Paint xPlayerPaint = new Paint();

    private final int thirdOfScreenWidth = getThirdOfScreenWidth();
    private final int twoThirdsOfScreenWidth = getTwoThirdsOfScreenWidth();

    //left, top, right, bottom
    //   0,   1,     2,      3
    //private int myBoardCoordinates[][] = {{0,0,thirdOfScreenWidth,600},{thirdOfScreenWidth,0,twoThirdsOfScreenWidth,600}};
    /*private int myBoardCoordinates[][] = {{0,0,thirdOfScreenWidth,600},
    {thirdOfScreenWidth,0,twoThirdsOfScreenWidth,600},
    {twoThirdsOfScreenWidth,0,myWidth,600},
    {0,600,thirdOfScreenWidth,900},
    {thirdOfScreenWidth,600,twoThirdsOfScreenWidth,900},
    {twoThirdsOfScreenWidth,600,myWidth,900},
    {0,900,thirdOfScreenWidth,1200},
    {thirdOfScreenWidth,900,twoThirdsOfScreenWidth,1200},
    {twoThirdsOfScreenWidth,900,myWidth,1200}};*/

    public void setCoordinates()
    {
        int boardCoordinates[][] = {{0,0,thirdOfScreenWidth,600},                    //one (4,7)
                {thirdOfScreenWidth,0,twoThirdsOfScreenWidth,600},     //two (5,8)
                {twoThirdsOfScreenWidth,0,myWidth,600},       //three(6,9)
                {0,600,thirdOfScreenWidth,900},                   //four (1,7)
                {thirdOfScreenWidth,600,twoThirdsOfScreenWidth,900},   //five (2,8)
                {twoThirdsOfScreenWidth,600,myWidth,900},     //six(3,9)
                {0,900,thirdOfScreenWidth,1200},                  //seven(1,4)
                {thirdOfScreenWidth,900,twoThirdsOfScreenWidth,1200},  //eight(2,5)
                {twoThirdsOfScreenWidth,900,myWidth,1200}};//nine(3,6)
    }
    public int[][] getCoordinateArray()
    {
        return myBoardCoordinates;
    }
    //Default Constructor
    public TicTacToeBoard()
    {

    }

    public String[] getBoardArray()
    {
        return myBoardArr;
    }


    public void placeGamePiece(int tile, String piece)
    {
        myBoardArr[tile] = piece;
       // drawGamePiece(tile,piece);
    }

    public boolean isSpaceEmpty(int tile)
    {
        if (myBoardArr[tile].equals(""))
        {
            return true;
        }
        return false;

    }
    //draws tic tac toe board
    public void drawBoard()
    {
        Paint paint = new Paint();
        paint.setStrokeWidth(3);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);

        //Vertical Lines
        myCanvas.drawLine(myWidth/3, 0, myWidth/3, 900, paint);
        myCanvas.drawLine((myWidth/3)*2, 0,(myWidth/3)*2, 900, paint);
        //Horizontal Lines
        myCanvas.drawLine(0,300,myWidth,300,paint);
        myCanvas.drawLine(0,600,myWidth,600,paint);
        myCanvas.drawLine(0,900,myWidth,900,paint);
        /*myCanvas.drawLine(thirdOfScreen,0,thirdOfScreen,900,paint);
        myCanvas.drawLine(twoThirdsOfScreen,0,twoThirdsOfScreen,900,paint);*/
    }
    //Other Constructor
    public TicTacToeBoard(Canvas canvas, int width, int height)
    {
        myCanvas = canvas;
        myWidth = width;
        myHeight = height;
        xPlayerPaint.setStrokeWidth(3);
        xPlayerPaint.setColor(Color.RED);
        xPlayerPaint.setStyle(Paint.Style.STROKE);

        setCoordinates();
    }

    //Screen Information
    public int getScreenWidth()
    {
        return myWidth;
    }
    public int getScreenHeight()
    {
        return myHeight;
    }
    public int getThirdOfScreenWidth()
    {
        return myWidth / 3;
    }
    public int getTwoThirdsOfScreenWidth()
    {
        return thirdOfScreenWidth * 2;
    }


    public void drawGamePiece(int tile, String piece)
    {
        /*if(piece.equals("x"))
        {
            Paint xPaint = new Paint();
            xPaint.setStrokeWidth(3);
            xPaint.setColor(Color.RED);
            xPaint.setStyle(Paint.Style.STROKE);

            myCanvas.drawLine(0,0,300,300,xPaint);
            //int topleft = coordinates
            //int topLeft = array[tile][0]
            //myCanvas.drawLine(array[tile][0],array[tile][1],array[tile][2],array[tile][3],xPaint);
        }*/
        Paint paint = new Paint();
        paint.setStrokeWidth(3);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);

        //Vertical Lines
        myCanvas.drawLine(0, 0, 300, 400, paint);
    }
    public void drawGamePiece()
    {
        Log.i("Info", "piece drawn!");
        myCanvas.drawLine(0, 0, 300, 400, xPlayerPaint);
    }
/*public int getCoordinates(int col, int row,int i)
    {
        int myNumber = 0;
        if (col==0)
        {
            if (row == 0)
                myNumber = 0;
            else if (row==1)
                myNumber = 3;
            else if (row==2)
                myNumber = 6;
        }
        else if (col==1)
        {
            if (row==0)
                myNumber = 1;
            else if (row==1)
                myNumber = 4;
            else if (row==2)
                myNumber = 7;
        }
        else if (col==2)
        {
            if (row==0)
                myNumber = 2;
            else if (row==1)
                myNumber = 5;
            else if (row==2)
                myNumber = 8;
        }
        return myBoardCoordinates[myNumber][i];
    }*/































}



