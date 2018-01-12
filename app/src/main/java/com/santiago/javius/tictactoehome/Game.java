package com.santiago.javius.tictactoehome;

import android.app.Activity;

/**
 * Created by Javius Santiago on 12/8/17.
 * Finished on 1/12/18
 */

public class Game extends Activity
{
    private String playerTurn = "x";    //user is "x", will switch to "o" for player two, or will be "o" for the bot
    private String gameMode;            //will be either "single" or "two" depending on users selection

    //default constructor
    public Game()
    {

    }

    //This method is used for win detection, the board is passed since it is initialized in the main activity
    public String checkForWin(TicTacToeBoard board)
    {
        String[] boardArr = board.getBoardArray();  //this array = the boards actual array

        //X WINS************************************************************************************
        //Horizontal wins
        //top row
        if(boardArr[0].equals("x")&&boardArr[1].equals("x")&&boardArr[2].equals("x"))
        {
            return "x";
        }
        //middle row
        else if(boardArr[3].equals("x")&&boardArr[4].equals("x")&&boardArr[5].equals("x"))
        {
            return "x";
        }
        //bottom row
        else if(boardArr[6].equals("x")&&boardArr[7].equals("x")&&boardArr[8].equals("x"))
        {
            return "x";
        }

        //Vertical Wins
        //left
        else if(boardArr[0].equals("x")&&boardArr[3].equals("x")&&boardArr[6].equals("x"))
        {
            return "x";
        }
        //middle
        else if(boardArr[1].equals("x")&&boardArr[4].equals("x")&&boardArr[7].equals("x"))
        {
            return "x";
        }
        //right
        else if(boardArr[2].equals("x")&&boardArr[5].equals("x")&&boardArr[8].equals("x"))
        {
            return "x";
        }

        //Diagonal Wins
        //top left bottom right
        else if(boardArr[0].equals("x")&&boardArr[4].equals("x")&&boardArr[8].equals("x"))
        {
            return "x";
        }
        //bottom left top right
        else if(boardArr[6].equals("x")&&boardArr[4].equals("x")&&boardArr[2].equals("x"))
        {
            return "x";
        }

        //O WINS************************************************************************************
        //Horizontal wins
        //top row
        else if(boardArr[0].equals("o")&&boardArr[1].equals("o")&&boardArr[2].equals("o"))
        {
            return "o";
        }
        //middle row
        else if(boardArr[3].equals("o")&&boardArr[4].equals("o")&&boardArr[5].equals("o"))
        {
            return "o";
        }
        //bottom row
        else if(boardArr[6].equals("o")&&boardArr[7].equals("o")&&boardArr[8].equals("o"))
        {
            return "o";
        }

        //Vertical Wins
        //left
        else if(boardArr[0].equals("o")&&boardArr[3].equals("o")&&boardArr[6].equals("o"))
        {
            return "o";
        }
        //middle
        else if(boardArr[1].equals("o")&&boardArr[4].equals("o")&&boardArr[7].equals("o"))
        {
            return "o";
        }
        //right
        else if(boardArr[2].equals("o")&&boardArr[5].equals("o")&&boardArr[8].equals("o"))
        {
            return "o";
        }

        //Diagonal Wins
        //top left bottom right
        else if(boardArr[0].equals("o")&&boardArr[4].equals("o")&&boardArr[8].equals("o"))
        {
            return "o";
        }
        //bottom left top right
        else if(boardArr[6].equals("o")&&boardArr[4].equals("o")&&boardArr[2].equals("o"))
        {
            return "o";
        }

        return "";  //returns empty string if neither the player(s) or bot has one yet, program will then assure that there has not been a draw
    }

    //Checks to see if there was a draw
    public boolean checkForDraw(TicTacToeBoard board)
    {
        //if the board is full when this is called (meaning all win possibilities have been checked for) there has been a draw
        if (board.isBoardFull())
            return true;
        return false;
    }

    //Method to place game piece
    public void tileClicked(int tile, TicTacToeBoard board)
    {
        //if user is in single player mode
        if (gameMode.equals("single"))
        {
            //makes sure selected tile isnt already filled
            if (board.isSpaceEmpty(tile))
            {
                board.placeGamePiece(tile,playerTurn);  //fills that tile with, in this case, x
                botGo(board);                           //causes "bot" to make move
            }
        }
        //else game is in two player mode
        else
        {
            //makes sure the selected tile is empty
            if (board.isSpaceEmpty(tile))
            {
                board.placeGamePiece(tile,playerTurn);  //places this users piece
                switchPlayerTurn();                     //switches turn to allow player 2 to make their move
            }
        }
    }

    //Method to cause the "bot" to make its move
    public void botGo(TicTacToeBoard board)
    {
        int randomTile;         //this integer will store a random number between 0 and 8
        boolean flag = true;    //this will be used as a flag variable to end the while loop after the bot has made its move
        while(flag)             //while true this loop will keep assigning random value between 0 and 8 to the randomTile variable
        {
            randomTile = (int) (Math.random() * 9);         //assigns randomTile
            if (board.isSpaceEmpty(randomTile))             //if that randomTile is empty
            {
                board.placeGamePiece(randomTile, "o");//bot can place its piece in that random tile
                flag = false;                               //while loop can now end
            }
        }
    }

    //Switches player turn from "x" to "o" or vice versa
    private void switchPlayerTurn()
    {
        if (playerTurn.equals("x"))
            playerTurn = "o";
        else
            playerTurn = "x";
    }

    //sets game mode to single or two player and stores it in the gameMode string
    public void setMode(String mode)
    {
        gameMode = mode;
    }
}

