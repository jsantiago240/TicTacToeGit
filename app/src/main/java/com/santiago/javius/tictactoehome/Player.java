package com.santiago.javius.tictactoehome;

import android.graphics.Canvas;

//import com.santiago.javius.tictactoe2demo.TicTacToeBoard;

/**
 * Created by Javius Santiago on 12/6/2017.
 */
public class Player
{
    private String myLetter;
    private TicTacToeBoard myBoard;
    private String myName;

    public Player()
    {

    }

    public Player(String name)
    {
        myName = name;
    }

    public void setName(String name)
    {
        myName = name;
    }


    public void setMyLetter(String newLetter)
    {
   
        myLetter = newLetter;
    }

    public String getMyLetter()
    {
        return myLetter;
    }

    public void setBoard(TicTacToeBoard board)
    {
        myBoard = board;
    }

    public void placeGamePiece(int i)
    {

    }
    public void drawGamePiece(int tile)
    {

    }

}
