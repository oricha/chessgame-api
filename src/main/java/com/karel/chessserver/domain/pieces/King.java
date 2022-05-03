package com.karel.chessserver.domain.pieces;

import com.karel.chessserver.domain.Board;
import com.karel.chessserver.domain.Spot;

public class King extends Piece {
    private boolean castlingDone = false;

    public King(boolean white) {super(white);}
    public boolean isCastlingDone() { return this.castlingDone;}

    public void setCastlingDone(boolean castlingDone) {this.castlingDone = castlingDone;}

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        // we can't move the piece to a Spot that has a piece of the same color
        if (end.getPiece().isWhite() == this.isWhite()) {return false;}

        int diffX = Math.abs(start.getX() - end.getX());
        int diffY = Math.abs(start.getY() - end.getY());
        // check if this move will not result in the king being attacked if so return true
        if (diffX + diffY == 1) {
            return true;
        }

        return this.isValidCastling(board, start, end);
    }
    private boolean isValidCastling(Board board, Spot start, Spot end) {

        if (this.isCastlingDone()) {
            return false;
        }
        // check for the white king castling
        if (this.isWhite() && start.getX() == 0 && start.getY() == 4 && end.getY() == 0) {
            // confirm if white king moved to the correct ending box
            if (Math.abs(end.getY() - start.getY()) == 2) {
                // check if there the Rook is in the correct position
                // check if there is no piece between Rook and the King
                // check if the King or the Rook has not moved before
                // check if this move will not result in king being attacked
                //...
                this.setCastlingDone(true);
                return true;
            }
        } else {
            // check for the black king castling
            this.setCastlingDone(true);
            return true;
        }
        return false;
    }

    public boolean isCastlingMove(Spot start, Spot end) {
        // check if the starting and
        // ending position are correct
        return false; //FIXME
    }
}

