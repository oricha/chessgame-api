package com.karel.chessserver.domain.pieces;

import com.karel.chessserver.domain.Board;
import com.karel.chessserver.domain.Spot;
import com.karel.chessserver.domain.pieces.Piece;
import org.apache.commons.lang3.builder.Diff;

public class Pawn extends Piece {

    public Pawn(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {

        int xDiff = Math.abs(start.getX() - end.getX());
        int yDiff = Math.abs(start.getY() - end.getY());
        int DIFF = 2;
        if (!board.isFirstMove()){
            DIFF = 1;
        }
        if (xDiff == DIFF && yDiff == DIFF) {
            return false; // move only in one dimension
        }
        return  ((xDiff <= DIFF && yDiff == 0) || (xDiff == 0 && yDiff <= DIFF));

    }

    @Override
    public boolean isCastlingMove() {
        return false;
    }

}
