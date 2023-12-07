package year2023.day7;

public enum HandType {

    FIVE_OF_A_KIND(6),
    FOUR_OF_A_KIND(5),
    FULL_HOUSE(4),
    THREE_OF_A_KIND(3),
    TWO_PAIR(2),
    ONE_PAIR(1),
    HIGH(0);

    final int rank;

    HandType(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }
}
