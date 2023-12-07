package year2023.day7;

public class Card implements Comparable<Card> {

    CardType type;

    public Card(CardType type) {
        this.type = type;
    }

    @Override
    public int compareTo(Card otherCard) {
        return Integer.compare(type.getRank(), otherCard.type.getRank());
    }

    @Override
    public String toString() {
        return type.getValue();
    }
}
