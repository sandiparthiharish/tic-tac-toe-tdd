package com.game.tictactoe.service;

import com.game.tictactoe.domain.Player;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    public String playGame(Player player) {

        String message = "Unsuccessful Move";
        if (player == Player.X) {
            message = "Successful Move";
        } else if (player == Player.O) {
            message = "Player X should move first";
        }
        return message;
    }
}