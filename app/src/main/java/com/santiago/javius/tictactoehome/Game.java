package com.santiago.javius.tictactoehome;

import android.app.Activity;

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

        return "";  //returns empty if neither player one
    }

    public boolean checkForDraw(TicTacToeBoard board)
    {
        if (board.isBoardFull())
            return true;
        return false;
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

