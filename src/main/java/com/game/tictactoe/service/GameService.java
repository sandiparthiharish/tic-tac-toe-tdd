package com.game.tictactoe.service;

import org.springframework.stereotype.Service;

@Service
public class GameService {

    public String playGame(char player) {

        String message = "Unsuccessful Move";
        if (player == 'X') {
            message = "Successful Move";
        }
        return message;
    }
}