package year2022.day2.model;

public class Scissors extends GameMove {
    public Scissors() {
        this.score = 3;
    }

    @Override
    public int compareTo(GameMove gameMove) {
        if (gameMove instanceof Rock) {
            return -1;
        } else if (gameMove instanceof Paper) {
            return 1;
        } else if (gameMove instanceof Scissors) {
            return 0;
        } else {
            throw new ClassCastException();
        }
    }

    @Override
    public GameMove getWinningOpponingMove() {
        return new Rock();
    }

    @Override
    public GameMove getLosingOpponingMove() {
        return new Paper();
    }
}
