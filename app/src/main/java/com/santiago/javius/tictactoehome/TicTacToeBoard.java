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
    private String myBoardArr[] = {"","","","","","","","",""};
    //                              0, 1, 2, 3, 4, 5, 6, 7, 8

    int myBoardCoordinates[][] = {{0,0,thirdOfScreenWidth,600},
            {thirdOfScreenWidth,0,twoThirdsOfScreenWidth,600},
            {twoThirdsOfScreenWidth,0,myWidth,600},
            {0,600,thirdOfScreenWidth,900},
            {thirdOfScreenWidth,600,twoThirdsOfScreenWidth,900},
            {twoThirdsOfScreenWidth,600,myWidth,900},
            {0,900,thirdOfScreenWidth,1200},
            {thirdOfScreenWidth,900,twoThirdsOfScreenWidth,1200},
            {twoThirdsOfScreenWidth,900,myWidth,1200}};

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
        /*int boardCoordinates[][] = {{0,0,thirdOfScreenWidth,600},                    //one (4,7)
                {thirdOfScreenWidth,0,twoThirdsOfScreenWidth,600},     //two (5,8)
                {twoThirdsOfScreenWidth,0,myWidth,600},       //three(6,9)
                {0,600,thirdOfScreenWidth,900},                   //four (1,7)
                {thirdOfScreenWidth,600,twoThirdsOfScreenWidth,900},   //five (2,8)
                {twoThirdsOfScreenWidth,600,myWidth,900},     //six(3,9)
                {0,900,thirdOfScreenWidth,1200},                  //seven(1,4)
                {thirdOfScreenWidth,900,twoThirdsOfScreenWidth,1200},  //eight(2,5)
                {twoThirdsOfScreenWidth,900,myWidth,1200}};//nine(3,6)*/
    }

    public TicTacToeBoard()
    {

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





























}



