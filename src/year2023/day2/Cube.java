package year2023.day2;

import static year2023.day2.Game.*;

public class Cube {

    int amount;
    String color;
    boolean isHigherThanMax = false;
    final static int RED_MAX = 12;
    final static int GREEN_MAX = 13;
    final static int BLUE_MAX = 14;

    public Cube(String cubeAsString) {
        setCube(cubeAsString);
    }

    private void setCube(String cubeAsString) {
        String[] cube = cubeAsString.split(" ");
        amount = Integer.parseInt(cube[0]);
        color = cube[1];

        setIsHigherThanMax();
    }

    private void setIsHigherThanMax() {
        switch (color) {
            case "red" -> isHigherThanMax = amount > RED_MAX;
            case "green" -> isHigherThanMax = amount > GREEN_MAX;
            case "blue" -> isHigherThanMax = amount > BLUE_MAX;
            default -> throw new IllegalArgumentException("Invalid color: " + color);
        }
    }
}
