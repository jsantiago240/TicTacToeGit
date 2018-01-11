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
    private TicTacToeBoard myBoard;
	private boolean isOn;
    private boolean isSingle;
    private String playerTurn = "x";

    public Game()
    {
        createBoard();
    }

    public void createBoard()
    {
        myBoard = new TicTacToeBoard();
    }

    public boolean isGameSingle()
    {
        return isSingle;
    }

    public void tileClicked(int tile)
    {
        /*if (isSingle)
        {
            if (myBoard.isSpaceEmpty(tile))
            {
                myBoard.placeGamePiece(tile,playerTurn);
                Log.i("Info", "Piece placed at " + tile);
                //TODO: draw game piece / switch turn
                //myBoard.drawGamePiece(x1,y1,x2,y2, playerTurn);
                //myBoard.drawGamePiece(tile,playerTurn,array);
            }
        }*/
        //Log.i("Info", "Piece placed at " + (tile+1));
        if (isGameSingle())
        {
            if (myBoard.isSpaceEmpty(tile))
            {
                myBoard.placeGamePiece(tile,"x");
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

