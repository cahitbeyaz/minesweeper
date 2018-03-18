package minesweeper.mustafa.minesweeper.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.res.FontResourcesParserCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.honorato.multistatetogglebutton.MultiStateToggleButton;
import org.honorato.multistatetogglebutton.ToggleButton;

import minesweeper.mustafa.minesweeper.R;
import minesweeper.mustafa.minesweeper.game.GameActivity;
import minesweeper.mustafa.minesweeper.game.GameLevel;
import minesweeper.mustafa.minesweeper.game.GameOptions;

/**
 * Created by CahitB1 on 18.3.2018.
 */

public class WelcomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        MultiStateToggleButton btnGameLevel = (MultiStateToggleButton) this.findViewById(R.id.btnGameLevel);
        btnGameLevel.setValue(0);
        Button btnStartGame=findViewById(R.id.btnStartGame);
        btnStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(WelcomeActivity.this, GameActivity.class);
                startActivity(myIntent);
            }
        });

        btnGameLevel.setOnValueChangedListener(new ToggleButton.OnValueChangedListener() {
            @Override
            public void onValueChanged(int position) {
                switch (position){
                    case 0:

                        GameOptions.gameLevel= GameLevel.Easy;
                        break;

                    case 1:
                        GameOptions.gameLevel= GameLevel.Medium;
                        break;
                    case 2:
                        GameOptions.gameLevel= GameLevel.Hard;
                        break;
                        default:
                            GameOptions.gameLevel= GameLevel.Easy;
                            break;
                }
            }
        });

        MultiStateToggleButton btnSound = this.findViewById(R.id.btnSound);
        btnSound.setValue(0);
        btnSound.setOnValueChangedListener(new ToggleButton.OnValueChangedListener() {
            @Override
            public void onValueChanged(int position) {
                if (position==0){
                GameOptions.soundOn=true;
                }
                else if (   position==1){
                    GameOptions.soundOn=false;
                }
            }
        });
    }
}
