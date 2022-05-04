package com.karel.chessserver.domain.pieces;

import com.karel.chessserver.domain.Board;
import com.karel.chessserver.domain.Spot;
import com.karel.chessserver.util.Constants;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {

    @BeforeAll
    static void init() {

    }

    @DisplayName("Single valid movement for a Rook")
    @Test
    void canMoveValidTest() throws Exception {
        Board board = new Board();
        Rook rook = new Rook(Constants.WHITE);
        Spot start = new Spot(2, 2, rook);
        Spot end = new Spot(4, 2, rook);
        assertTrue(rook.canMove(board, start, end));
    }

    @DisplayName("Single invalid movement for a Rook")
    @Test
    void canMoveInValidTest() throws Exception {
        Board board = new Board();
        Rook rook = new Rook(Constants.WHITE);
        Spot start = new Spot(2, 2, rook);
        Spot end = new Spot(1, 6, rook);
        assertFalse(rook.canMove(board, start, end));
    }
}