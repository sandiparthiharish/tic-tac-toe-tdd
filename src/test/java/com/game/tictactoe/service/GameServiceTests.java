package com.game.tictactoe.service;

import com.game.tictactoe.domain.Player;
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

    @Test
    public void isPlayerOMovingFirst() {

        GameService gameService = new GameService();

        assertThat(gameService.playGame(Player.O)).isEqualTo("Player X should move first");
    }
}