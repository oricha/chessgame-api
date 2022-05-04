package com.karel.chessserver.domain.pieces;

import com.karel.chessserver.domain.Board;
import com.karel.chessserver.domain.Spot;

public class Knight  extends Piece {
    public Knight(boolean white) {super(white);}

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        
        int xDiff = Math.abs(start.getX() - end.getX());
        int yDiff = Math.abs(start.getY() - end.getY());
        return xDiff * yDiff == 2;
    }
    @Override
    public boolean isCastlingMove() {
        return false;
    }
}
