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
    private boolean isSinglePlayer;
    private String playerTurn = "x";
    private String gameMode;
    public Game()
    {

    }

    public String checkForWin(TicTacToeBoard board)
    {
        String[] boardArr = board.getBoardArray();

        //Horizontal wins
        //top row
        if(boardArr[0].equals("x")&&boardArr[1].equals("x")&&boardArr[2].equals("x"))
        {
            return "x";
        }
        //middle row
        if(boardArr[3].equals("x")&&boardArr[4].equals("x")&&boardArr[5].equals("x"))
        {
            return "x";
        }
        //bottom row
        if(boardArr[6].equals("x")&&boardArr[7].equals("x")&&boardArr[8].equals("x"))
        {
            return "x";
        }

        //Vertical Wins
        //left
        if(boardArr[0].equals("x")&&boardArr[3].equals("x")&&boardArr[6].equals("x"))
        {
            return "x";
        }
        //middle
        if(boardArr[1].equals("x")&&boardArr[4].equals("x")&&boardArr[7].equals("x"))
        {
            return "x";
        }
        //right
        if(boardArr[2].equals("x")&&boardArr[5].equals("x")&&boardArr[8].equals("x"))
        {
            return "x";
        }

        //Diagonal Wins
        //top left bottom right
        if(boardArr[0].equals("x")&&boardArr[4].equals("x")&&boardArr[8].equals("x"))
        {
            return "x";
        }
        //bottom left top right
        if(boardArr[6].equals("x")&&boardArr[4].equals("x")&&boardArr[2].equals("x"))
        {
            return "x";
        }

        return "";  //returns empty if neither player one
    }

    public void tileClicked(int tile, TicTacToeBoard board)
    {
        if (gameMode.equals("single"))
        {
            if (board.isSpaceEmpty(tile))
            {
                board.placeGamePiece(tile,playerTurn);
                botGo(board);
            }
        }
        else
        {
            if (board.isSpaceEmpty(tile))
            {
                board.placeGamePiece(tile,playerTurn);
                switchPlayerTurn();
            }
        }

    }
    public void botGo(TicTacToeBoard board)
    {
        int randomTile;
        boolean flag = true;
        while(flag)
        {
            randomTile = (int) (Math.random() * 9);
            if (board.isSpaceEmpty(randomTile))
            {
                board.placeGamePiece(randomTile, "o");
                flag = false;
            }
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
        gameMode = mode;
    }

}

