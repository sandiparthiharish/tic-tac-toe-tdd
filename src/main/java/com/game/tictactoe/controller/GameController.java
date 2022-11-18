package com.game.tictactoe.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    @PostMapping(value = "/tic-tac-toe/play/{player}")
    public ResponseEntity<String> PlayGameHandler(@PathVariable(name = "player") char player) {

        String message = "Unsuccessful Move";
        if (player == 'X') {
            message = "Successful Move";
        }
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
}