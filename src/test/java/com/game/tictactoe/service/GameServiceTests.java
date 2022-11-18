package com.game.tictactoe.service;

import com.game.tictactoe.domain.Player;
import com.game.tictactoe.exception.InvalidTurnException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceTests {

    @Test
    public void xShouldAlwaysMoveFirst() {

        GameService gameService = new GameService();

        assertThat(gameService.playGame(Player.X)).isEqualTo("Successful Move");
    }

    @Test(expected = InvalidTurnException.class)
    public void isPlayerOMovingFirst() {

        GameService gameService = new GameService();

        gameService.playGame(Player.O);
    }
}