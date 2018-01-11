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
    //private TicTacToeBoard board;
    //Button tileOne;


    // initialize the Activity with the View of the tic tac toe board
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       //tileOne = findViewById(R.id.tileOne);
        ticTacToeBoardView = new TicTacToeBoardView(this);

        //setContentView(ticTacToeBoardView);

        setContentView(R.layout.splash_screen);


    }

    // tic tac toe board view
    private class TicTacToeBoardView extends View
    {
        public TicTacToeBoardView(Context context)
        {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas)
        {
            super.onDraw(canvas);

            int screenWidth = getWidth();      // width of the View object but can be thought of as the canvas width
            int screenHeight = getHeight();    // canvas height (TODO: figure out how to account for height of action bar
            int thirdOfScreen = screenWidth/3;
            int twoThirdsOfScreen = thirdOfScreen*2;

            //initializes board variable
            //board = new TicTacToeBoard(canvas, screenWidth, screenHeight);
            //Game game = new Game(board, playerX, playerO);
            //game = new Game();
            Paint xPaint = new Paint();
            xPaint.setStrokeWidth(3);
            xPaint.setColor(Color.RED);
            xPaint.setStyle(Paint.Style.STROKE);

            /*game.createBoard(canvas, screenWidth, screenHeight);
            game.drawBoard();
            game.start();*/
            Paint paint = new Paint();
            paint.setStrokeWidth(3);
            paint.setColor(Color.BLUE);
            paint.setStyle(Paint.Style.STROKE);

            //Draws Board
            //Vertical Lines
            canvas.drawLine(screenWidth/3, 0, screenWidth/3, 900, paint);
            canvas.drawLine((screenWidth/3)*2, 0,(screenWidth/3)*2, 900, paint);
            //Horizontal Lines
            canvas.drawLine(0,300,screenWidth,300,paint);
            canvas.drawLine(0,600,screenWidth,600,paint);
            canvas.drawLine(0,900,screenWidth,900,paint);


            /*String[] board = game.getBoardArr();
            for(int i=0;i<9;i++)
            {
                if(board[i].equals("x"))
                {
                    //canvas.drawLine(
                }
            }*/
        }
    }// end of TicTacToeBoardView class

    public boolean onTouchEvent(MotionEvent event)
    {
        int screenWidth = game.myBoard.getScreenWidth();
        //int thirdOfScreen = game.myBoard.getThirdOfScreenWidth();
        int thirdOfScreen = screenWidth/3;
        int twoThirdsOfScreen = (thirdOfScreen*2);
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
        //int coordinates[][] = game.myBoard.getCoordinateArray();
        final int LEFT_BOUNDARY = 0;
        final int TOP_BOUNDARY = 1;
        final int RIGHT_BOUNDARY = 2;
        final int BOTTOM_BOUNDARY = 3;

        if (event.getAction() == MotionEvent.ACTION_UP)
        {
            double x = event.getX();     // x coordinate of user's click
            double y = event.getY();     // y coordinate of user's click

            //game.checkInput(x,y);

            //ticTacToeBoardView.invalidate();

            //game.checkInput(x,y);

            //Row 1
            //first tile
            if(x>=coordinates[0][LEFT_BOUNDARY]&&x<=coordinates[0][RIGHT_BOUNDARY]&&y>=coordinates[0][TOP_BOUNDARY]&&y<=coordinates[0][BOTTOM_BOUNDARY])
            {
                //Log.i("Info", "fits in tile 1");
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
        EditText nameEditText = (EditText) findViewById(R.id.nameEditText);
        String playerName = nameEditText.getText().toString();
        player.setName(playerName);
        Toast.makeText(MainActivity.this, "Hi, " + playerName, Toast.LENGTH_LONG).show();
        game.setMode("single");
        setContentView(ticTacToeBoardView);
        //setContentView(R.layout.activity_main);

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

    public void demoFunction(View view)
    {
        //ass
        //440pm
    }




}