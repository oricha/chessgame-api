package com.karel.chessserver.domain;

public class ComputerPlayer extends Player {

    public ComputerPlayer(boolean whiteSide) {
        super(whiteSide);
        this.whiteSide = whiteSide;
        this.humanPlayer = false;
    }
}
