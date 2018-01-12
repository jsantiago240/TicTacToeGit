package com.santiago.javius.tictactoehome;    //change depending on location

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    TicTacToeBoardView ticTacToeBoardView;      // View with tic tac toe board
    Game game = new Game();
    Player player = new Player();
    TicTacToeBoard board = new TicTacToeBoard();
    int[][] boardCoordinates;
    boolean xIsWinner = false;
    boolean oIsWinner = false;

    // initialize the Activity with the View of the splash screen
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);                     //sets view to main activity layout
        ticTacToeBoardView = new TicTacToeBoardView(this, board);  //creates new ticTacToeBoardView
        ticTacToeBoardView.setBoardCoordinates();
        boardCoordinates = ticTacToeBoardView.getBoardCoordinates();
        setContentView(R.layout.splash_screen);                     //sets view to splash screen/main menu
    }

    public boolean onTouchEvent(MotionEvent event)
    {
        if (event.getAction() == MotionEvent.ACTION_UP)
        {
            double x = event.getX();     // x coordinate of user's click
            double y = event.getY();     // y coordinate of user's click
            int tileSelected;            //tile player intended to click

            //If the player clicked within a tile that tile is returned (0-8) otherwise a -1 would be returned
            if(ticTacToeBoardView.inputIsWithinATile(x,y)!= -1)
            {
                tileSelected = ticTacToeBoardView.inputIsWithinATile(x,y);
                game.tileClicked(tileSelected, board);
            }

            //TODO: Add win detection here
            if(game.checkForWin(board).equals("x"))
            {
                xIsWinner = true;
                Toast.makeText(MainActivity.this, "x won", Toast.LENGTH_LONG).show();   //says hi to the player (Learned from paid Udemy course by Rob Percival)
            }
            else if(game.checkForWin(board).equals("o"))
            {
                oIsWinner = true;
                Toast.makeText(MainActivity.this, "O Won", Toast.LENGTH_LONG).show();   //says hi to the player (Learned from paid Udemy course by Rob Percival)

            }


            ticTacToeBoardView.invalidate();
        }

                /*// win/draw detection
                if (boardArr[0][0].equals("x") && boardArr[0][1].equals("x") && boardArr[0][2].equals("x"))
                {
                    XIsWinner = true;
                }
                // else if...

                // toggling player turn
                if (playerTurn.equals("x"))
                {
                    playerTurn = "o";
                }
                else
                {
                    playerTurn = "x";
                }

                invalidate();        // redraw the View by calling onDraw*/
        return true;

    }// end of onTouchEvent


    //Main Menu***************************************
    public void singlePlayerButtonClicked(View view)
    {
        EditText nameEditText = (EditText) findViewById(R.id.nameEditText);     //initializes nameEditText
        String playerName = nameEditText.getText().toString();                  //sets playerName equal to what is typed into nameEditText
        player.setName(playerName);                                             //assigns playerName to the player's name
        Toast.makeText(MainActivity.this, "Hi, " + playerName, Toast.LENGTH_LONG).show();   //says hi to the player (Learned from paid Udemy course by Rob Percival)
        game.setMode("single");                                                 //sets game mode to single player
        setContentView(ticTacToeBoardView);                                     //sets view to tictactoeboardview
    }

    //TODO: finish
    public void twoPlayerButtonClicked(View view)
    {
        EditText nameEditText = (EditText) findViewById(R.id.nameEditText);     //initializes nameEditText
        String playerName = nameEditText.getText().toString();                  //sets playerName equal to what is typed into nameEditText
        player.setName(playerName);                                             //assigns playerName to the player's name
        Toast.makeText(MainActivity.this, "Hello players ", Toast.LENGTH_LONG).show();   //says hi to the player (Learned from paid Udemy course by Rob Percival)
        game.setMode("two");                                                 //sets game mode to single player
        setContentView(ticTacToeBoardView);                                     //sets view to tictactoeboardview
    }





}