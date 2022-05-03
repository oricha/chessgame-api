package com.karel.chessserver.domain;


import com.karel.chessserver.domain.pieces.King;
import com.karel.chessserver.domain.pieces.Piece;

import java.util.List;

public class Game {

    private Player[] players;
    private Board board;
    private Player currentTurn;
    private GameStatus status;
    private List<Move> movesPlayed;
    private void initialize(Player p1, Player p2)
    {
        players[0] = p1;
        players[1] = p2;

        board.resetBoard();

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

    public boolean playerMove(Player player, int startX, int startY, int endX, int endY) throws Exception {
        Spot startBox = board.getBox(startX, startY);
        Spot endBox = board.getBox(endX, endY);
        Move move = new Move(player, startBox, endBox);
        return this.makeMove(move, player);
    }
    private boolean makeMove(Move move, Player player)
    {
        Piece sourcePiece = move.getStart().getPiece();
        Piece targetPiece = move.getEnd().getPiece();
        if (sourcePiece == null) {
            return false;    // No piece on start box
        }

        // is valid player turn
        if (player != currentTurn) {
            return false; // Not your turn
        }

        if (sourcePiece.isWhite() != player.isWhiteSide()) {
            return false; // wrong side
        }

        // is valid move?
        if (!sourcePiece.canMove(board, move.getStart(), move.getEnd())) {
            return false; // invalid move
        }

        // kill?
        Piece destPiece = move.getStart().getPiece();
        if (destPiece != null) {
            destPiece.setKilled(true);
            move.setPieceKilled(destPiece);
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

        if (destPiece instanceof King) {
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
