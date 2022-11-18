package com.game.tictactoe.service;

import com.game.tictactoe.domain.Player;
import com.game.tictactoe.exception.InvalidTurnException;
import com.game.tictactoe.util.GameBoard;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceTests {

    @Test
    public void xShouldAlwaysMoveFirst() {

        GameBoard gameBoard = new GameBoard();
        GameService gameService = new GameService(gameBoard);

        assertThat(gameService.playGame(Player.X, 0, 1)).isEqualTo("Successful Move");
    }

    @Test(expected = InvalidTurnException.class)
    public void isPlayerOMovingFirst() {

        GameBoard gameBoard = new GameBoard();
        GameService gameService = new GameService(gameBoard);

        gameService.playGame(Player.O, 0, 0);
    }

    @Test
    public void savePositionOnBoard() {

        GameBoard gameBoard = new GameBoard();
        GameService gameService = new GameService(gameBoard);

        assertThat(gameService.playGame(Player.X, 0, 2)).isEqualTo("Successful Move");
    }
}