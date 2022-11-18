package com.game.tictactoe.util;

import com.game.tictactoe.domain.Player;
import com.game.tictactoe.domain.Position;
import org.springframework.stereotype.Component;

@Component
public class GameBoard {

    private static final int EMPTY_POSITION_ON_BOARD = 0;
    private final char[][] board = new char[3][3];

    public char savePlayerOnPosition(Player player, Position position) {
        return board[position.getRow()][position.getColumn()] = player.getValue();
    }

    public char getPositionValueOnBoard(Position position) {
        return board[position.getRow()][position.getColumn()];
    }

    public boolean isAnyRowOccupiedBySamePlayer() {

        return isFirstRowOccupiedBySamePlayer() || isSecondRowOccupiedBySamePlayer() || isThirdRowOccupiedBySamePlayer();
    }

    public boolean isAnyColumnOccupiedBySamePlayer() {

        return isFirstColumnOccupiedBySamePlayer() || isSecondColumnOccupiedBySamePlayer() || isThirdColumnOccupiedBySamePlayer();
    }

    private boolean isFirstRowOccupiedBySamePlayer() {

        if (getPositionValueOnBoard(Position.ONE) != EMPTY_POSITION_ON_BOARD) {
            return (getPositionValueOnBoard(Position.ONE) == getPositionValueOnBoard(Position.TWO) &&
                    getPositionValueOnBoard(Position.TWO) == getPositionValueOnBoard(Position.THREE));
        }
        return false;
    }

    private boolean isSecondRowOccupiedBySamePlayer() {

        if (getPositionValueOnBoard(Position.FOUR) != EMPTY_POSITION_ON_BOARD) {
            return (getPositionValueOnBoard(Position.FOUR) == getPositionValueOnBoard(Position.FIVE) &&
                    getPositionValueOnBoard(Position.FIVE) == getPositionValueOnBoard(Position.SIX));
        }
        return false;
    }

    private boolean isThirdRowOccupiedBySamePlayer() {

        if (getPositionValueOnBoard(Position.SEVEN) != EMPTY_POSITION_ON_BOARD) {
            return (getPositionValueOnBoard(Position.SEVEN) == getPositionValueOnBoard(Position.EIGHT) &&
                    getPositionValueOnBoard(Position.EIGHT) == getPositionValueOnBoard(Position.NINE));
        }
        return false;
    }

    private boolean isFirstColumnOccupiedBySamePlayer() {

        if (getPositionValueOnBoard(Position.ONE) != EMPTY_POSITION_ON_BOARD) {
            return (getPositionValueOnBoard(Position.ONE) == getPositionValueOnBoard(Position.FOUR) &&
                    getPositionValueOnBoard(Position.FOUR) == getPositionValueOnBoard(Position.SEVEN));
        }
        return false;
    }

    private boolean isSecondColumnOccupiedBySamePlayer() {

        if (getPositionValueOnBoard(Position.TWO) != EMPTY_POSITION_ON_BOARD) {
            return (getPositionValueOnBoard(Position.TWO) == getPositionValueOnBoard(Position.FIVE) &&
                    getPositionValueOnBoard(Position.FIVE) == getPositionValueOnBoard(Position.EIGHT));
        }
        return false;
    }

    private boolean isThirdColumnOccupiedBySamePlayer() {

        if (getPositionValueOnBoard(Position.THREE) != EMPTY_POSITION_ON_BOARD) {
            return (getPositionValueOnBoard(Position.THREE) == getPositionValueOnBoard(Position.SIX) &&
                    getPositionValueOnBoard(Position.SIX) == getPositionValueOnBoard(Position.NINE));
        }
        return false;
    }

    public boolean isFirstDiagonalOccupiedBySamePlayer() {

        if (getPositionValueOnBoard(Position.ONE) != EMPTY_POSITION_ON_BOARD) {
            return (getPositionValueOnBoard(Position.ONE) == getPositionValueOnBoard(Position.FIVE) &&
                    getPositionValueOnBoard(Position.FIVE) == getPositionValueOnBoard(Position.NINE));
        }
        return false;
    }
}