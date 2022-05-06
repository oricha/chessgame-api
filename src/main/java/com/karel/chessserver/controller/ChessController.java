package com.karel.chessserver.controller;


import com.karel.chessserver.dto.MoveRequest;
import com.karel.chessserver.dto.MoveResponse;
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
    public ResponseEntity<?> makeMove(@RequestBody MoveRequest move) throws Exception {
        MoveResponse response = new MoveResponse();
        boolean resultMove = server.playerMove(move.getPlayer(),
                move.getStart(),
                move.getEnd());
        if ( !resultMove) {
          return ResponseEntity.badRequest().build();
        }
        response.setBoard(server.getBoard());
        response.setStatus(server.getStatus());
        return ResponseEntity.ok().body( response );
    }

    @GetMapping("/version")
    public String getVersion() {
        return "1.0";
    }

}

