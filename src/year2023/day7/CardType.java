package year2023.day7;

public enum CardType {

    ACE("A", 14),
    KING("K", 13),
    QUEEN("Q", 12),
    TEN("T", 10),
    NINE("9", 9),
    EIGHT("8", 8),
    SEVEN("7", 7),
    SIX("6", 6),
    FIVE("5", 5),
    FOUR("4", 4),
    THREE("3", 3),
    TWO("2", 2),
    JOKER("J", 1);

    private final String value;
    private final int rank;

    CardType(String value, int rank) {
        this.value = value;
        this.rank = rank;
    }

    public static CardType getByValue(String value) {
        for (CardType myEnum : values()) {
            if (myEnum.value.equals(value)) {
                return myEnum;
            }
        }
        throw new IllegalArgumentException("No enum constant with custom value: " + value);
    }

    public String getValue() {
        return value;
    }

    public int getRank() {
        return rank;
    }
}
