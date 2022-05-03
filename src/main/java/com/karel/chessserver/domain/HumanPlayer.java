package com.karel.chessserver.domain;

public class HumanPlayer extends Player {

    public HumanPlayer(boolean whiteSide) {
        super(whiteSide);
        this.whiteSide = whiteSide;
        this.humanPlayer = true;
    }
}
