package year2023.day7;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class JokerMapper {

    public JokerMapper() {
    }

    public void mapJokersToHigherRank(Hand hand) {
        boolean hasJoker = hand.getCards().stream().anyMatch(card -> card.getCardType().equals(CardType.JOKER));
        if (hasJoker)
            mapJokers(hand);
    }

    private void mapJokers(Hand hand) {
        HandType handType = hand.getHandType();
        Card highestCard = hand.getHighestRankedCard();

        /**
         * JJJJJ
         */
        if (handType.equals(HandType.FIVE_OF_A_KIND)) {
            hand.getCards().forEach(card -> card.setCardType(CardType.ACE));
        }

        /**
         * AAAAJ
         * JJJJA
         */
        if (handType.equals(HandType.FOUR_OF_A_KIND) || handType.equals(HandType.FULL_HOUSE)) {
            Card otherCard = hand.getCards().stream().filter(card -> !card.getCardType().equals(CardType.JOKER)).findFirst().get();
            setJokersTo(hand, otherCard.getCardType());
        }

        /**
         * AAAJ2 - 333J2
         * JJJA2
         */
        //hand type 3 of a kind
        if (handType.equals(HandType.THREE_OF_A_KIND)) {
            CardType three_of_a_kind = hand.findCardTypeWithOccurrences(3).orElseThrow();

            //set J to highest other card for a four-of-a-kind
            if (three_of_a_kind.equals(CardType.JOKER)) {
                setJokersTo(hand, highestCard.getCardType());
                //set J to card with 3 occurrences for a four-of-a-kind
            } else {
                setJokersTo(hand, three_of_a_kind);
            }
        }

        /**
         * AAJJ2
         * AAKKJ
         */
        if (handType.equals(HandType.TWO_PAIR)) {
            Pair<CardType, CardType> two_pair = hand.findTwoPairs();

            if (two_pair.getLeft().equals(CardType.JOKER)) {
                setJokersTo(hand, two_pair.getRight());
            } else if (two_pair.getRight().equals(CardType.JOKER)) {
                setJokersTo(hand, two_pair.getLeft());
            } else {
                setJokersTo(hand, highestCard.getCardType());
            }
        }

        /**
         * AAJ23
         */
        //hand type one pair
        if (handType.equals(HandType.ONE_PAIR)) {
            CardType one_pair = hand.findCardTypeWithOccurrences(1).orElseThrow();
            setJokersTo(hand, one_pair);
        }

        /**
         * 2345J
         */
        //hand type high
        if (handType.equals(HandType.HIGH)) {
            //set to highest card -> to get one_pair
            setJokersTo(hand, highestCard.getCardType());
        }

    }

    private void setJokersTo(Hand hand, CardType cardType) {
        List<Card> cards = hand.getCards();
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getCardType().equals(CardType.JOKER)) {
                cards.set(i, new Card(cardType));
            }
        }
    }
}
