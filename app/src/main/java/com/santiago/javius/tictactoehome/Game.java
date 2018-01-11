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
    //Button tileOne = (Button) findViewById(R.id.tileOne);
	 TicTacToeBoard myBoard;
	private Player myPlayerX;
	private Player myPlayerO;
	private boolean isOn;
    private String playerTurn = "x";
    private boolean isSingle;

    public String[] getBoardArr()
    {
        return myBoard.getBoardArray();
    }
    public void start()
    {
        isOn = true;
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
    public Game()
    {

    }


    public void createBoard(Canvas canvas, int width, int height)
    {
        myBoard = new TicTacToeBoard(canvas, width, height);
    }
    public void drawBoard()
    {
        myBoard.drawBoard();
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


}

    /*public int getLeftOf(int col, int row)
    {
        return myBoard.getCoordinates(col,row,0);
    }
    public int getTopOf(int col, int row)
    {
        return myBoard.getCoordinates(col, row, 1);
    }
    public int getRightOf(int col, int row)
    {
        return myBoard.getCoordinates(col, row, 2);
    }
    public int getBottomOf(int col, int row)
    {
        return myBoard.getCoordinates(col, row, 3);
    }
    */
