package year2023.day6;

import java.util.ArrayList;
import java.util.List;

public class Day6 {

    public static void main(String[] args) {
        //part 1
        Boat boat1 = new Boat(45, 305);
        Boat boat2 = new Boat(97, 1062);
        Boat boat3 = new Boat(72, 1110);
        Boat boat4 = new Boat(95, 1695);

        //part 2
        Boat boat5 = new Boat(45977295L, 305106211101695L);

        Race race = new Race(new ArrayList<>(List.of(boat5)));
//        Race race = new Race(new ArrayList<>(List.of(boat1, boat2, boat3, boat4)));
        int product = race.calculateWaysToBeatRecord();

        System.out.println("Product of ways to beat the record: " + product);
    }
}
