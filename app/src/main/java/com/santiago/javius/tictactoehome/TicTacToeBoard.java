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
    private String myBoardArr[] = {"","","","","","","","",""};         //stores board values

    //default constructor
    public TicTacToeBoard()
    {

    }

    //returns true if board is full (for draw detection)
    public boolean isBoardFull()
    {
        for (int i=0;i<myBoardArr.length;i++)
        {
            if (myBoardArr[i].equals(""))
                return false;
        }
        return true;
    }

    //places game piece
    public void placeGamePiece(int tile, String piece)
    {
        myBoardArr[tile] = piece;
    }

    //returns true if tile is empty
    public boolean isSpaceEmpty(int tile)
    {
        if (myBoardArr[tile].equals(""))
        {
            return true;
        }
        return false;
    }

    //returns board array
    public String[] getBoardArray()
    {
        return myBoardArr;
    }

    //returns whatever is currently in the tile (blank, x or o)
    public String getTileValue(int tile)
    {
        return myBoardArr[tile];
    }

    //resets board
    public void reset()
    {
        for (int i=0;i<myBoardArr.length;i++)
            myBoardArr[i] = "";
    }
}//end of class