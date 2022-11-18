package com.game.tictactoe.exception;

import com.game.tictactoe.domain.GameErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {InvalidTurnException.class, InvalidPositionException.class,
            PositionAlreadyOccupiedException.class})
    public ResponseEntity<GameErrorResponse> handleException(RuntimeException ex) {

        GameErrorResponse errorResponse = new GameErrorResponse(ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }
}