package year2022.day2;

import year2022.day2.model.GameMove;
import year2022.day2.model.Paper;
import year2022.day2.model.Rock;
import year2022.day2.model.Scissors;

public class GameMoveMapper {

    private GameMoveMapper() {
    }

    public static GameMove mapToForPlayerOne(String value) {
        if (value.equals("A")) {
            return new Rock();
        }

        if (value.equals("B")) {
            return new Paper();
        }

        if (value.equals("C")) {
            return new Scissors();
        }
        throw new ClassCastException("Can't create GameMove object from " + value);
    }

    public static GameMove mapToForPlayerTwo(GameMove playerOneMove, String value) {
        // X -> You Lose
        // Y - > Draw
        // Z -> You Win

        if (value.equals("X")) {
            return playerOneMove.getLosingOpponingMove();
        }
        if (value.equals("Y")) {
            return playerOneMove;
        }
        if (value.equals("Z")) {
            return playerOneMove.getWinningOpponingMove();
        }

        throw new ClassCastException("Can't create GameMove object from " + value);
    }
}
