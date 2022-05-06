package com.karel.chessserver.domain;

import com.karel.chessserver.domain.pieces.*;
import lombok.Data;

@Data
public class Board {

    Spot[][] boxes;

    private boolean isFirstMove = true;
    private int countMovement = 0;
    public Board() {
        boxes = new Spot[8][8];
        this.resetBoard();
    }
    public Spot getBox(int x, int y) throws Exception {

        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new Exception("Movement not available");
        }
        return boxes[x][y];
    }
    public void resetBoard() {
        // initialize white pieces
        boxes[0][0] = new Spot(0, 0, new Rook(true));
        boxes[0][1] = new Spot(0, 1, new Knight(true));
        boxes[0][2] = new Spot(0, 2, new Bishop(true));
        boxes[0][3] = new Spot(0, 3, new Queen(true));
        boxes[0][4] = new Spot(0, 4, new King(true));
        boxes[0][5] = new Spot(0, 5, new Bishop(true));
        boxes[0][6] = new Spot(0, 6, new Knight(true));
        boxes[0][7] = new Spot(0, 7, new Rook(true));
        for(int i = 0; i < 8; i++) {
            // initialize white Pawns
            boxes[1][i] = new Spot(1, i, new Pawn(true));
            // initialize black Pawns
            boxes[6][i] = new Spot(6, i, new Pawn(false));
        }
        // initialize black pieces
        boxes[7][0] = new Spot(7, 0, new Rook(false));
        boxes[7][1] = new Spot(7, 1, new Knight(false));
        boxes[7][2] = new Spot(7, 2, new Bishop(false));
        boxes[7][3] = new Spot(7, 3, new Queen(false));
        boxes[7][4] = new Spot(7, 4, new King(false));
        boxes[7][5] = new Spot(7, 5, new Bishop(false));
        boxes[7][6] = new Spot(7, 6, new Knight(false));
        boxes[7][7] = new Spot(7, 7, new Rook(false));
        // initialize remaining boxes without any piece
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                boxes[i][j] = new Spot(i, j, null);
            }
        }
        isFirstMove = true;
        countMovement = 0;
    }
    public boolean isFirstMove() {

        switch (countMovement) {
            case 0, 1 -> {
                countMovement++;
                isFirstMove = true;
            }
            default -> isFirstMove = false;
        }
        return isFirstMove;
    }

    public void setFirstMove(boolean isFirstMove) {this.isFirstMove = isFirstMove;}

    public boolean removePiece(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            return false;
        }
        boxes[x][y].setPiece(null);
        return true;
    }

    public boolean addPiece(int x, int y, Piece piece) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            return false;
        }
        boxes[x][y].setPiece(piece);
        return true;
    }
}