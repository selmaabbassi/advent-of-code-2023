package year2023.day7;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        HandType handType = defineHandType(cards);
        return new Hand(handType, cards, Integer.parseInt(bet));
    }

    private HandType defineHandType(List<Card> cards) {
        Map<String, Long> occurrences = cards.stream()
                .collect(Collectors.groupingBy(c -> c.type.getValue(), Collectors.counting()));

        boolean five_of_a_kind = occurrences.values().stream().anyMatch(count -> count == 5);
        boolean four_of_a_kind = occurrences.values().stream().anyMatch(count -> count == 4);
        boolean three_of_a_kind = occurrences.values().stream().anyMatch(count -> count == 3);
        boolean one_pair = occurrences.values().stream().anyMatch(count -> count == 2);
        boolean two_pairs = occurrences.values().stream().filter(count -> count == 2).count() == 2;
        boolean full_house = three_of_a_kind && one_pair;

        if (five_of_a_kind)
            return HandType.FIVE_OF_A_KIND;
        if (four_of_a_kind)
            return HandType.FOUR_OF_A_KIND;
        if (full_house)
            return HandType.FULL_HOUSE;
        if (three_of_a_kind)
            return HandType.THREE_OF_A_KIND;
        if (two_pairs)
            return HandType.TWO_PAIR;
        if (one_pair)
            return HandType.ONE_PAIR;
        return HandType.HIGH;
    }
}
