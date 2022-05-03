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

        //FIXME: check if the pawn is on the first row
        int diffX = Math.abs(start.getX() - end.getX());
        int diffY = Math.abs(start.getY() - end.getY());
            if (isFirstMove) {
                if (diffX == 2) {
                    return false;
                } else if (diffX == 1 && diffY == 1) {
                    return false;
                }
            }
        if (diffX == 1 && diffY == 1) {
            return false;
        }
        if (diffX == 0 && diffY == 1) {
            return true;
        }
        return false;
    }

    public boolean isFirstMove() {return isFirstMove;}

    public void setFirstMove(boolean isFirstMove) {this.isFirstMove = isFirstMove;}
}
