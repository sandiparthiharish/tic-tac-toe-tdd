package com.game.tictactoe.service;

import com.game.tictactoe.domain.Player;
import com.game.tictactoe.domain.Position;
import com.game.tictactoe.exception.InvalidPositionException;
import com.game.tictactoe.exception.InvalidTurnException;
import com.game.tictactoe.exception.PositionAlreadyOccupiedException;
import com.game.tictactoe.util.GameBoard;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private static final int INITIAL_VALUE = 0;
    private final GameBoard gameBoard;
    private char previousPlayer;

    public GameService(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public String resetGameState() {

        resetGameBoard();
        return "Reset successful";
    }

    public String playGame(Player player, int position) {

        if (isFirstTurn()) {
            gameBoard.initialize();
        }
        validateCurrentTurn(player, position);
        saveCurrentTurn(player, position);
        return validateGameAndSendResponse(player);
    }

    private String validateGameAndSendResponse(Player player) {

        if (isGameOver()) {
            resetGameBoard();
            return String.format("Player %s won the game", player.getValue());
        } else if (gameBoard.isBoardFull()) {
            resetGameBoard();
            return "Game is a Tie";
        }
        return "Successful Move";
    }

    private void resetGameBoard() {
        previousPlayer = INITIAL_VALUE;
        gameBoard.initialize();
    }

    private boolean isGameOver() {
        return gameBoard.isAnyRowOccupiedBySamePlayer() || gameBoard.isAnyColumnOccupiedBySamePlayer()
                || gameBoard.isAnyDiagonalOccupiedBySamePlayer();
    }

    private void saveCurrentTurn(Player player, int position) {
        if (gameBoard.savePlayerOnPosition(player, Position.getRowColumnValueOfPosition(position)) == player.getValue()) {
            previousPlayer = player.getValue();
        }
    }

    private void validateCurrentTurn(Player player, int position) {

        if (isInValidPosition(position)) {
            throw new InvalidPositionException("Invalid Position. Please choose position value between 1 to 9");
        } else if (isFirstTurn() && isPlayerO(player)) {
            throw new InvalidTurnException("Player X should move first");
        } else if (isSamePlayerPlaying(player)) {
            throw new InvalidTurnException(String.format("Player %s's turn now", getNextPlayer(player)));
        } else if (gameBoard.getPositionValueOnBoard(Position.getRowColumnValueOfPosition(position)) != INITIAL_VALUE) {
            throw new PositionAlreadyOccupiedException(String.format("Input position %s is already occupied", position));
        }
    }

    private Character getNextPlayer(Player player) {
        return player == Player.X ? Player.O.getValue() : Player.X.getValue();
    }

    private boolean isInValidPosition(int position) {
        return Position.getRowColumnValueOfPosition(position) == Position.DEFAULT;
    }

    private boolean isSamePlayerPlaying(Player player) {
        return player.getValue() == previousPlayer;
    }

    private boolean isFirstTurn() {
        return previousPlayer == INITIAL_VALUE;
    }

    private boolean isPlayerO(Player player) {
        return player == Player.O;
    }
}