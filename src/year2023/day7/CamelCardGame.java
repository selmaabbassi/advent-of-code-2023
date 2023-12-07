package year2023.day7;

import java.util.List;

public class CamelCardGame {

    private final List<Hand> hands;
    private final BubbleSorter sorter;

    public CamelCardGame(List<Hand> hands) {
        this.hands = hands;
        this.sorter = new BubbleSorter();
        sortCards();
    }

    private void sortCards() {
        sorter.sort(hands);
    }

    public int calculateSum() {
        int sum = 0;

        for (int i = 0; i < hands.size(); i++) {
            sum += (i + 1) * hands.get(i).bet;
        }

        return sum;
    }

    public void print() {
        hands.forEach(Hand::print);
    }
}
