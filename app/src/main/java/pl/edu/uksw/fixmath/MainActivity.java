package pl.edu.uksw.fixmath;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import ru.katso.livebutton.LiveButton;

public class MainActivity extends AppCompatActivity {

    TextView scores;
    TextView bestScores;

    LiveButton newGameBtn;
    LiveButton exitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newGameBtn = (LiveButton)findViewById(R.id.playBtn);
        newGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadGameplayActivity(view);
            }
        });

        exitBtn = (LiveButton)findViewById(R.id.exitBtn);
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitGame(view);
            }
        });

        SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        int best = prefs.getInt("key", 0);

        int lastScores = getIntent().getIntExtra("SCORES", 0);
        if (lastScores != 0) {
            scores = (TextView) findViewById(R.id.scores);
            scores.setText(getResources().getString(R.string.current_score)+"\n"+String.valueOf(lastScores));
            scores.setVisibility(View.VISIBLE);

            if(lastScores > best) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("key", lastScores);
                editor.commit();
                best = lastScores;
            }
        }

        bestScores = (TextView) findViewById(R.id.bestScores);
        bestScores.setText(getResources().getString(R.string.best_score)+"\n"+String.valueOf(best));
    }

    public void loadGameplayActivity(View view) {
        Intent intent = new Intent(this, Gameplay.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void exitGame(View view) {
        this.finish();
        System.exit(0);
    }

    @Override
    public void onBackPressed() {}
}
