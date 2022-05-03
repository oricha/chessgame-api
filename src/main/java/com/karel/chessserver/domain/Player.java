package com.karel.chessserver.domain;

import lombok.Data;

@Data
public class Player {

    public boolean whiteSide;
    public boolean humanPlayer;

    public Player(boolean whiteSide, boolean humanPlayer) {
        this.whiteSide = whiteSide;
        this.humanPlayer = humanPlayer;
    }
    public Player(boolean whiteSide) {
        this.whiteSide = whiteSide;
        this.humanPlayer = true;
    }
    public Player() {
        this.whiteSide = true;
        this.humanPlayer = false;
    }
    public boolean isWhiteSide()
    {
        return this.whiteSide;
    }
    public boolean isHumanPlayer()
    {
        return this.humanPlayer;
    }
}