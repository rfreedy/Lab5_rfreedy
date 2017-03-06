package com.cse40333.rfreedy.lab2_rfreedy;

import java.io.Serializable;

/**
 * Created by rfreedy on 3/4/2017.
 */

public class Team implements Serializable {

    String notreDameLogo = "notredamelogo";
    String opponentLogo;
    String gameLocation;
    String gameDate;
    String gameOutcome;
    String gameScore;
    String notreDameName = "Notre Dame Fight Irish";
    String opponentName;
    String notreDameRecord = "21-7";
    String opponentRecord;


    public Team (String opponent_name, String game_outcome, String game_date, String opponent_logo, String game_score, String game_location, String opponent_record) {
        setOpponentName(opponent_name);
        setGameOutcome(game_outcome);
        setGameDate(game_date);
        setOpponentLogo(opponent_logo);
        setGameScore(game_score);
        setGameLocation(game_location);
        setOpponentRecord(opponent_record);
    }

    public void setOpponentName(String team_name) {
        this.opponentName = team_name;
    }

    public String getOpponentName() {
        return this.opponentName;
    }

    public void setGameOutcome(String game_outcome) {
        this.gameOutcome = game_outcome;
    }

    public String getGameOutcome() {
        return this.gameOutcome;
    }

    public void setGameDate(String game_date) {
        this.gameDate = game_date;
    }

    public String getGameDate() {
        return this.gameDate;
    }

    public void setGameScore(String game_score) {
        this.gameScore = game_score;
    }

    public String getGameScore() {
        return this.gameScore;
    }

    public void setGameLocation(String game_location) {
        this.gameLocation = game_location;
    }

    public String getGameLocation() {
        return this.gameLocation;
    }

    public void setOpponentLogo(String team_logo) {
        this.opponentLogo = team_logo;
    }

    public String getOpponentLogo() {
        return this.opponentLogo;
    }

    public void setOpponentRecord(String team_record) {
        this.opponentRecord = team_record;
    }

    public String getOpponentRecord() {
        return this.opponentRecord;
    }

}
