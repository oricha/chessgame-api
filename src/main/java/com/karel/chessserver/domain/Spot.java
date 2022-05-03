package com.karel.chessserver.domain;

import com.karel.chessserver.domain.pieces.Piece;
import lombok.Data;

@Data
public class Spot {
    private Piece piece;
    private int x;
    private int y;

    public Spot(int x, int y, Piece piece) {
        this.setPiece(piece);
        this.setX(x);
        this.setY(y);
    }
}
