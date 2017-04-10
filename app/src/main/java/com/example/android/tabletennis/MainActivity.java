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

    private TextView scoreTeamAView;
    private TextView scoreTeamBView;
    private TextView setTeamAView;
    private TextView setTeamBView;
    private TextView setFoulA;
    private TextView setFoulB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null){
            scorePlayerA = savedInstanceState.getInt("SCORE_TEAM_A");
            scorePlayerB = savedInstanceState.getInt("SCORE_TEAM_B");
            setTeamA = savedInstanceState.getInt("SET_TEAM_A");
            setTeamB = savedInstanceState.getInt("SET_TEAM_B");
        }

        setContentView(R.layout.activity_main);

        scoreTeamAView = (TextView) findViewById(R.id.player_a_score);
        scoreTeamBView = (TextView) findViewById(R.id.player_b_score);
        setTeamAView = (TextView) findViewById(R.id.sets_a_score);
        setTeamBView = (TextView) findViewById(R.id.sets_b_score);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("SCORE_TEAM_A", scorePlayerA);
        outState.putInt("SCORE_TEAM_B", scorePlayerB);
        outState.putInt("SET_TEAM_A", setTeamA);
        outState.putInt("SET_TEAM_B", setTeamB);

        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        scoreTeamAView.setText(String.valueOf(savedInstanceState.getInt("SCORE_TEAM_A")));
        scoreTeamBView.setText(String.valueOf(savedInstanceState.getInt("SCORE_TEAM_B")));
        setTeamAView.setText(String.valueOf(savedInstanceState.getInt("SET_TEAM_A")));
        setTeamBView.setText(String.valueOf(savedInstanceState.getInt("SET_TEAM_B")));

  }

    //Method for displaying the Score for Player A
    public void displayForPlayerA(int scoreTeamA) {
        scoreTeamAView = (TextView) findViewById(R.id.player_a_score);
        scoreTeamAView.setText(String.valueOf(scoreTeamA));
    }

    //Method for displaying the Score for Player B
    public void displayForPlayerB(int scoreTeamB) {
        scoreTeamBView = (TextView) findViewById(R.id.player_b_score);
        scoreTeamBView.setText(String.valueOf(scoreTeamB));
    }

    //Method for displaying the Sets for Player A
    public void displayForSetA(int setTeamA) {
        setTeamAView = (TextView) findViewById(R.id.sets_a_score);
        setTeamAView.setText(String.valueOf(setTeamA));
    }

    //Method for displaying the Sets for Player B
    public void displayForSetB(int setTeamB) {
        setTeamBView = (TextView) findViewById(R.id.sets_b_score);
        setTeamBView.setText(String.valueOf(setTeamB));
    }

    //Method for displaying Foul for Player A
    public void displayForFoulA() {
        setFoulA = (TextView) findViewById(R.id.set_a_foul);
        setFoulA.setTextColor(this.getResources().getColor(R.color.red));
    }

    //Method for hiding Foul for Player A
    private void displayForFoulAWhite() {
        setFoulA = (TextView) findViewById(R.id.set_a_foul);
        setFoulA.setTextColor(this.getResources().getColor(R.color.white));
    }

    //Method for displaying Foul for Player B
    public void displayForFoulB() {
        setFoulB = (TextView) findViewById(R.id.set_a_foulb);
        setFoulB.setTextColor(this.getResources().getColor(R.color.red));
    }

    //Method for hiding Foul for Player A
    private void displayForFoulBWhite() {
        setFoulB = (TextView) findViewById(R.id.set_a_foulb);
        setFoulB.setTextColor(this.getResources().getColor(R.color.white));
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
        displayForFoulAWhite();
        displayForFoulBWhite();
    }

    //Foul button functionality for Player A
    public void foula(View view) {
        if (foulCounter == 0) {
            foulCounter = foulCounter + 1;
            displayForFoulA();
        } else if (foulCounter > 0) {
            displayForFoulAWhite();
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
            displayForFoulB();
        } else if (foulCounterB > 0) {
            displayForFoulBWhite();
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
