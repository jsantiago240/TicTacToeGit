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

    public TicTacToeBoard()
    {

    }

    public boolean isBoardFull()
    {
        for (int i=0;i<myBoardArr.length;i++)
        {
            if (myBoardArr[i].equals(""))
                return false;
        }
        return true;
    }

    public void placeGamePiece(int tile, String piece)
    {
        myBoardArr[tile] = piece;
        //Log.i("Info", piece + " has been placed in " + tile);
    }

    public boolean isSpaceEmpty(int tile)
    {
        if (myBoardArr[tile].equals(""))
        {
            return true;
        }
        return false;
    }

    public void clearBoard()
    {
        for (int i=0;i<myBoardArr.length;i++)
        {
            myBoardArr[i] = "";
        }
    }

    public String[] getBoardArray()
    {
        return myBoardArr;
    }

    public String getTileValue(int tile)
    {
        return myBoardArr[tile];
    }

    public void printContents()
    {
        for(int i=0;i<myBoardArr.length;i++)
            Log.i("Info", "Position " + i + ": " + myBoardArr[i]);
    }
}//end of class