package year2023.day7;

import java.util.ArrayList;
import java.util.List;

public class LineParser {

    List<Hand> hands;

    public LineParser() {
        hands = new ArrayList<>();
    }

    public void appendHand(String line) {
        String[] s = line.split(" ");
        String hand = s[0];
        String bet = s[1];

        hands.add(createHand(hand, bet));
    }

    public List<Hand> getHands() {
        return hands;
    }

    private Hand createHand(String hand, String bet) {
        char[] cardsAsString = hand.toCharArray();

        List<Card> cards = new ArrayList<>();

        for (char card : cardsAsString) {
            cards.add(new Card(CardType.getByValue(String.valueOf(card))));
        }

        return new Hand(cards, Integer.parseInt(bet));
    }
}
