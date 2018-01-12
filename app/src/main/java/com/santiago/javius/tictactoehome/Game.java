package com.santiago.javius.tictactoehome;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Javius Santiago on 12/8/17.
 */

public class Game extends Activity
{
	private boolean isOn;
    private boolean isSingle;
    private String playerTurn = "x";

    public Game()
    {
        //createBoard();
    }

    public String checkForWin(TicTacToeBoard board)
    {
        String[] boardArr = board.getBoardArray();

        if (boardArr[0].equals("x"))
        {
            //top row
            if(boardArr[1].equals("x"))
            {
                if(boardArr[2].equals("x"))
                {
                    return "x";
                }
            }
            //diagonal top left to bottom right
            if(boardArr[4].equals("x"))
            {
                if(boardArr[8].equals("x"))
                {
                    return "x";
                }
            }
            //left column
            if(boardArr[3].equals("x"))
            {
                if(boardArr[6].equals("x"))
                {
                    return "x";
                }
            }
        }
        //left column
        if(boardArr[2].equals("x"))
        {
            if(boardArr[5].equals("x"))
            {
                if(boardArr[8].equals("x"))
                {
                    return "x";
                }
            }
        }
        //middle column
        if(boardArr[1].equals("x"))
        {
            if(boardArr[4].equals("x"))
            {
                if(boardArr[7].equals("x"))
                {
                    return "x";
                }
            }
        }
        //middle row
        if(boardArr[3].equals("x"))
        {
            if(boardArr[4].equals("x"))
            {
                if(boardArr[5].equals("x"))
                {
                    return "x";
                }
            }
        }
        //bottom row
        if(boardArr[6].equals("x"))
        {
            if(boardArr[7].equals("x"))
            {
                if(boardArr[8].equals("x"))
                {
                    return "x";
                }
            }
        }
        //diagonal bottom left to top right
        if(boardArr[6].equals("x"))
        {
            if(boardArr[4].equals("x"))
            {
                if(boardArr[2].equals("x"))
                {
                    return "x";
                }
            }
        }

        return "";  //returns empty if neither player one
    }
    public void createBoard()
    {
        //myBoard = new TicTacToeBoard();
    }

    public boolean isGameSingle()
    {
        return isSingle;
    }

    public void tileClicked(int tile, TicTacToeBoard board)
    {
        if (isSingle)
        {
            if (board.isSpaceEmpty(tile))
            {
                board.placeGamePiece(tile,playerTurn);
                switchPlayerTurn();
            }
        }
        else    //game is in Two Player mode
        {

        }
    }

    private void switchPlayerTurn()
    {
        if (playerTurn.equals("x"))
            playerTurn = "o";
        else
            playerTurn = "x";
    }

    public void setMode(String mode)
    {
        if (mode.equals("single"))
        {
            isSingle = true;
        }
        else
        {
            isSingle = false;
        }
    }

}

