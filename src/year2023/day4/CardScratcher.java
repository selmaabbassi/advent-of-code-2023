package year2023.day4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CardScratcher {

    List<Card> cards;
    List<Integer> totalCopies;
    int points;

    public CardScratcher() {
        cards = new ArrayList<>();
    }

    public List<Integer> getTotalCopies() {
        return totalCopies;
    }

    public void appendCard(String line) {
        cards.add(new Card(line));
    }

    public Card findById(int cardId) {
        return cards.stream().filter(card -> card.cardId == cardId).findFirst().orElseThrow();
    }

    public void print() {
        for (Card card : cards) {
            System.out.println(card.toString());
        }
    }

    public int calculateTotalCopies() {
        totalCopies = new ArrayList<>();

        //add original cards
        for (int i = 0; i < cards.size(); i++) {
            Card originalCard = findById(i + 1);
            totalCopies.add(originalCard.getCardId());
            List<Integer> recursive = recursive(findById(originalCard.getCardId()));
            totalCopies.addAll(recursive);
        }

        return totalCopies.size();
    }

    private List<Integer> recursive(Card card) {
        List<Integer> copies = new ArrayList<>(card.getCopyIds());
        List<Integer> newCopies = new ArrayList<>();

        for (Integer integer : copies) {
            Card copy = findById(integer);
            newCopies.addAll(recursive(copy));
        }

        copies.addAll(newCopies);
        return copies;
    }

    public int calculatePoints() {
        AtomicInteger sum = new AtomicInteger();

        cards.forEach(card -> {
            List<Integer> matchingNumbers = card.getCopyIds();

            if (matchingNumbers.size() == 1) {
                points = 1;
            } else {
                points = (int) Math.pow(2, matchingNumbers.size() - 1);
            }
            sum.addAndGet(points);
        });

        return sum.get();
    }

}
