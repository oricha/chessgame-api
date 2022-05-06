package com.karel.chessserver.domain;

import lombok.Data;

@Data
public class Player {

    public boolean whiteSide;

    public Player(boolean whiteSide, boolean humanPlayer) {
        this.whiteSide = whiteSide;
    }
    public Player(boolean whiteSide) {
        this.whiteSide = whiteSide;
    }
    public Player() {
        this.whiteSide = true;
    }
    public boolean isWhiteSide() {
        return this.whiteSide;
    }

    public boolean isBlackSide() {
        return !this.whiteSide;
    }
}