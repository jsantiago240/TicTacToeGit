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

            int tileSelected;
            //TODO: Use for loop
            //Checks to see if player clicked inside of a tile
            if(ticTacToeBoardView.inputIsWithinATile(x,y)!=-1)
            {
                //Log.i("Info", "fits in tile 1");
                //tileSelected = ticTacToeBoardView.whichTileIsSelected();
                //game.tileClicked(ticTacToeBoardView.inputIsWithinATile(x,y));   //if empty
                tileSelected = ticTacToeBoardView.inputIsWithinATile(x,y);
                Log.i("Info", "fits within tile " + tileSelected);
            }


            /*
            //Row 1
            //first tile
            if(x>=boardCoordinates[0][LEFT_BOUNDARY]&&x<=boardCoordinates[0][RIGHT_BOUNDARY]&&y>=boardCoordinates[0][TOP_BOUNDARY]&&y<=boardCoordinates[0][BOTTOM_BOUNDARY])
            {
                Log.i("Info", "fits in tile 1");
                game.tileClicked(0);
            }
            //second tile
            if(x>=coordinates[1][LEFT_BOUNDARY]&&x<=coordinates[1][RIGHT_BOUNDARY]&&y>=coordinates[1][TOP_BOUNDARY]&&y<=coordinates[1][BOTTOM_BOUNDARY])
            {
                game.tileClicked(1);
            }
            //third tile
            if(x>=coordinates[2][LEFT_BOUNDARY]&&x<=coordinates[2][RIGHT_BOUNDARY]&&y>=coordinates[2][TOP_BOUNDARY]&&y<=coordinates[2][BOTTOM_BOUNDARY])
            {
                game.tileClicked(2);
            }

            //Row 2
            //fourth tile
            if(x>=coordinates[3][LEFT_BOUNDARY]&&x<=coordinates[3][RIGHT_BOUNDARY]&&y>=coordinates[3][TOP_BOUNDARY]&&y<=coordinates[3][BOTTOM_BOUNDARY])
            {
                game.tileClicked(3);
            }
            //fifth tile
            if(x>=coordinates[4][LEFT_BOUNDARY]&&x<=coordinates[4][RIGHT_BOUNDARY]&&y>=coordinates[4][TOP_BOUNDARY]&&y<=coordinates[4][BOTTOM_BOUNDARY])
            {
                game.tileClicked(4);
            }
            //sixth tile
            if(x>=coordinates[5][LEFT_BOUNDARY]&&x<=coordinates[5][RIGHT_BOUNDARY]&&y>=coordinates[5][TOP_BOUNDARY]&&y<=coordinates[5][BOTTOM_BOUNDARY])
            {
                game.tileClicked(5);
            }

            //Row 3
            //seventh tile
            if(x>=coordinates[6][LEFT_BOUNDARY]&&x<=coordinates[6][RIGHT_BOUNDARY]&&y>=coordinates[6][TOP_BOUNDARY]&&y<=coordinates[6][BOTTOM_BOUNDARY])
            {
                game.tileClicked(6);
            }
            //eighth tile
            if(x>=coordinates[7][LEFT_BOUNDARY]&&x<=coordinates[7][RIGHT_BOUNDARY]&&y>=coordinates[7][TOP_BOUNDARY]&&y<=coordinates[7][BOTTOM_BOUNDARY])
            {
                game.tileClicked(7);
            }
            //ninth tile
            if(x>=coordinates[8][LEFT_BOUNDARY]&&x<=coordinates[8][RIGHT_BOUNDARY]&&y>=coordinates[8][TOP_BOUNDARY]&&y<=coordinates[8][BOTTOM_BOUNDARY])
            {
                game.tileClicked(8);
            }*/

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