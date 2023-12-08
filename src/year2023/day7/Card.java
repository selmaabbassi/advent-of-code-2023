package year2023.day7;

public class Card implements Comparable<Card> {

    private CardType cardType;

    public Card(CardType cardType) {
        this.cardType = cardType;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    @Override
    public int compareTo(Card otherCard) {
        return Integer.compare(cardType.getRank(), otherCard.cardType.getRank());
    }

    @Override
    public String toString() {
        return cardType.getValue();
    }
}
