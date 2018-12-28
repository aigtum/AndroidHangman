package id1212.androidhangman;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import id1212.androidhangman.hangman.Game;

public class MainActivity extends AppCompatActivity {
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupActivity();
        game = new Game();
    }


    private void formatView(String msg) {
        System.out.println(msg);
        String[] split = msg.split("/");
        String gameTries = "Tries left: " + split[1];
        String gameWord = split[2];
        String gameScore = "Your score: " + split[0];
        String gameMessage = split[3];


        TextView word = (TextView) findViewById(R.id.word);
        word.setText(gameWord);
        TextView score = (TextView) findViewById(R.id.score);
        score.setText(gameScore);
        TextView tries = (TextView) findViewById(R.id.tries);
        tries.setText(gameTries);
        TextView message = (TextView) findViewById(R.id.message);
        switch (gameMessage) {
            case "cg":
                message.setText("Correct guess!");
                break;
            case "wg":
                message.setText("Wrong guess!");
                break;
            case "n":
                message.setText("New game");
                break;
            case "r":
                message.setText("Restarted");
                break;
            case "w":
                message.setText("You win!");
                break;
            case "l":
                message.setText("You lose!");
                break;
        }

    }

    private void setupActivity() {
        final Button enterButton = (Button) findViewById(R.id.enterBtn);
        enterButton.setEnabled(false);
        final Button startGameButton = (Button) findViewById(R.id.newGameButton);
        EditText inputText = (EditText) findViewById(R.id.guess);

        // react on user input
        enterButton.setOnClickListener((v) -> {
            String entry = inputText.getText().toString();
            formatView(game.gameEntry(entry));
            inputText.setText("");
        });

        // start new game
        startGameButton.setOnClickListener((v) -> {
            game.setContext(v.getContext());

            if (startGameButton.getText().equals("New Word")) {
                String msg = game.startGame("newGame");
                formatView(msg);
                enterButton.setEnabled(true);
            } else {
                String msg = game.restart("restart");
                formatView(msg);
            }
            startGameButton.setText("RESTART");
        });


    }
}
