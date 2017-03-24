package com.example.android.tabletennis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int scorePlayerA = 0;
    int scorePlayerB = 0;
    int setTeamA = 0;
    int setTeamB = 0;
    int foulCounter = 0;
    int foulCounterB = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayForPlayerA(int scoreTeamA) {
        TextView scoreTeamAView = (TextView) findViewById(R.id.player_a_score);
        scoreTeamAView.setText(String.valueOf(scoreTeamA));
    }

    public void displayForPlayerB(int scoreTeamB) {
        TextView scoreTeamBView = (TextView) findViewById(R.id.player_b_score);
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
        if (scorePlayerA >= 11 && (scorePlayerA - scorePlayerB) >= 2) {
            scorePlayerA = 0;
            scorePlayerB = 0;
            setTeamA = setTeamA + 1;
            displayForPlayerA(scorePlayerA);
            displayForPlayerB(scorePlayerB);
            displayForSetA(setTeamA);
        } else if (scorePlayerB >= 11 && (scorePlayerB - scorePlayerA) >= 2) {
            scorePlayerA = 0;
            scorePlayerB = 0;
            setTeamB = setTeamB + 1;
            displayForPlayerA(scorePlayerA);
            displayForPlayerB(scorePlayerB);
            displayForSetB(setTeamB);
        } else if (scorePlayerA < 11 || ((scorePlayerA - scorePlayerB) <= 1)) {
            scorePlayerA = scorePlayerA + 1;
            displayForPlayerA(scorePlayerA);
        }
    }


    // The 'plusb' method increases the score for Team B and checks if Team B already won the game
    // If Team A won the game the game points for Team A and Team B are reset to 0 and Set value for Team B increased with 1
    public void plusb(View view) {
        if (scorePlayerB >= 11 && (scorePlayerB - scorePlayerA) >= 2) {
            scorePlayerA = 0;
            scorePlayerB = 0;
            setTeamB = setTeamB + 1;
            displayForPlayerA(scorePlayerA);
            displayForPlayerB(scorePlayerB);
            displayForSetB(setTeamB);
        } else if (scorePlayerA >= 11 && (scorePlayerA - scorePlayerB) >= 2) {
            scorePlayerA = 0;
            scorePlayerB = 0;
            setTeamA = setTeamA + 1;
            displayForPlayerA(scorePlayerA);
            displayForPlayerB(scorePlayerB);
            displayForSetA(setTeamA);
        } else if (scorePlayerB < 11 || ((scorePlayerB - scorePlayerA) <= 1)) {
            scorePlayerB = scorePlayerB + 1;
            displayForPlayerB(scorePlayerB);
        }
    }

    //Reset button functionality
    public void reset(View view) {
        scorePlayerA = 0;
        scorePlayerB = 0;
        setTeamA = 0;
        setTeamB = 0;
        foulCounter = 0;
        foulCounterB = 0;

        displayForPlayerA(scorePlayerA);
        displayForPlayerB(scorePlayerB);
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
            if (scorePlayerB >= 11 && (scorePlayerB - scorePlayerA) >= 2) {
                scorePlayerA = 0;
                scorePlayerB = 0;
                setTeamB = setTeamB + 1;
                displayForPlayerA(scorePlayerA);
                displayForPlayerB(scorePlayerB);
                displayForSetB(setTeamB);
            } else if (scorePlayerA >= 11 && (scorePlayerA - scorePlayerB) >= 2) {
                scorePlayerA = 0;
                scorePlayerB = 0;
                setTeamA = setTeamA + 1;
                displayForPlayerA(scorePlayerA);
                displayForPlayerB(scorePlayerB);
                displayForSetA(setTeamA);
            } else if (scorePlayerB < 11 || ((scorePlayerB - scorePlayerA) <= 1)) {
                scorePlayerB = scorePlayerB + 1;
                displayForPlayerB(scorePlayerB);
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
            if (scorePlayerA >= 11 && (scorePlayerA - scorePlayerB) >= 2) {
                scorePlayerA = 0;
                scorePlayerB = 0;
                setTeamA = setTeamA + 1;
                displayForPlayerA(scorePlayerA);
                displayForPlayerB(scorePlayerB);
                displayForSetA(setTeamA);
            } else if (scorePlayerB >= 11 && (scorePlayerB - scorePlayerA) >= 2) {
                scorePlayerA = 0;
                scorePlayerB = 0;
                setTeamB = setTeamB + 1;
                displayForPlayerA(scorePlayerA);
                displayForPlayerB(scorePlayerB);
                displayForSetB(setTeamB);
            } else if (scorePlayerA < 11 || ((scorePlayerA - scorePlayerB) <= 1)) {
                scorePlayerA = scorePlayerA + 1;
                displayForPlayerA(scorePlayerA);
            }
        }
    }

}
