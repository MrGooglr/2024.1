package com.aniket.misc.dto;

import java.util.List;

public class Team implements Comparable {

    int iccRank;
    String teamName;
    List<String> playerNames;

    public Team(int iccRank, String teamName, List<String> playerNames) {
        this.iccRank = iccRank;
        this.teamName = teamName;
        this.playerNames = playerNames;
    }

    public int getIccRank() {
        return iccRank;
    }

    public void setIccRank(int iccRank) {
        this.iccRank = iccRank;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }

    public void setPlayerNames(List<String> playerNames) {
        this.playerNames = playerNames;
    }

    @Override
    public int compareTo(Object o) {
        return this.iccRank - ((Team) o).iccRank;
    }
}
