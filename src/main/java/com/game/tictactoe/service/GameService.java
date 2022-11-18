package com.game.tictactoe.service;

import com.game.tictactoe.domain.Player;
import com.game.tictactoe.domain.Position;
import com.game.tictactoe.exception.InvalidPositionException;
import com.game.tictactoe.exception.InvalidTurnException;
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

    public String playGame(Player player, int position) {

        String message = "Unsuccessful Move";
        if (isInValidPosition(position)) {
            throw new InvalidPositionException("Invalid Position. Please choose position value between 1 to 9");
        } else if (isFirstTurn() && isPlayerO(player)) {
            throw new InvalidTurnException("Player X should move first");
        } else if (isSamePlayerPlaying(player)) {
            message = "Other player should play the game";
        }
        if (gameBoard.savePlayerOnPosition(player, Position.getRowColumnValueOfPosition(position)) == player.getValue()) {
            previousPlayer = player.getValue();
            message = "Successful Move";
        }
        return message;
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