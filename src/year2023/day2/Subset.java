package year2023.day2;

import java.util.ArrayList;
import java.util.List;

public class Subset {

    List<Cube> cubes = new ArrayList<>();

    public Subset(String subsetAsString) {
        setCubes(subsetAsString);
    }

    private void setCubes(String subsetAsString) {
        String[] cubesAsString = subsetAsString.split(",");
        for (String cube: cubesAsString) {
            cubes.add(new Cube(cube.trim()));
        }
    }
}
