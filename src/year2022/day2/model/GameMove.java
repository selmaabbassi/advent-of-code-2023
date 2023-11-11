package year2022.day2.model;

public abstract class GameMove {
    protected int score;

    public int getScore() {
        return score;
    }

    public abstract int compareTo(GameMove gameMove);

    public abstract GameMove getWinningOpponingMove();

    public abstract GameMove getLosingOpponingMove();
}
