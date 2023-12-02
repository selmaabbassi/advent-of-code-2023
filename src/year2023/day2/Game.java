package year2023.day2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Game {

    int gameId;
    List<Subset> subsets = new ArrayList<>();
    final static int RED_MAX = 12;
    final static int GREEN_MAX = 13;
    final static int BLUE_MAX = 14;

    /* Highest cubes in this game -> Minimum required amount of cubes for this game to be possible */
    private int highestRedCube;
    private int highestBlueCube;
    private int highestGreenCube;

    public Game(String line) {
        initializeGame(line);
    }

    public boolean containsCubesHigherThanMax() {
        return subsets.stream()
                .anyMatch(subset -> subset.getCubes().stream()
                        .anyMatch(cube -> cube.isHigherThanMax));
    }

    public int getPowerOfHighestCubes() {
        return highestBlueCube * highestGreenCube * highestRedCube;
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

        setHighestCubes();
    }

    private void setHighestCubes() {
        setMaxRedCube();
        setMaxBlueCube();
        setMaxGreenCube();
    }

    private void setMaxRedCube() {
        highestRedCube = getHighestCube("red").amount;
    }

    private void setMaxBlueCube() {
        highestBlueCube = getHighestCube("blue").amount;
    }

    private void setMaxGreenCube() {
        highestGreenCube = getHighestCube("green").amount;
    }

    private Cube getHighestCube(String matcher) {
        List<Cube> cubes = subsets.stream().flatMap(subset -> subset.getCubes().stream()
                .filter(cube -> cube.color.equals(matcher))).toList();
        Optional<Cube> highestCube = cubes.stream().max(Comparator.comparingInt(cube -> cube.amount));
        return highestCube.orElse(null);
    }
}
