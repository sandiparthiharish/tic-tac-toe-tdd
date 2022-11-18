package com.game.tictactoe.service;

import com.game.tictactoe.domain.Player;
import com.game.tictactoe.exception.InvalidTurnException;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    public String playGame(Player player) {

        String message = "Unsuccessful Move";
        if (player == Player.X) {
            message = "Successful Move";
        } else if (player == Player.O) {
            throw new InvalidTurnException("Player X should move first");
        }
        return message;
    }
}