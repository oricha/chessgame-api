package com.karel.chessserver.dto;

import com.karel.chessserver.domain.Player;
import com.karel.chessserver.domain.Spot;
import lombok.Data;

@Data
public class MoveRequest {

    private Player player;
    private Spot start;
    private Spot end;
}
