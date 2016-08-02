package pl.edu.uksw.fixmath;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gameplay extends AppCompatActivity {
    int[] elements = new int[5];
    static int currLevel = 1;
    Random rnd = new Random();
    int numOfFigures;
    static int lifes = 3;

    LinearLayout[] lls = new LinearLayout[6];
    LinearLayout container;
    GridLayout answearContainer;
    Button checkBtn;
    TextView tvLevel;
    EditText answear1;
    EditText answear2;
    EditText answear3;
    EditText answear4;
    EditText answear5;
    ImageView lifeNr1Img;
    ImageView lifeNr2Img;
    ImageView lifeNr3Img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameplay);

        currLevel = 1;
        lifes = 3;

        container = (LinearLayout) findViewById(R.id.container);
        answearContainer = (GridLayout) findViewById(R.id.answearContainer);
        tvLevel = (TextView) findViewById(R.id.tvLevel);
        answear1 = (EditText) findViewById(R.id.answear1);
        answear2 = (EditText) findViewById(R.id.answear2);
        answear3 = (EditText) findViewById(R.id.answear3);
        answear4 = (EditText) findViewById(R.id.answear4);
        answear5 = (EditText) findViewById(R.id.answear5);
        checkBtn = (Button) findViewById(R.id.checkBtn);
        lifeNr1Img = (ImageView) findViewById(R.id.lifeNr1);
        lifeNr2Img = (ImageView) findViewById(R.id.lifeNr2);
        lifeNr3Img = (ImageView) findViewById(R.id.lifeNr3);

        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!answear1.getText().toString().isEmpty()){
                    int value = Integer.valueOf(answear1.getText().toString());
                    if(value!=elements[0]){
                        LostLife();
                        return;
                    }
                }else {
                    LostLife();
                    return;
                }

                if(numOfFigures >= 2){
                    if(!answear2.getText().toString().isEmpty()){
                        int value = Integer.valueOf(answear2.getText().toString());
                        if(value!=elements[1]){
                            LostLife();
                            return;
                        }
                    }else {
                        LostLife();
                        return;
                    }
                }
                if(numOfFigures >= 3){
                    if(!answear3.getText().toString().isEmpty()){
                        int value = Integer.valueOf(answear3.getText().toString());
                        if(value!=elements[2]){
                            LostLife();
                            return;
                        }
                    }else {
                        LostLife();
                        return;
                    }
                }
                if(numOfFigures >= 4){
                    if(!answear4.getText().toString().isEmpty()){
                        int value = Integer.valueOf(answear4.getText().toString());
                        if(value!=elements[3]){
                            LostLife();
                            return;
                        }
                    }else {
                        LostLife();
                        return;
                    }
                }
                if(numOfFigures >= 5){
                    if(!answear5.getText().toString().isEmpty()){
                        int value = Integer.valueOf(answear5.getText().toString());
                        if(value!=elements[4]){
                            LostLife();
                            return;
                        }
                    }else {
                        LostLife();
                        return;
                    }
                }
                loadLevel(++Gameplay.currLevel);
            }
        });

        loadLevel(Gameplay.currLevel);
    }

    private void LostLife(){
        --Gameplay.lifes;
        if(Gameplay.lifes == 2){
            lifeNr1Img.setVisibility(View.INVISIBLE);
        }else if(Gameplay.lifes == 1){
            lifeNr2Img.setVisibility(View.INVISIBLE);
        }else if(Gameplay.lifes == 0){
            lifeNr3Img.setVisibility(View.INVISIBLE);
        }else {
            LostGame();
        }
    }

    private void LostGame(){
        Intent mainActivity = new Intent(this, MainActivity.class);
        mainActivity.putExtra("SCORES", Gameplay.currLevel);
        mainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        Gameplay.currLevel = 1;
        Gameplay.lifes = 3;
        startActivity(mainActivity);
    }

    private void loadLevel(int level){
        container.removeAllViews();
        tvLevel.setText(getResources().getString(R.string.level)+" " + String.valueOf(level));

        LinearLayout equation1 = new LinearLayout(this);
        equation1.setOrientation(LinearLayout.HORIZONTAL);
        equation1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        equation1.setPadding(0, 5, 0, 5);
        equation1.setVerticalGravity(Gravity.CENTER_VERTICAL);
        lls[0] = equation1;
        LinearLayout equation2 = new LinearLayout(this);
        equation2.setOrientation(LinearLayout.HORIZONTAL);
        equation2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        equation2.setPadding(0, 5, 0, 5);
        equation2.setVerticalGravity(Gravity.CENTER_VERTICAL);
        lls[1] = equation2;
        LinearLayout equation3 = new LinearLayout(this);
        equation3.setOrientation(LinearLayout.HORIZONTAL);
        equation3.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        equation3.setPadding(0, 5, 0, 5);
        equation3.setVerticalGravity(Gravity.CENTER_VERTICAL);
        lls[2] = equation3;
        LinearLayout equation4 = new LinearLayout(this);
        equation4.setOrientation(LinearLayout.HORIZONTAL);
        equation4.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        equation4.setPadding(0, 5, 0, 5);
        equation4.setVerticalGravity(Gravity.CENTER_VERTICAL);
        lls[3] = equation4;
        LinearLayout equation5 = new LinearLayout(this);
        equation5.setOrientation(LinearLayout.HORIZONTAL);
        equation5.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        equation5.setPadding(0, 5, 0, 5);
        equation5.setVerticalGravity(Gravity.CENTER_VERTICAL);
        lls[4] = equation5;
        LinearLayout equation6 = new LinearLayout(this);
        equation6.setOrientation(LinearLayout.HORIZONTAL);
        equation6.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        equation6.setPadding(0, 5, 0, 5);
        equation6.setVerticalGravity(Gravity.CENTER_VERTICAL);
        lls[5] = equation6;

        container.addView(equation1);
        container.addView(equation2);
        container.addView(equation3);
        container.addView(equation4);
        container.addView(equation5);
        container.addView(equation6);

        setRandomElements(level);

        if(level < 2){
            numOfFigures = 1;
            answear1.setVisibility(View.VISIBLE);
            answear1.setText("");
            answear2.setVisibility(View.GONE);
            answear3.setVisibility(View.GONE);
            answear4.setVisibility(View.GONE);
            answear5.setVisibility(View.GONE);
        }else if(level < 6){
            numOfFigures = 2;
            answear1.setVisibility(View.VISIBLE);
            answear2.setVisibility(View.VISIBLE);
            answear1.setText("");
            answear2.setText("");
            answear3.setVisibility(View.GONE);
            answear4.setVisibility(View.GONE);
            answear5.setVisibility(View.GONE);
        }else if(level < 11){
            numOfFigures = 3;
            answear1.setVisibility(View.VISIBLE);
            answear2.setVisibility(View.VISIBLE);
            answear3.setVisibility(View.VISIBLE);
            answear1.setText("");
            answear2.setText("");
            answear3.setText("");
            answear4.setVisibility(View.GONE);
            answear5.setVisibility(View.GONE);
        }else if(level < 20){
            numOfFigures = 4;
            answear1.setVisibility(View.VISIBLE);
            answear2.setVisibility(View.VISIBLE);
            answear3.setVisibility(View.VISIBLE);
            answear4.setVisibility(View.VISIBLE);
            answear1.setText("");
            answear2.setText("");
            answear3.setText("");
            answear4.setText("");
            answear5.setVisibility(View.GONE);
        }else {
            numOfFigures = 5;
            answearContainer.setColumnCount(3);
            answear1.setVisibility(View.VISIBLE);
            answear2.setVisibility(View.VISIBLE);
            answear3.setVisibility(View.VISIBLE);
            answear4.setVisibility(View.VISIBLE);
            answear5.setVisibility(View.VISIBLE);
            answear1.setText("");
            answear2.setText("");
            answear3.setText("");
            answear4.setText("");
            answear5.setText("");
        }

        int numOfEquations;

        if(level < 2){
            numOfEquations = 1;
        }else if(level < 6){
            numOfEquations = 2;
        }else if(level < 11){
            numOfEquations = 3;
        }else if(level < 20){
            numOfEquations = 4;
        }else {
            numOfEquations = 5;
        }

        for(int i = 0; i<numOfEquations; ++i) {
            int sum = 0;
            int max = i > numOfFigures?numOfFigures:i+1;
            List<Integer> usedIds = new ArrayList<>();
            for(int j = 0; j<numOfEquations; ++j) {
                int figID = rnd.nextInt(max);
                if(j<max) {
                    while (usedIds.contains(figID)) {
                        figID = rnd.nextInt(max);
                    }
                    usedIds.add(figID);
                }
                sum += elements[figID];
                ImageView imgView = new ImageView(this);
                imgView.setScaleType(ImageView.ScaleType.FIT_XY);

                final float scale = getResources().getDisplayMetrics().density;
                int heightPixels = (int) (getResources().getDimension(R.dimen.textSizeMedium) * scale + 0.5f);
                int widthPixels = (int) (getResources().getDimension(R.dimen.textSizeMedium) * scale + 0.5f);

                LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(widthPixels,heightPixels);
                imgView.setLayoutParams(parms);

                if(figID==0) {
                    imgView.setImageResource(R.drawable.shape1);
                }else if(figID==1) {
                    imgView.setImageResource(R.drawable.shape2);
                }else if(figID==2) {
                    imgView.setImageResource(R.drawable.shape3);
                }else if(figID==3) {
                    imgView.setImageResource(R.drawable.shape4);
                }else if(figID==4) {
                    imgView.setImageResource(R.drawable.shape5);
                }else if(figID==5) {
                    imgView.setImageResource(R.drawable.shape6);
                }
                lls[i].addView(imgView);
                if(j!= numOfEquations-1) {
                    TextView plusSignTV = new TextView(this);
                    plusSignTV.setText("+");
                    plusSignTV.setTextSize(getResources().getDimension(R.dimen.textSizeMedium));
                    lls[i].addView(plusSignTV);
                }else{
                    TextView equalSignTV = new TextView(this);
                    equalSignTV.setText("=");
                    equalSignTV.setTextSize(getResources().getDimension(R.dimen.textSizeMedium));
                    lls[i].addView(equalSignTV);
                }
            }
            TextView sumTV = new TextView(this);
            sumTV.setText(String.valueOf(sum));
            sumTV.setTextSize(getResources().getDimension(R.dimen.textSizeMedium));
            lls[i].addView(sumTV);
        }
    }

    void setRandomElements(int level){
        elements[0] = rnd.nextInt(level*5);
        while(true) {
            elements[1] = rnd.nextInt(level*5);
            if(elements[1]!=elements[0]){
                break;
            }
        }
        while(true) {
            elements[2] = rnd.nextInt(level*5);
            if(elements[2]!=elements[0] && elements[2]!=elements[1]){
                break;
            }
        }
        while(true) {
            elements[3] = rnd.nextInt(level*5);
            if(elements[3]!=elements[0] && elements[3]!=elements[1] && elements[3]!=elements[2]){
                break;
            }
        }
        while(true) {
            elements[4] = rnd.nextInt(level*5);
            if(elements[4]!=elements[0] && elements[4]!=elements[1] && elements[4]!=elements[2] && elements[4]!=elements[3]){
                break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
