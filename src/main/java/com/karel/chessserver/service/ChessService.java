package com.karel.chessserver.service;

import com.karel.chessserver.domain.*;
import com.karel.chessserver.domain.pieces.King;
import com.karel.chessserver.domain.pieces.Piece;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChessService {

    private Player[] players;
    private Board board = new Board();
    private Player currentTurn;
    private GameStatus status;
    private List<Move> movesPlayed;
    public void startGame(){
        players = new Player[]{new Player(true), new Player(false)};
        startGame(players[0], players[1]);
    }
    private void startGame(Player p1, Player p2)
    {
        players[0] = p1;
        players[1] = p2;
        board = new Board();
        movesPlayed = new ArrayList<>();
        if (p1.isWhiteSide()) {
            this.currentTurn = p1;
        }
        else {
            this.currentTurn = p2;
        }
        movesPlayed.clear();
    }

    public boolean isEnd() {return this.getStatus() != GameStatus.ACTIVE; }

    public GameStatus getStatus() {return this.status;}

    public void setStatus(GameStatus status) {this.status = status;}

    public boolean playerMove(Player player, Spot startBox,  Spot endBox) throws Exception {
        Move move = new Move(player, startBox, endBox);
        return this.makeMove(move, player);
    }

    private boolean makeMove(Move move, Player player)
    {
        Piece sourcePiece = move.getStart().getPiece();

        if (sourcePiece == null) { return false;}
        // valid player
        if (player != currentTurn) { return false;}

        if (sourcePiece.isWhite() != player.isWhiteSide()) {return false;}
        // valid move?
        if (!sourcePiece.canMove(board, move.getStart(), move.getEnd())) { return false;}
        // kill?
        Piece targetPiece = move.getEnd().getPiece();
        if (targetPiece != null) {
            targetPiece.setKilled(true);
            move.setPieceKilled(targetPiece);
        }
        // castling?
        if (sourcePiece instanceof King && sourcePiece.isCastlingMove()) {
            move.setCastlingMove(true);
        }
        // store the move
        movesPlayed.add(move);

        // move piece from the stat box to end box
        move.getEnd().setPiece(move.getStart().getPiece());
        move.getStart().setPiece(null);

        if (targetPiece instanceof King) {
            if (player.isWhiteSide()) {
                this.setStatus(GameStatus.WHITE_WIN);
            }
            else {
                this.setStatus(GameStatus.BLACK_WIN);
            }
        }

        // set the current turn to the other player
        if (this.currentTurn == players[0]) {
            this.currentTurn = players[1];
        }
        else {
            this.currentTurn = players[0];
        }
        return true;
    }
}
