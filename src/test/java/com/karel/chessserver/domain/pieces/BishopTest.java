package com.karel.chessserver.domain.pieces;

import com.karel.chessserver.domain.Board;
import com.karel.chessserver.domain.Spot;
import com.karel.chessserver.util.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {

    @DisplayName("Single valid movement for a Bishop")
    @Test
    void canMoveValidTest() throws Exception {

        Board board = new Board();
        board.removePiece(2,1); //remove Pawn
        Bishop bishop = new Bishop(Constants.WHITE);
        Spot start = new Spot(2, 0, bishop);
        Spot end = new Spot(4, 2, bishop);
        assertTrue(bishop.canMove(board, start, end));
    }

    @DisplayName("Single invalid movement for a Bishop")
    @Test
    void canMoveInvalidTest() throws Exception {
        Board board = new Board();
        board.removePiece(2,1); //remove Pawn
        Bishop bishop = new Bishop(Constants.WHITE);
        Spot start = new Spot(2, 0, bishop);
        Spot end = new Spot(4, 3, bishop);
        assertFalse(bishop.canMove(board, start, end));
    }
}