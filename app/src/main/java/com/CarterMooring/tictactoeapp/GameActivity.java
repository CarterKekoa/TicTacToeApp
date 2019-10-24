/**This function is the driver for the tic tac toe game
 * Oct. 22nd, 2019
 * PA5
 * Dr. Sprint
 * @author Carter Mooring
 * @sources
 */

package com.CarterMooring.tictactoeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class GameActivity extends AppCompatActivity {
    public boolean playerTurn = true;

    @Override
    //This function is executed when the Game screen opens and sets up the play again and quit buttons
    protected void onCreate(Bundle savedInstanceState) {
        String player1 = "Player 1";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        TextView textView = (TextView) findViewById(R.id.turnText);
        ImageView turnImage = (ImageView) findViewById(R.id.turnImage);
        Intent intent = getIntent();
        if (intent != null) {
            player1 = intent.getStringExtra("player1");
        }

        textView.setText(player1 + " will go first");
        turnImage.setImageResource(R.drawable.alien);


        Button quitButton = (Button) findViewById(R.id.quitButton);
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("result", "succesful");
                setResult(Activity.RESULT_OK, intent);
                GameActivity.this.finish();
            }
        });

        final Button playAgainButton = (Button) findViewById(R.id.playAgainButton);

        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            //This is the onclick listener for when the user wants to play again
            public void onClick(View v) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
    }

    //This is the function for when the user clicks the board buttons to play the game that is
    //  the real bread and butter of the app
    public void onButtonClick(View view) {
        String TAG = "isButtonListener";
        String player1 = "Player1";
        String player2 = "Player2";

        ImageView imageView = (ImageView) view;
        ImageView turnImage = (ImageView) findViewById(R.id.turnImage);
        TextView textView = (TextView) findViewById(R.id.turnText);
        Button button = (Button) findViewById(R.id.playAgainButton);
        String position = imageView.getTag().toString();
        TicTacToeBoard board = new TicTacToeBoard();

        Intent intent = getIntent();
        //this loop gets the users names
        if (intent != null) {
            player1 = intent.getStringExtra("player1");
            player2 = intent.getStringExtra("player2");
        }

        int row = Integer.parseInt(String.valueOf(position.charAt(0)));
        int col = Integer.parseInt(String.valueOf(position.charAt(1)));
        Coordinates move = new Coordinates(row, col);
        Log.d(TAG, "Tag: " + position + " Row: " + row + " Col: " + col);

        String text = imageView.getTag().toString();


        Log.d(TAG, "Player 1's turn");
        turnImage.setImageResource(R.drawable.astronaut);
        textView.setText("It is " + player2 + "'s turn");
        imageView.setImageResource((R.drawable.alien));

        //prepare buttons for hard code checking if won.
        Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
        ImageView button00 = (ImageView) findViewById(R.id.button00);
        ImageView button01 = (ImageView) findViewById(R.id.button01);
        ImageView button02 = (ImageView) findViewById(R.id.button02);
        ImageView button10 = (ImageView) findViewById(R.id.button10);
        ImageView button11 = (ImageView) findViewById(R.id.button11);
        ImageView button12 = (ImageView) findViewById(R.id.button12);
        ImageView button20 = (ImageView) findViewById(R.id.button20);
        ImageView button21 = (ImageView) findViewById(R.id.button21);
        ImageView button22 = (ImageView) findViewById(R.id.button22);

            if (playerTurn) {
                if (imageView.isClickable()) {
                    turnImage.setImageResource(R.drawable.astronaut);
                    textView.setText("It is " + player2 + "'s turn");
                    imageView.setTag("X");
                    imageView.setClickable(false);

                    if(!button00.isClickable() && !button01.isClickable() && !button02.isClickable()
                            && !button10.isClickable() && !button11.isClickable() && !button12.isClickable()
                            && !button20.isClickable() && !button21.isClickable() && !button22.isClickable()){
                        textView.setText("Cat Game!! That means it was a good match! Would you like to play again or quit?");
                        playAgainButton.setVisibility(View.VISIBLE);
                    } if(button00.getTag() == "X" && button01.getTag() == "X" && button02.getTag() == "X"){
                        textView.setText(player1 + " wins! Would you like to play again or quit?");
                        playAgainButton.setVisibility(View.VISIBLE);
                        turnImage.setImageResource(R.drawable.alien);
                        button00.setClickable(false);
                        button01.setClickable(false);
                        button02.setClickable(false);
                        button10.setClickable(false);
                        button11.setClickable(false);
                        button12.setClickable(false);
                        button20.setClickable(false);
                        button21.setClickable(false);
                        button22.setClickable(false);
                    } if(button10.getTag() == "X" && button11.getTag() == "X" && button12.getTag() == "X"){
                        textView.setText(player1 + " wins! Would you like to play again or quit?");
                        playAgainButton.setVisibility(View.VISIBLE);
                        turnImage.setImageResource(R.drawable.alien);
                        button00.setClickable(false);
                        button01.setClickable(false);
                        button02.setClickable(false);
                        button10.setClickable(false);
                        button11.setClickable(false);
                        button12.setClickable(false);
                        button20.setClickable(false);
                        button21.setClickable(false);
                        button22.setClickable(false);
                    } if(button20.getTag() == "X" && button21.getTag() == "X" && button22.getTag() == "X"){
                        textView.setText(player1 + " wins! Would you like to play again or quit?");
                        playAgainButton.setVisibility(View.VISIBLE);
                        turnImage.setImageResource(R.drawable.alien);
                        button00.setClickable(false);
                        button01.setClickable(false);
                        button02.setClickable(false);
                        button10.setClickable(false);
                        button11.setClickable(false);
                        button12.setClickable(false);
                        button20.setClickable(false);
                        button21.setClickable(false);
                        button22.setClickable(false);
                    } if(button00.getTag() == "X" && button10.getTag() == "X" && button20.getTag() == "X"){
                        textView.setText(player1 + " wins! Would you like to play again or quit?");
                        playAgainButton.setVisibility(View.VISIBLE);
                        turnImage.setImageResource(R.drawable.alien);
                        button00.setClickable(false);
                        button01.setClickable(false);
                        button02.setClickable(false);
                        button10.setClickable(false);
                        button11.setClickable(false);
                        button12.setClickable(false);
                        button20.setClickable(false);
                        button21.setClickable(false);
                        button22.setClickable(false);
                    } if(button01.getTag() == "X" && button11.getTag() == "X" && button21.getTag() == "X"){
                        textView.setText(player1 + " wins! Would you like to play again or quit?");
                        playAgainButton.setVisibility(View.VISIBLE);
                        turnImage.setImageResource(R.drawable.alien);
                        button00.setClickable(false);
                        button01.setClickable(false);
                        button02.setClickable(false);
                        button10.setClickable(false);
                        button11.setClickable(false);
                        button12.setClickable(false);
                        button20.setClickable(false);
                        button21.setClickable(false);
                        button22.setClickable(false);
                    } if(button02.getTag() == "X" && button12.getTag() == "X" && button22.getTag() == "X"){
                        textView.setText(player1 + " wins! Would you like to play again or quit?");
                        playAgainButton.setVisibility(View.VISIBLE);
                        turnImage.setImageResource(R.drawable.alien);
                        button00.setClickable(false);
                        button01.setClickable(false);
                        button02.setClickable(false);
                        button10.setClickable(false);
                        button11.setClickable(false);
                        button12.setClickable(false);
                        button20.setClickable(false);
                        button21.setClickable(false);
                        button22.setClickable(false);
                    } if(button00.getTag() == "X" && button11.getTag() == "X" && button22.getTag() == "X"){
                        textView.setText(player1 + " wins! Would you like to play again or quit?");
                        playAgainButton.setVisibility(View.VISIBLE);
                        turnImage.setImageResource(R.drawable.alien);
                        button00.setClickable(false);
                        button01.setClickable(false);
                        button02.setClickable(false);
                        button10.setClickable(false);
                        button11.setClickable(false);
                        button12.setClickable(false);
                        button20.setClickable(false);
                        button21.setClickable(false);
                        button22.setClickable(false);
                    } if(button20.getTag() == "X" && button21.getTag() == "X" && button02.getTag() == "X"){
                        textView.setText(player1 + " wins! Would you like to play again or quit?");
                        playAgainButton.setVisibility(View.VISIBLE);
                        turnImage.setImageResource(R.drawable.alien);
                        button00.setClickable(false);
                        button01.setClickable(false);
                        button02.setClickable(false);
                        button10.setClickable(false);
                        button11.setClickable(false);
                        button12.setClickable(false);
                        button20.setClickable(false);
                        button21.setClickable(false);
                        button22.setClickable(false);
                    }

                    playerTurn = false;
                    imageView.setImageResource((R.drawable.alien));
                }
            } else {
                if (imageView.isClickable()) {
                    turnImage.setImageResource(R.drawable.alien);
                    textView.setText("It is " + player1 + "'s turn");
                    imageView.setTag("O");
                    imageView.setClickable(false);

                    if(!button00.isClickable() && !button01.isClickable() && !button02.isClickable()
                            && !button10.isClickable() && !button11.isClickable() && !button12.isClickable()
                            && !button20.isClickable() && !button21.isClickable() && !button22.isClickable()){
                        textView.setText("Cat Game!! That means it was a good match! Would you like to play again or quit?");
                        playAgainButton.setVisibility(View.VISIBLE);
                    } if(button00.getTag() == "O" && button01.getTag() == "O" && button02.getTag() == "O"){
                        textView.setText(player2 + " wins! Would you like to play again or quit?");
                        playAgainButton.setVisibility(View.VISIBLE);
                        button00.setClickable(false);
                        button01.setClickable(false);
                        button02.setClickable(false);
                        button10.setClickable(false);
                        button11.setClickable(false);
                        button12.setClickable(false);
                        button20.setClickable(false);
                        button21.setClickable(false);
                        button22.setClickable(false);
                        turnImage.setImageResource(R.drawable.astronaut);
                    } if(button10.getTag() == "O" && button11.getTag() == "O" && button12.getTag() == "O"){
                        textView.setText(player2 + " wins! Would you like to play again or quit?");
                        playAgainButton.setVisibility(View.VISIBLE);
                        button00.setClickable(false);
                        button01.setClickable(false);
                        button02.setClickable(false);
                        button10.setClickable(false);
                        button11.setClickable(false);
                        button12.setClickable(false);
                        button20.setClickable(false);
                        button21.setClickable(false);
                        button22.setClickable(false);
                        turnImage.setImageResource(R.drawable.astronaut);
                    } if(button20.getTag() == "O" && button21.getTag() == "O" && button22.getTag() == "O"){
                        textView.setText(player2 + " wins! Would you like to play again or quit?");
                        playAgainButton.setVisibility(View.VISIBLE);
                        button00.setClickable(false);
                        button01.setClickable(false);
                        button02.setClickable(false);
                        button10.setClickable(false);
                        button11.setClickable(false);
                        button12.setClickable(false);
                        button20.setClickable(false);
                        button21.setClickable(false);
                        button22.setClickable(false);
                        turnImage.setImageResource(R.drawable.astronaut);
                    } if(button00.getTag() == "O" && button10.getTag() == "O" && button20.getTag() == "O"){
                        textView.setText(player2 + " wins! Would you like to play again or quit?");
                        playAgainButton.setVisibility(View.VISIBLE);
                        button00.setClickable(false);
                        button01.setClickable(false);
                        button02.setClickable(false);
                        button10.setClickable(false);
                        button11.setClickable(false);
                        button12.setClickable(false);
                        button20.setClickable(false);
                        button21.setClickable(false);
                        button22.setClickable(false);
                        turnImage.setImageResource(R.drawable.astronaut);
                    } if(button01.getTag() == "O" && button11.getTag() == "O" && button21.getTag() == "O"){
                        textView.setText(player2 + " wins! Would you like to play again or quit?");
                        playAgainButton.setVisibility(View.VISIBLE);
                        button00.setClickable(false);
                        button01.setClickable(false);
                        button02.setClickable(false);
                        button10.setClickable(false);
                        button11.setClickable(false);
                        button12.setClickable(false);
                        button20.setClickable(false);
                        button21.setClickable(false);
                        button22.setClickable(false);
                        turnImage.setImageResource(R.drawable.astronaut);
                    } if(button02.getTag() == "O" && button12.getTag() == "O" && button22.getTag() == "O"){
                        textView.setText(player2 + " wins! Would you like to play again or quit?");
                        playAgainButton.setVisibility(View.VISIBLE);
                        button00.setClickable(false);
                        button01.setClickable(false);
                        button02.setClickable(false);
                        button10.setClickable(false);
                        button11.setClickable(false);
                        button12.setClickable(false);
                        button20.setClickable(false);
                        button21.setClickable(false);
                        button22.setClickable(false);
                        turnImage.setImageResource(R.drawable.astronaut);
                    } if(button00.getTag() == "O" && button11.getTag() == "O" && button22.getTag() == "O"){
                        textView.setText(player2 + " wins! Would you like to play again or quit?");
                        playAgainButton.setVisibility(View.VISIBLE);
                        button00.setClickable(false);
                        button01.setClickable(false);
                        button02.setClickable(false);
                        button10.setClickable(false);
                        button11.setClickable(false);
                        button12.setClickable(false);
                        button20.setClickable(false);
                        button21.setClickable(false);
                        button22.setClickable(false);
                        turnImage.setImageResource(R.drawable.astronaut);
                    } if(button20.getTag() == "O" && button21.getTag() == "O" && button02.getTag() == "O"){
                        textView.setText(player2 + " wins! Would you like to play again or quit?");
                        playAgainButton.setVisibility(View.VISIBLE);
                        button00.setClickable(false);
                        button01.setClickable(false);
                        button02.setClickable(false);
                        button10.setClickable(false);
                        button11.setClickable(false);
                        button12.setClickable(false);
                        button20.setClickable(false);
                        button21.setClickable(false);
                        button22.setClickable(false);
                        turnImage.setImageResource(R.drawable.astronaut);
                    }

                    playerTurn = true;
                    imageView.setImageResource((R.drawable.astronaut));
                }
            }
    }
}
