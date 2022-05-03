package com.karel.chessserver.domain.pieces;

import com.karel.chessserver.domain.Board;
import com.karel.chessserver.domain.Spot;
import com.karel.chessserver.domain.pieces.Piece;
public class Rook extends Piece {
    public Rook(boolean white) {super(white);}

    @Override
    public boolean canMove(Board board,Spot start, Spot end) throws Exception {
        int x1 = start.getX();
        int y1 = start.getY();
        int x2 = end.getX();
        int y2 = end.getY();
        if(x1 == x2) {
            if(y1 < y2) {
                for(int i = y1 + 1; i < y2; i++) {
                    if(board.getBox(x1, i).getPiece() != null) return false;
                }
            } else {
                for(int i = y1 - 1; i > y2; i--) {
                    if(board.getBox(x1, i).getPiece() != null) return false;
                }
            }
        } else if(y1 == y2) {
            if(x1 < x2) {
                for(int i = x1 + 1; i < x2; i++) {
                    if(board.getBox(i, y1).getPiece() != null) return false;
                }
            } else {
                for(int i = x1 - 1; i > x2; i--) {
                    if(board.getBox(i, y1).getPiece() != null) return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
    @Override
    public boolean isCastlingMove() {
        return false;
    }
}
