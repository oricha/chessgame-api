package com.karel.chessserver.domain.pieces;

import com.karel.chessserver.domain.Board;
import com.karel.chessserver.domain.Spot;
import com.karel.chessserver.domain.pieces.Piece;

public class Bishop extends Piece {
    public Bishop(boolean white) {super(white);}

    @Override
    public boolean canMove(Board board, Spot start, Spot end) throws Exception {
        if (start.getX() == end.getX() && start.getY() == end.getY()) {
            return false;
        }

        if (Math.abs(start.getX() - end.getX()) != Math.abs(start.getY() - end.getY())) {
            return false;
        }

        int x = start.getX();
        int y = start.getY();

        if (start.getX() < end.getX()) {
            x++;
        } else {
            x--;
        }

        if (start.getY() < end.getY()) {
            y++;
        } else {
            y--;
        }

        while (x != end.getX() && y != end.getY()) {
            if (board.getBox(x, y).getPiece() != null) {
                return false;
            }

            if (start.getX() < end.getX()) {
                x++;
            } else {
                x--;
            }

            if (start.getY() < end.getY()) {
                y++;
            } else {
                y--;
            }
        }
        return true;
    }

    @Override
    public boolean isCastlingMove() {
        return false;
    }

}
