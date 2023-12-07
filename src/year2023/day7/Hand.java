package year2023.day7;

import java.util.Arrays;
import java.util.List;

public class Hand implements Comparable<Hand> {

    HandType type;
    List<Card> cards;
    int bet;

    public Hand(HandType type, List<Card> cards, int bet) {
        this.type = type;
        this.cards = cards;
        this.bet = bet;
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public int compareTo(Hand otherHand) {
        int compare = Integer.compare(type.getRank(), otherHand.type.getRank());
        if (compare == 0) {
            // If hands are equal, compare individual cards
            for (int i = 0; i < cards.size(); i++) {
                int cardComparison = cards.get(i).compareTo(otherHand.getCards().get(i));

                if (cardComparison != 0) {
                    // If cards are not equal, return the result
                    return cardComparison;
                }
            }
        }
        return compare;
    }

    public void print() {
        System.out.println(Arrays.toString(cards.toArray()) + " : " + bet + " : " + type.toString());
    }


}
