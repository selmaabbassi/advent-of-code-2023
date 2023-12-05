package year2023.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Card {

        List<Integer> winningCards;
        List<Integer> playerCards;

        public Card(String line) {
                winningCards = new ArrayList<>();
                playerCards = new ArrayList<>();

                initateCard(line);
        }

        private void initateCard(String line) {
                String[] split = line.split("\\|");
                String playerCard = split[0].trim();
                String winningCard = split[1].trim();

                appendPlayerCard(playerCard);
                appendWinningCard(winningCard);
        }

        private void appendWinningCard(String line) {
                String[] cards = line.split("\\s+");
                Arrays.stream(cards).forEach(c -> winningCards.add(Integer.parseInt(c)));
        }

        private void appendPlayerCard(String line) {
                String[] split = line.split(":");
                String[] cards = split[1].trim().split("\\s+");
                Arrays.stream(cards).forEach(c -> {
                        if (!Objects.equals(c, " ")) {
                                playerCards.add(Integer.parseInt(c));
                        }
                });
        }

        public List<Integer> findMatchingNumbers() {
                return playerCards.stream().filter(pc -> winningCards.contains(pc)).toList();
        }

        @Override
        public String toString() {
                return "Player Cards: " + Arrays.toString(playerCards.toArray()) +
                                " Winning Cards: " + Arrays.toString(winningCards.toArray()) +
                                " Matching Cards: " + Arrays.toString(findMatchingNumbers().toArray());
        }
}
