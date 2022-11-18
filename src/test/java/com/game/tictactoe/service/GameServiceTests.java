package com.game.tictactoe.service;

import com.game.tictactoe.domain.Player;
import com.game.tictactoe.exception.InvalidPositionException;
import com.game.tictactoe.exception.InvalidTurnException;
import com.game.tictactoe.exception.PositionAlreadyOccupiedException;
import com.game.tictactoe.util.GameBoard;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceTests {

    private GameService gameService;

    @Before
    public void setUp() {

        GameBoard gameBoard = new GameBoard();
        gameService = new GameService(gameBoard);
    }

    @Test
    public void xShouldAlwaysMoveFirst() {

        assertThat(gameService.playGame(Player.X, 2)).isEqualTo("Successful Move");
    }

    @Test(expected = InvalidTurnException.class)
    public void isPlayerOMovingFirst() {

        gameService.playGame(Player.O, 1);
    }

    @Test
    public void savePositionOnBoard() {

        assertThat(gameService.playGame(Player.X, 2)).isEqualTo("Successful Move");
    }

    @Test
    public void playersShouldPlayAlternateTurns() {

        gameService.playGame(Player.X, 2);

        assertThat(gameService.playGame(Player.O, 1)).isEqualTo("Successful Move");
    }

    @Test(expected = InvalidPositionException.class)
    public void shouldThrowInvalidPositionException() {

        gameService.playGame(Player.X, 0);
    }

    @Test(expected = InvalidTurnException.class)
    public void shouldThrowInvalidTurnExceptionWhenSamePlayerPlaysConsecutiveTurns() {

        gameService.playGame(Player.X, 1);
        gameService.playGame(Player.X, 2);
    }

    @Test(expected = PositionAlreadyOccupiedException.class)
    public void shouldThrowPositionAlreadyOccupiedExceptionWhenPlayerPlaysOnOccupiedPosition() {

        gameService.playGame(Player.X, 3);
        gameService.playGame(Player.O, 3);
    }
}