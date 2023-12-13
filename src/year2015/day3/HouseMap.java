package year2015.day3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HouseMap {

    private final List<House> visitedHouses;
    private final char[] directions;

    public HouseMap(String directions) {
        this.directions = directions.toCharArray();
        visitedHouses = new ArrayList<>();
    }

    public void setVisitedHouses() {
        House firstHouse = new House(0, 0);
        visitedHouses.add(firstHouse);
        recursive(firstHouse, 0);
    }

    public List<House> getVisitedHouses() {
        return visitedHouses;
    }

    public Set<House> getUniqueHouses() {
        return new HashSet<>(visitedHouses);
    }

    private void recursive(House current, int index) {
        if (index == directions.length) {
            return;
        }

        House nextHouse;

        /* north */
        if (directions[index] == '^') {
            nextHouse = visitNorthHouse(current);
            index++;
            recursive(nextHouse, index);
        } else

            /* south */
            if (directions[index] == 'v') {
                nextHouse = visitSouthHouse(current);
                index++;
                recursive(nextHouse, index);
            } else

                /* east */
                if (directions[index] == '>') {
                    nextHouse = visitEastHouse(current);
                    index++;
                    recursive(nextHouse, index);
                } else

                    /* west */
                    if (directions[index] == '<') {
                        nextHouse = visitWestHouse(current);
                        index++;
                        recursive(nextHouse, index);
                    }
    }

    private House visitNorthHouse(House current) {
        House house = new House(current.getX(), current.getY() + 1);
        visitedHouses.add(house);
        return house;
    }

    private House visitSouthHouse(House current) {
        House house = new House(current.getX(), current.getY() - 1);
        visitedHouses.add(house);
        return house;
    }

    private House visitEastHouse(House current) {
        House house = new House(current.getX() + 1, current.getY());
        visitedHouses.add(house);
        return house;
    }

    private House visitWestHouse(House current) {
        House house = new House(current.getX() - 1, current.getY());
        visitedHouses.add(house);
        return house;
    }
}
