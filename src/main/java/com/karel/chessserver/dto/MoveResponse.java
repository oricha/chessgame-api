package com.karel.chessserver.dto;

import com.karel.chessserver.domain.Board;
import com.karel.chessserver.domain.GameStatus;
import lombok.Data;

@Data
public class MoveResponse {
    private GameStatus gameStatus;
    private Board board;

    public void setStatus(GameStatus status) {
        this.gameStatus = status;
    }
}
