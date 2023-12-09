package year2023.day7;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Hand implements Comparable<Hand> {

    List<Card> cards;
    List<Card> remappedCards;
    int bet;
    HandType handType;

    public Hand(List<Card> cards, int bet) {
        this.cards = cards;
        this.bet = bet;
        this.handType = defineHandType(getOccurrences(cards));
    }

    public List<Card> getCards() {
        return cards;
    }

    public HandType getHandType() {
        return handType;
    }

    private Map<CardType, Long> getOccurrences(List<Card> cards) {
        return cards.stream()
                .collect(Collectors.groupingBy(Card::getCardType, Collectors.counting()));
    }

    public void remapJokers() {
        JokerMapper mapper = new JokerMapper();
        this.remappedCards = mapper.remapJokerCards(this);
        this.handType = defineHandType(getOccurrences(remappedCards));
    }

    public HandType defineHandType(Map<CardType, Long> occurrences) {
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

    public Card getHighestRankedCard() {
        Card maxCard = cards.get(0);

        for (Card card : cards) {
            if (card.compareTo(maxCard) > 0) {
                maxCard = card;
            }
        }
        return maxCard;
    }

    public Optional<CardType> findCardTypeWithOccurrences(long desiredOccurrences) {
        for (Map.Entry<CardType, Long> entry : getOccurrences(cards).entrySet()) {
            if (entry.getValue() == desiredOccurrences) {
                return Optional.of(entry.getKey());
            }
        }
        return Optional.empty();
    }

    public Pair<CardType, CardType> findTwoPairs() {
        if (!handType.equals(HandType.TWO_PAIR)) {
            throw new IllegalArgumentException("Hand not of type " + HandType.TWO_PAIR.name());
        }
        List<CardType> pairs = new ArrayList<>();

        for (Map.Entry<CardType, Long> entry : getOccurrences(cards).entrySet()) {
            if (entry.getValue() == 2) {
                pairs.add(entry.getKey());
            }
        }
        return Pair.of(pairs.get(0), pairs.get(1));
    }

    @Override
    public int compareTo(Hand otherHand) {
        int compare = Integer.compare(handType.getRank(), otherHand.handType.getRank());
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
        System.out.println("Original Hand: " + Arrays.toString(cards.toArray()) + " : " + bet + " : " + handType.toString());
        System.out.println("Remapped Hand: " + Arrays.toString(remappedCards.toArray()) + " : " + bet + " : " + handType.toString());
        System.out.println("------------------------------------");
    }
}
