package com.game.tictactoe.service;

import com.game.tictactoe.domain.Player;
import com.game.tictactoe.exception.InvalidTurnException;
import com.game.tictactoe.util.GameBoard;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private final GameBoard gameBoard;

    public GameService(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public String playGame(Player player, int row, int column) {

        String message = "Unsuccessful Move";
        if (player == Player.X) {
            if (gameBoard.savePlayerOnPosition(player, row, column) == player.getValue()) {
                message = "Successful Move";
            }
        } else if (isPlayerO(player)) {
            throw new InvalidTurnException("Player X should move first");
        }
        return message;
    }

    private boolean isPlayerO(Player player) {
        return player == Player.O;
    }
}