package com.karel.chessserver.domain.pieces;

import com.karel.chessserver.domain.Board;
import com.karel.chessserver.domain.Spot;
import com.karel.chessserver.domain.pieces.Piece;

public class Queen extends Piece {

    public Queen(boolean white) {super(white);}

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        if (start.getX() == end.getX() && start.getY() == end.getY()) {
            return false;
        }
        if (Math.abs(start.getX() - end.getX()) == Math.abs(start.getY() - end.getY())) {
            return true;
        }
        return start.getX() == end.getX() || start.getY() == end.getY();
    }

    @Override
    public boolean isCastlingMove() {
        return false;
    }

}
