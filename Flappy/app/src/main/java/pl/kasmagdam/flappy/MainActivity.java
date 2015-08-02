package pl.kasmagdam.flappy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import pl.kasmagdam.pl.kasmagdam.framework.implementation.AndroidGame;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button newGameButton = (Button) findViewById(R.id.new_game_button);
        final Intent intent = new Intent(this, AndroidGame.class);
        newGameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        final Button instructionsButton = (Button) findViewById(R.id.instructions_button);
        final Intent intent2 = new Intent(this, AndroidGame.class);
        instructionsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intent2);
            }
        });

        final Button scoresButton = (Button) findViewById(R.id.scores_button);
        final Intent intent3 = new Intent(this, ScoresActivity.class);
        scoresButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intent3);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*public void startGame(Intent intent) {
        Intent intent = new Intent(this, AndroidGame.class);
        startActivity(intent);

    }*/
}
