package com.karel.chessserver.domain.pieces;

import com.karel.chessserver.domain.Board;
import com.karel.chessserver.domain.Spot;
import com.karel.chessserver.domain.pieces.Piece;

public class Pawn extends Piece {
    private boolean isFirstMove = true;

    public Pawn(boolean white) {
        super(white);
        isFirstMove = true;
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {

        int diffX = Math.abs(start.getX() - end.getX());
        int diffY = Math.abs(start.getY() - end.getY());

        if (diffX == 1 && diffY == 1) {
            return false;
        }
        return diffX == 0 && diffY == 1;
    }

    @Override
    public boolean isCastlingMove() {
        return false;
    }

    public boolean isFirstMove() {return isFirstMove;}

    public void setFirstMove(boolean isFirstMove) {this.isFirstMove = isFirstMove;}
}
