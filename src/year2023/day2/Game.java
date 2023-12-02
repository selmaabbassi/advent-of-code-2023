package year2023.day2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Game {

    int gameId;
    List<Subset> subsets = new ArrayList<>();

    public Game(String line) {
        initializeGame(line);
    }

    public boolean containsCubesHigherThanMax() {
        return subsets.stream().anyMatch(subset -> subset.getCubes().stream().anyMatch(cube -> cube.isHigherThanMax));
    }

    public int getPowerOfHighestCubes() {
        return getHighestCube("red").amount * getHighestCube("green").amount * getHighestCube("blue").amount;
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

    private Cube getHighestCube(String matcher) {
        List<Cube> cubes = subsets.stream().flatMap(subset -> subset.getCubes().stream().filter(cube -> cube.color.equals(matcher))).toList();
        Optional<Cube> highestCube = cubes.stream().max(Comparator.comparingInt(cube -> cube.amount));
        return highestCube.orElse(null);
    }
}
