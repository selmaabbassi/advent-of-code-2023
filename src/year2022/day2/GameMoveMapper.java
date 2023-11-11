package year2022.day2;

import year2022.day2.model.GameMove;
import year2022.day2.model.Paper;
import year2022.day2.model.Rock;
import year2022.day2.model.Scissors;

public class GameMoveMapper {

    private GameMoveMapper() {
    }

    public static GameMove mapTo(String value) {

        if (value.equals("A") || value.equals("X")) {
            return new Rock();
        }

        if (value.equals("B") || value.equals("Y")) {
            return new Paper();
        }

        if (value.equals("C") || value.equals("Z")) {
            return new Scissors();
        }

        throw new RuntimeException();
    }
}
