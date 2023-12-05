package year2023.day4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CardScratcher {

        List<Card> cards;
        int points;

        public CardScratcher() {
                cards = new ArrayList<>();
        }

        public void appendCard(String line) {
                cards.add(new Card(line));
        }

        public void print() {
                for (Card card : cards) {
                        System.out.println(card.toString());
                }
        }

        public int calculatePoints() {
                AtomicInteger sum = new AtomicInteger();

                cards.forEach(card -> {
                        List<Integer> matchingNumbers = card.findMatchingNumbers();

                        if (matchingNumbers.size() == 1) {
                                points = 1;
                        } else {
                                points = (int) Math.pow(2, matchingNumbers.size() - 1);
                        }
                        System.out.println("Points " + points);
                        sum.addAndGet(points);
                });

                System.out.println(sum.get());
                return sum.get();
        }


}
