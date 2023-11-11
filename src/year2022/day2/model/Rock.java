package year2022.day2.model;

public class Rock extends GameMove {
    public Rock() {
        this.score = 1;
    }

    @Override
    public int compareTo(GameMove gameMove) {
        if (gameMove instanceof Paper) {
            return -1;
        } else if (gameMove instanceof Scissors) {
            return 1;
        } else if (gameMove instanceof Rock) {
            return 0;
        } else {
            throw new ClassCastException();
        }
    }
}
