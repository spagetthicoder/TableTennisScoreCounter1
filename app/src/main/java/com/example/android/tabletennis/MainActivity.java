package com.example.android.tabletennis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int setTeamA = 0;
    int setTeamB = 0;
    int foulCounter = 0;
    int foulCounterB = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayForTeamA(int scoreTeamA) {
        TextView scoreTeamAView = (TextView) findViewById(R.id.team_a_score);
        scoreTeamAView.setText(String.valueOf(scoreTeamA));
    }

    public void displayForTeamB(int scoreTeamB) {
        TextView scoreTeamBView = (TextView) findViewById(R.id.team_b_score);
        scoreTeamBView.setText(String.valueOf(scoreTeamB));
    }

    public void displayForSetA(int setTeamA) {
        TextView setTeamAView = (TextView) findViewById(R.id.sets_a_score);
        setTeamAView.setText(String.valueOf(setTeamA));
    }

    public void displayForSetB(int setTeamB) {
        TextView setTeamBView = (TextView) findViewById(R.id.sets_b_score);
        setTeamBView.setText(String.valueOf(setTeamB));
    }

    public void displayForFoulA(boolean foulColor) {
        TextView setFoulA = (TextView) findViewById(R.id.set_a_foul);
        setFoulA.setTextColor(this.getResources().getColor(R.color.red));
    }

    private void displayForFoulAWhite(boolean foulCount) {
        TextView setFoulA = (TextView) findViewById(R.id.set_a_foul);
        setFoulA.setTextColor(this.getResources().getColor(R.color.white));
    }

    public void displayForFoulB(boolean foulColor) {
        TextView setFoulA = (TextView) findViewById(R.id.set_a_foulb);
        setFoulA.setTextColor(this.getResources().getColor(R.color.red));
    }

    private void displayForFoulBWhite(boolean foulCount) {
        TextView setFoulA = (TextView) findViewById(R.id.set_a_foulb);
        setFoulA.setTextColor(this.getResources().getColor(R.color.white));
    }

    // The 'plus' method increases the score for Team A appropriately and checks if Team A already won the game
    // If Team A won the game the game points for Team A and Team B are reset to 0 and Set value for Team A increased with 1
    public void plus(View view) {
        if (scoreTeamA >= 11 && (scoreTeamA - scoreTeamB) >= 2) {
            scoreTeamA = 0;
            scoreTeamB = 0;
            setTeamA = setTeamA + 1;
            displayForTeamA(scoreTeamA);
            displayForTeamB(scoreTeamB);
            displayForSetA(setTeamA);
        } else if (scoreTeamB >= 11 && (scoreTeamB - scoreTeamA) >= 2) {
            scoreTeamA = 0;
            scoreTeamB = 0;
            setTeamB = setTeamB + 1;
            displayForTeamA(scoreTeamA);
            displayForTeamB(scoreTeamB);
            displayForSetB(setTeamB);
        } else if (scoreTeamA < 11 || ((scoreTeamA - scoreTeamB) <= 1)) {
            scoreTeamA = scoreTeamA + 1;
            displayForTeamA(scoreTeamA);
        }
    }


    // The 'plusb' method increases the score for Team B and checks if Team B already won the game
    // If Team A won the game the game points for Team A and Team B are reset to 0 and Set value for Team B increased with 1
    public void plusb(View view) {
        if (scoreTeamB >= 11 && (scoreTeamB - scoreTeamA) >= 2) {
            scoreTeamA = 0;
            scoreTeamB = 0;
            setTeamB = setTeamB + 1;
            displayForTeamA(scoreTeamA);
            displayForTeamB(scoreTeamB);
            displayForSetB(setTeamB);
        } else if (scoreTeamA >= 11 && (scoreTeamA - scoreTeamB) >= 2) {
            scoreTeamA = 0;
            scoreTeamB = 0;
            setTeamA = setTeamA + 1;
            displayForTeamA(scoreTeamA);
            displayForTeamB(scoreTeamB);
            displayForSetA(setTeamA);
        } else if (scoreTeamB < 11 || ((scoreTeamB - scoreTeamA) <= 1)) {
            scoreTeamB = scoreTeamB + 1;
            displayForTeamB(scoreTeamB);
        }
    }

    //Reset button functionality
    public void reset(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        setTeamA = 0;
        setTeamB = 0;
        foulCounter = 0;
        foulCounterB = 0;

        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayForSetA(setTeamA);
        displayForSetB(setTeamB);
        displayForFoulAWhite(true);
        displayForFoulBWhite(true);
    }

    //Foul button functionality for Player A
    public void foula(View view) {
        if (foulCounter == 0) {
            foulCounter = foulCounter + 1;
            displayForFoulA(true);
        } else if (foulCounter > 0) {
            displayForFoulAWhite(true);
            foulCounter = 0;
            if (scoreTeamB >= 11 && (scoreTeamB - scoreTeamA) >= 2) {
                scoreTeamA = 0;
                scoreTeamB = 0;
                setTeamB = setTeamB + 1;
                displayForTeamA(scoreTeamA);
                displayForTeamB(scoreTeamB);
                displayForSetB(setTeamB);
            } else if (scoreTeamA >= 11 && (scoreTeamA - scoreTeamB) >= 2) {
                scoreTeamA = 0;
                scoreTeamB = 0;
                setTeamA = setTeamA + 1;
                displayForTeamA(scoreTeamA);
                displayForTeamB(scoreTeamB);
                displayForSetA(setTeamA);
            } else if (scoreTeamB < 11 || ((scoreTeamB - scoreTeamA) <= 1)) {
                scoreTeamB = scoreTeamB + 1;
                displayForTeamB(scoreTeamB);
            }
        }
    }

    //Foul button functionality for Player B
    public void foulb(View view) {
        if (foulCounterB == 0) {
            foulCounterB = foulCounterB + 1;
            displayForFoulB(true);
        } else if (foulCounterB > 0) {
            displayForFoulBWhite(true);
            foulCounterB = 0;
            if (scoreTeamA >= 11 && (scoreTeamA - scoreTeamB) >= 2) {
                scoreTeamA = 0;
                scoreTeamB = 0;
                setTeamA = setTeamA + 1;
                displayForTeamA(scoreTeamA);
                displayForTeamB(scoreTeamB);
                displayForSetA(setTeamA);
            } else if (scoreTeamB >= 11 && (scoreTeamB - scoreTeamA) >= 2) {
                scoreTeamA = 0;
                scoreTeamB = 0;
                setTeamB = setTeamB + 1;
                displayForTeamA(scoreTeamA);
                displayForTeamB(scoreTeamB);
                displayForSetB(setTeamB);
            } else if (scoreTeamA < 11 || ((scoreTeamA - scoreTeamB) <= 1)) {
                scoreTeamA = scoreTeamA + 1;
                displayForTeamA(scoreTeamA);
            }
        }
    }

}
