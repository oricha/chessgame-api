package com.karel.chessserver.domain;

import com.karel.chessserver.domain.pieces.*;
import com.karel.chessserver.util.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @DisplayName("Create a new board con pieces")
    @Test
    void resetBoardTest() throws Exception {
        Board board = new Board();
        board.resetBoard();
        assertAll("Test some box and pieces in place",
                () -> assertThat(board.getBox(0, 0).getPiece()).usingRecursiveComparison().isEqualTo( new Rook(Constants.WHITE)),
                () -> assertThat(board.getBox(0, 2).getPiece()).usingRecursiveComparison().isEqualTo( new Bishop(Constants.WHITE)),
                () -> assertThat(board.getBox(7, 6).getPiece()).usingRecursiveComparison().isEqualTo(new Knight(Constants.BLACK)),
                () -> assertThat(board.getBox(7, 7).getPiece()).usingRecursiveComparison().isEqualTo( new Queen(Constants.BLACK)));

    }
}