
/**This function is for the welcoming screen of the app that prepares the driver
 * Oct. 22nd, 2019
 * PA5
 * Dr. Sprint
 * @author Carter Mooring
 * @sources <div>Icons made by <a href="https://www.flaticon.com/authors/smalllikeart"
 * title="smalllikeart">smalllikeart</a>
 * from <a href="https://www.flaticon.com/"
 * title="Flaticon">www.flaticon.com</a></div>
 * @sources <div>Icons made by <a href="https://www.flaticon.com/authors/smalllikeart"
 * title="smalllikeart">smalllikeart</a>
 * from <a href="https://www.flaticon.com/"
 * title="Flaticon">www.flaticon.com</a></div>
 */
package com.CarterMooring.tictactoeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WelcomeActivity extends AppCompatActivity {
    static final String TAG = "TAG";

    @Override
    //Oncreate function for when the user first opens the app
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playButton = (Button) findViewById(R.id.playButton);
        final EditText P1EditText = (EditText) findViewById(R.id.P1EditText);
        final EditText P2EditText = (EditText) findViewById(R.id.P2EditText);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            //when the user clicks play the names are sent to the other board
            public void onClick(View v) {
                String player1 = P1EditText.getText().toString();
                String player2 = P2EditText.getText().toString();
                Log.d(TAG, "onClick: ");

                Intent intent = new Intent(WelcomeActivity.this, GameActivity.class);
                intent.putExtra("player1", player1);
                intent.putExtra("player2", player2);

                if(player1.length() > 0 && player2.length() > 0) {
                    startActivity(intent);
                }
            }
        });
    }
}
