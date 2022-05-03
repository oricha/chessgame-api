package com.karel.chessserver.domain.pieces;

import com.karel.chessserver.domain.Board;
import com.karel.chessserver.domain.Spot;
import com.karel.chessserver.domain.pieces.Piece;

public class Bishop extends Piece {
    public Bishop(boolean white) {super(white);}

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {

        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());

       return false;
    }

    }
