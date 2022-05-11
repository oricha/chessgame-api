package com.karel.chessserver.service;

import com.karel.chessserver.domain.*;
import com.karel.chessserver.domain.pieces.King;
import com.karel.chessserver.domain.pieces.Piece;
import org.springframework.stereotype.Service;

import javax.swing.text.Position;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChessService {

    private Player[] players;
    private Board board = new Board();
    private Player currentTurn;
    private GameStatus status;
    private List<Move> movesPlayed;

    public void startGame() {
        players = new Player[]{new Player(true), new Player(false)};
        startGame(players[0], players[1]);
    }

    /**
     * Start a new game, reset the board and set the current turn to the first player
     *
     * @param p1 Player 1
     * @param p2 Player 2
     */
    private void startGame(Player p1, Player p2) {
        players[0] = p1;
        players[1] = p2;
        board = new Board();
        movesPlayed = new ArrayList<>();
        if (p1.isWhiteSide()) {
            this.currentTurn = p1;
        } else {
            this.currentTurn = p2;
        }
        movesPlayed.clear();
        this.setStatus(GameStatus.ACTIVE);
    }

    public boolean isEnd() {
        return this.getStatus() != GameStatus.ACTIVE;
    }

    public GameStatus getStatus() {
        return this.status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    /**
     * Make a move on the board. Check if the move is valid and if it is, make the move.
     * @param player Player that is making the move
     * @param startBox Start box of the move
     * @param endBox End box of the move
     * @return
     * @throws Exception
     */
    public boolean playerMove(Player player, Spot startBox, Spot endBox) throws Exception {
        startBox = board.getBox(startBox.getX(), startBox.getY());
        endBox = board.getBox(endBox.getX(), endBox.getY());
        Move move = new Move(player, startBox, endBox);
        boolean canMove = this.makeMove(move, player);

        if (canMove) {
            if (this.isCheckmate()) {
                if (currentTurn.isBlackSide()){
                    this.setStatus(GameStatus.BLACK_WIN);
                } else  {
                    this.setStatus(GameStatus.WHITE_WIN);
                }
            }
            //continue playing
            return true;
        }
        //movement not allowed
        return false;
    }

    /**
     * Make a move. Move one piece from initial position to final position.
     *
     * @param move  Move to make
     * @param player Player making the move
     * @return true if the move was valid
     * @throws Exception
     */
    private boolean makeMove(Move move, Player player) throws Exception {
        Piece sourcePiece = move.getStart().getPiece();

        if (sourcePiece == null) {
            return false;
        }
        // is your turn?
        if (!currentTurn.equals(player)) {
            return false;
        }
        // is your piece?
        if (sourcePiece.isWhite() != player.isWhiteSide()) {
            return false;
        }
        // is a valid move?
        if (!sourcePiece.canMove(board, move.getStart(), move.getEnd())) {
            return false;
        }
        //From here on it can only return true
        // marked for death?
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

        if (targetPiece instanceof King) {
            if (player.isWhiteSide()) {
                this.setStatus(GameStatus.WHITE_WIN);
            } else {
                this.setStatus(GameStatus.BLACK_WIN);
            }
        }

        // set the current turn to the other player
        if (this.currentTurn == players[0]) {
            this.currentTurn = players[1];
        } else {
            this.currentTurn = players[0];
        }
        // move piece from the start box to end box
        board.addPiece(move.getEnd().getX(), move.getEnd().getY(), move.getEnd().getPiece());
        board.removePiece(move.getStart().getX(), move.getStart().getY());
        return true;
    }

    /**
     * Check if there is a check or checkmate in the board.
     *
     * @return return true if there is a checkmate
     */
    public boolean isCheckmate() throws Exception {
        //Check King position and verify if it can move
        boolean whiteOrBlack = currentTurn.isWhiteSide();
        //Find the opposite King
        Spot position = findKing( !whiteOrBlack);
        //FIXME: This is not working
        //Check is king can move
        return false;
    }

    /**
     * Check where is the King in the board.
     * @param isWhiteSide
     * @return
     * @throws Exception
     */
    private Spot findKing(boolean isWhiteSide) throws Exception {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.getBox(i, j).getPiece() instanceof King && board.getBox(i, j).getPiece().isWhite() == isWhiteSide) {
                    return board.getBox(i, j);
                }
            }
        }
        throw new Exception("No king found");
    }

    public Board getBoard() {
        return board;
    }
}
