package year2023.day2;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    private final List<Cube> cubes = new ArrayList<>();

    public Subset(String subsetAsString) {
        setCubes(subsetAsString);
    }

    public List<Cube> getCubes() {
        return cubes;
    }

    private void setCubes(String subsetAsString) {
        String[] cubesAsString = subsetAsString.split(",");
        for (String cube : cubesAsString) {
            cubes.add(new Cube(cube.trim()));
        }
    }
}
