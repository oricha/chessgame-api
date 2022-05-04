package com.karel.chessserver.service;

import com.karel.chessserver.domain.GameStatus;
import com.karel.chessserver.domain.Player;
import com.karel.chessserver.domain.Spot;
import com.karel.chessserver.domain.pieces.Pawn;
import com.karel.chessserver.util.Constants;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessServiceTest {

    @BeforeAll
    static void setUp() {
    }

    @DisplayName("Start new game engine")
    @Test
    void startGame() {
        ChessService chessService = new ChessService();
        chessService.startGame();
        assertAll(
                () -> assertEquals(chessService.getStatus(), GameStatus.ACTIVE)
        );
    }

    @DisplayName("Play the same player twice")
    @Test
    void playerPlayTwiceGame() throws Exception {
        ChessService chessService = new ChessService();
        chessService.startGame();
        Player player1 = new Player(true);
        Spot startBox = new Spot(1, 0,new Pawn(Constants.WHITE));
        Spot endBox = new Spot(2, 0, new Pawn(Constants.BLACK));
        boolean movementComplete1 = chessService.playerMove(player1, startBox, endBox);
        boolean movementComplete2 =  chessService.playerMove(player1, startBox, endBox);
        assertAll(
                () -> assertTrue(movementComplete1),
                () -> assertFalse(movementComplete2));
    }

}