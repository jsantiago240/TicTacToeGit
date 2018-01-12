package com.santiago.javius.tictactoehome;    //change depending on location

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    TicTacToeBoardView ticTacToeBoardView;      // View with tic tac toe board
    Game game = new Game();                     //creates new game
    Player player = new Player();               //creates player object
    TicTacToeBoard board = new TicTacToeBoard();//creates new tic tac toe board
    int[][] boardCoordinates;                   //array to store boundaries of boards tiles for input purposes

    // initialize the Activity with the View of the splash screen
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);                             //sets view to main activity layout
        ticTacToeBoardView = new TicTacToeBoardView(this, board);   //creates new ticTacToeBoardView
        ticTacToeBoardView.setBoardCoordinates();                           //initializes array within this class
        boardCoordinates = ticTacToeBoardView.getBoardCoordinates();        //aliases (not sure if im using this vocab correctly) this array to match array of coordinates within this class
        setContentView(R.layout.splash_screen);                             //sets view to splash screen/main menu
    }

    //Detects user input
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

            //Tells user if x won, o won, or there was a draw through toast messages
            if(game.checkForWin(board).equals("x"))
            {
                Toast.makeText(MainActivity.this, "x won", Toast.LENGTH_LONG).show();   //tells user that x won (Learned from paid Udemy course by Rob Percival)
            }
            else if(game.checkForWin(board).equals("o"))
            {
                Toast.makeText(MainActivity.this, "O Won", Toast.LENGTH_LONG).show();   //tells user that o won (Learned from paid Udemy course by Rob Percival)
            }
            else if(game.checkForDraw(board))
            {
                Toast.makeText(MainActivity.this, "Draw", Toast.LENGTH_LONG).show();   //tells user there was a draw (Learned from paid Udemy course by Rob Percival)
            }

            ticTacToeBoardView.invalidate();    //Recalls this views onDraw method (learned from google searches but was already in demo)
        }
        return true;
    }

    //Main Menu buttons*****************************************************************************
    public void singlePlayerButtonClicked(View view)
    {
        EditText nameEditText = (EditText) findViewById(R.id.nameEditText);     //initializes nameEditText
        String playerName = nameEditText.getText().toString();                  //sets playerName equal to what is typed into nameEditText
        player.setName(playerName);                                             //assigns playerName to the player's name
        Toast.makeText(MainActivity.this, "Hi, " + player.getName(), Toast.LENGTH_LONG).show();   //says hi to the player (Learned from paid Udemy course by Rob Percival)
        game.setMode("single");                                                 //sets game mode to single player
        setContentView(ticTacToeBoardView);                                     //sets view to tictactoeboardview
    }
    public void twoPlayerButtonClicked(View view)
    {
        EditText nameEditText = (EditText) findViewById(R.id.nameEditText);     //initializes nameEditText
        String playerName = nameEditText.getText().toString();                  //sets playerName equal to what is typed into nameEditText
        player.setName(playerName);                                             //assigns playerName to the player's name
        Toast.makeText(MainActivity.this, "Hello players ", Toast.LENGTH_LONG).show();   //says hi to the players (Learned from paid Udemy course by Rob Percival)
        game.setMode("two");                                                 //sets game mode to two player
        setContentView(ticTacToeBoardView);                                     //sets view to tictactoeboardview
    }
}