package com.karel.chessserver.controller;


import com.karel.chessserver.domain.Player;
import com.karel.chessserver.dto.MoveRequest;
import com.karel.chessserver.service.ChessService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChessController {

    private ChessService server;

    public ChessController(ChessService server) {
        this.server = server;
    }

    @GetMapping("/start")
    public ResponseEntity<?> startGame() {
        server.startGame();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/play")
    public ResponseEntity<?> makeMove(@RequestBody MoveRequest move) {


        try {
            boolean resultMove = server.playerMove(move.getPlayer(),
                    move.getStart(),
                    move.getEnd());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().build();
    }
    @GetMapping("/version")
    public String getVersion() {
        return "1.0";
    }
    
}

