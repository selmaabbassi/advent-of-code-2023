package year2022.day4;

import java.util.ArrayList;
import java.util.List;

public class Elf {

    int firstValue;
    int secondValue;

    List<Integer> rangeList;

    public Elf(String range) {
        this.rangeList = new ArrayList<>();
        formatRange(range);
    }

    private void formatRange(String range) {
        String[] split = range.split("-");
        this.firstValue = Integer.parseInt(split[0]);
        this.secondValue = Integer.parseInt(split[1]);

        for (int i = firstValue; i <= secondValue; i++) {
            rangeList.add(i);
        }
    }
}
