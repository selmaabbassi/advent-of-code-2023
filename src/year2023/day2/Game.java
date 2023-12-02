package year2023.day2;

import java.util.ArrayList;
import java.util.List;

public class Game {

    int gameId;
    List<Subset> subsets = new ArrayList<>();
    final static int RED_MAX = 12;
    final static int GREEN_MAX = 13;
    final static int BLUE_MAX = 14;

    public Game(String line) {
        initializeGame(line);
    }

    public boolean containsCubesHigherThanMax() {
        return subsets.stream().anyMatch(subset -> subset.cubes.stream().anyMatch(cube -> cube.isHigherThanMax));
    }

    private void initializeGame(String line) {
        String[] mod = line.split(":", 0);

        String gameIdAsString = mod[0];
        String gameId = gameIdAsString.replaceAll("[^0-9]", "");
        this.gameId = Integer.parseInt(gameId.trim());

        String subsetsAsString = mod[1];
        String[] subsetAsString = subsetsAsString.split(";");

        for (String subset : subsetAsString) {
            subsets.add(new Subset(subset.trim()));
        }
    }
}
