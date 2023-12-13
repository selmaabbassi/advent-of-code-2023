package year2015.day2;

import java.util.ArrayList;
import java.util.List;

public class LineParser {

    private final List<Present> presents;

    public LineParser() {
        presents = new ArrayList<>();
    }

    public void addPresent(String line) {
        String[] split = line.split("x");

        int length = Integer.parseInt(split[0]);
        int width = Integer.parseInt(split[1]);
        int height = Integer.parseInt(split[2]);

        presents.add(new Present(length, width, height));
    }

    public int getRequiredWrappingPaper() {
        int sum = 0;

        for (Present present : presents) {
            sum += present.getRequiredWrappingPaper();
        }

        return sum;
    }

    public int getRequiredRibbon() {
        int sum = 0;

        for (Present present : presents) {
            sum += present.getRequiredRibbon();
        }

        return sum;
    }

    public void print() {
        presents.forEach(Present::print);
    }

}
