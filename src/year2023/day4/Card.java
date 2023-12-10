package year2023.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Card {

    int cardId;
    List<Integer> winningCards;
    List<Integer> playerCards;
    List<Integer> copyIds;


    public Card(String line) {
        winningCards = new ArrayList<>();
        playerCards = new ArrayList<>();

        initateCard(line);
    }

    public int getCardId() {
        return cardId;
    }

    private void initateCard(String line) {
        String[] split = line.split("\\|");
        String playerCard = split[0].trim();
        String winningCard = split[1].trim();

        appendPlayerCard(playerCard);
        appendWinningCard(winningCard);

        setCopyIds();
    }

    public List<Integer> getCopyIds() {
        return copyIds;
    }

    private void appendWinningCard(String line) {
        String[] cards = line.split("\\s+");
        Arrays.stream(cards).forEach(c -> winningCards.add(Integer.parseInt(c)));
    }

    private void appendPlayerCard(String line) {
        String[] split = line.split(":");
        String[] cardIdAsString = split[0].split("\\s+");
        this.cardId = Integer.parseInt(cardIdAsString[1].trim());
        String[] cards = split[1].trim().split("\\s+");

        Arrays.stream(cards).forEach(c -> {
            if (!Objects.equals(c, " ")) {
                playerCards.add(Integer.parseInt(c));
            }
        });
    }

    private void setCopyIds() {
        copyIds = new ArrayList<>();
        List<Integer> matchingNumbers = playerCards.stream().filter(pc -> winningCards.contains(pc)).toList();

        for (int i = 1; i <= matchingNumbers.size(); i++) {
            copyIds.add(cardId + i);
        }
    }

    @Override
    public String toString() {
        return "Player Cards: " + "ID: " + cardId + " : " + Arrays.toString(playerCards.toArray()) +
                " Winning Cards: " + Arrays.toString(winningCards.toArray()) +
                " Copies Cards: " + Arrays.toString(copyIds.toArray());
    }
}
