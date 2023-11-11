package year2022.day2.model;

public class Paper extends GameMove {
    public Paper() {
        this.score = 2;
    }

    @Override
    public int compareTo(GameMove gameMove) {
        if (gameMove instanceof Scissors) {
            return -1;
        } else if (gameMove instanceof Rock) {
            return 1;
        } else if (gameMove instanceof Paper) {
            return 0;
        } else {
            throw new ClassCastException();
        }
    }
}
