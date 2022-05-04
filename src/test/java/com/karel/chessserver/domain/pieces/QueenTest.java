package com.karel.chessserver.domain.pieces;

import com.karel.chessserver.domain.Board;
import com.karel.chessserver.domain.Spot;
import com.karel.chessserver.util.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {

    @DisplayName("Single valid movement for a Queen")
    @Test
    void canMoveValidTest() throws Exception {

        Board board = new Board();
        board.removePiece(1,4); //remove Pawn
        Queen queen = new Queen(Constants.WHITE);
        Spot start = new Spot(0, 4, queen);
        Spot end = new Spot(3, 4, queen);
        assertTrue(queen.canMove(board, start, end));
    }

    @DisplayName("Single invalid movement for a Queen")
    @Test
    void canMoveInValidTest() throws Exception {

        Board board = new Board();
        board.removePiece(1,4); //remove Pawn
        Queen queen = new Queen(Constants.WHITE);
        Spot start = new Spot(0, 4, queen);
        Spot end = new Spot(3, 3, queen);
        assertFalse(queen.canMove(board, start, end));
    }
}