package year2023.day6;

import java.util.List;

public class Race {

    List<Boat> boats;

    public Race(List<Boat> boats) {
        this.boats = boats;
    }

    public int calculateWaysToBeatRecord() {
        int product = 1;

        for (Boat boat : boats) {
            product *= boat.calculateWaysToBeatRecord();
        }

        return product;
    }
}
