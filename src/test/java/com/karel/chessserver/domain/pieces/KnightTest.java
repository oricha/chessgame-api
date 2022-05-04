package com.karel.chessserver.domain.pieces;

import com.karel.chessserver.domain.Board;
import com.karel.chessserver.domain.Spot;
import com.karel.chessserver.util.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    @DisplayName("Single valid movement for a Knight")
    @Test
    void canMoveValidTest() {

        Board board = new Board();
        Knight knight = new Knight(Constants.WHITE);
        Spot start = new Spot(1, 0, knight);
        Spot end = new Spot(0, 2, knight);
        assertTrue(knight.canMove(board, start, end));
    }

    @DisplayName("Single invalid movement for a Knight")
    @Test
    void canMoveInvalidTest() {

        Board board = new Board();
        Knight knight = new Knight(Constants.WHITE);
        Spot start = new Spot(1, 0, knight);
        Spot end = new Spot(3, 3, knight);
        assertFalse(knight.canMove(board, start, end));
    }
}