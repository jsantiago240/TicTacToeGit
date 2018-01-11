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
    int[][] boardCoordinates;
    final int LEFT_BOUNDARY = 0;
    final int TOP_BOUNDARY = 1;
    final int RIGHT_BOUNDARY = 2;
    final int BOTTOM_BOUNDARY = 3;

    // initialize the Activity with the View of the splash screen
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);                     //sets view to main activity layout
        ticTacToeBoardView = new TicTacToeBoardView(this);  //creates new ticTacToeBoardView
        ticTacToeBoardView.setBoardCoordinates();
        boardCoordinates = ticTacToeBoardView.getBoardCoordinates();
        setContentView(R.layout.splash_screen);                     //sets view to splash screen/main menu
    }

    public boolean onTouchEvent(MotionEvent event)
    {
        /*int screenWidth = ticTacToeBoardView.getScreenWidth();
        int thirdOfScreen = ticTacToeBoardView.getThirdOfScreen();
        int twoThirdsOfScreen = ticTacToeBoardView.getTwoThirdsOfScreen();


        //                      l,t,r,b
        int coordinates[][] = {{0,0,thirdOfScreen,600},                    //one (4,7)
                {thirdOfScreen,0,twoThirdsOfScreen,600},     //two (5,8)
                {twoThirdsOfScreen,0,screenWidth,600},       //three(6,9)
                {0,600,thirdOfScreen,900},                   //four (1,7)
                {thirdOfScreen,600,twoThirdsOfScreen,900},   //five (2,8)
                {twoThirdsOfScreen,600,screenWidth,900},     //six(3,9)
                {0,900,thirdOfScreen,1200},                  //seven(1,4)
                {thirdOfScreen,900,twoThirdsOfScreen,1200},  //eight(2,5)
                {twoThirdsOfScreen,900,screenWidth,1200}};//nine(3,6)*/



        if (event.getAction() == MotionEvent.ACTION_UP)
        {
            double x = event.getX();     // x coordinate of user's click
            double y = event.getY();     // y coordinate of user's click
            int tileSelected;            //tile player intended to click

            //If the player clicked within a tile that tile is returned (0-8) otherwise a -1 would be returned
            if(ticTacToeBoardView.inputIsWithinATile(x,y)!= -1)
            {
                tileSelected = ticTacToeBoardView.inputIsWithinATile(x,y);
                //Log.i("Info", "fits within tile " + tileSelected);
                game.tileClicked(tileSelected);
            }

            //TODO: Add win detection here
            ticTacToeBoardView.invalidate();
        }



            // determine player's last move
                /*if (x >= 0 && x <= 300 && y >= 0 && y <= 300)        // board[0][0]
                {
                    boardArr[0][0] = playerTurn;
                }
                else if (x >= 300 && x <= 600 && y >= 0 && y <= 300) // board[0][1]
                {
                    boardArr[0][1] = playerTurn;
                }*/

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
        EditText nameEditText = (EditText) findViewById(R.id.nameEditText);
       // playerName = nameEditText.getText().toString();

        setContentView(ticTacToeBoardView);
        //playerName = name;
        //Log.i("info: ", playerName);
    }





}