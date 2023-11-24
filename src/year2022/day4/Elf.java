package year2022.day4;

import java.util.ArrayList;
import java.util.List;

public class Elf {

    String range;

    public Elf(String range) {
        this.range = formatRange(range);
    }

    private String formatRange(String range) {
        String[] split = range.split("-");
        int firstValue = Integer.parseInt(split[0]);
        int secondValue = Integer.parseInt(split[1]);

        List<Integer> rangeArray = new ArrayList<>();

        for (int i = firstValue; i <= secondValue; i++) {
            rangeArray.add(i);
        }

        String s = rangeArray.toString();
        return s.substring(1, s.length() - 1);
    }
}
