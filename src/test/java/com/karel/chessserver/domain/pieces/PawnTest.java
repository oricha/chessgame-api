package com.karel.chessserver.domain.pieces;

import com.karel.chessserver.domain.Board;
import com.karel.chessserver.domain.Spot;
import com.karel.chessserver.util.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @DisplayName("Single valid movement for a Pawn")
    @Test
    void canMoveValidTest() {
        Board board = new Board();
        board.removePiece(1,0); //remove Pawn
        Pawn pawn = new Pawn(Constants.WHITE);
        Spot start = new Spot(1, 0, pawn);
        Spot end = new Spot(2, 0, null);
        assertTrue(pawn.canMove(board, start, end));
    }

    @DisplayName("First move with 2 blocks movement for a Pawn")
    @Test
    void isFirstMoveTest() {
        Board board = new Board();
        board.removePiece(1,0); //remove Pawn
        Pawn pawn = new Pawn(Constants.WHITE);
        Spot start = new Spot(1, 0, pawn);
        Spot end = new Spot(3, 0, null);
        assertTrue(pawn.canMove(board, start, end));
    }

    @DisplayName("First move with invalid blocks movement for a Pawn")
    @Test
    void isFirstMoveInvalidMovementTest() {
        Board board = new Board();
        Pawn pawn = new Pawn(Constants.WHITE);
        Spot start = new Spot(1, 0, pawn);
        Spot end = new Spot(6, 0, null);
        assertFalse(pawn.canMove(board, start, end));
    }

    @DisplayName("Second move with invalid blocks movement for a Pawn")
    @Test
    void isFirstMoveInvalidSecondMovementTest() {
        Board board = new Board();
        Pawn pawn1 = new Pawn(Constants.WHITE);
        Spot start = new Spot(1, 0, pawn1);
        Spot end = new Spot(2, 0, null);
        assertTrue(pawn1.canMove(board, start, end));
        Pawn pawn2 = new Pawn(Constants.BLACK);
        start = new Spot(6, 0, pawn1);
        end = new Spot(5, 0, null);
        pawn2.canMove(board, start, end);
        start = new Spot(2, 0, pawn1);
        end = new Spot(4, 0, null);
        assertFalse(pawn1.canMove(board, start, end));
    }
}