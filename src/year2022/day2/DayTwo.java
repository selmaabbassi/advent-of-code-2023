package year2022.day2;

import year2022.day2.model.GameMove;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * GAME RULES
 * <p>
 * MOVES
 * <p>
 * A = X = Rock = 1
 * B = Y = Paper = 2
 * C = Z = Scissors = 3
 * <p>
 * OUTCOME
 * <p>
 * Lose = 0
 * Draw = 3
 * Win = 6
 */
public class DayTwo {

    public static void main(String[] args) {
        Path filePath = Path.of("src/year2022/day2/d2.txt");

        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;
            int playerOneScore = 0;
            int playerTwoScore = 0;

            while ((line = reader.readLine()) != null) {
                String[] split = line.split("\\s+");
                String player1 = split[0];
                String player2 = split[1];

                GameMove moveP1 = GameMoveMapper.mapToForPlayerOne(player1);
                GameMove moveP2 = GameMoveMapper.mapToForPlayerTwo(moveP1, player2);

                System.out.println("PLAYER 1: " + player1 + " " + moveP1.getClass().getSimpleName() + " " + moveP1.getScore());
                System.out.println("PLAYER 2: " + player2 + " " + moveP2.getClass().getSimpleName() + " " + moveP2.getScore());

                Player p1 = new Player(moveP1);
                Player p2 = new Player(moveP2);

                RoundScore roundScore = new RoundScore(p1, p2);

                roundScore.calculateWinner();

                System.out.println("PLAYER 1 RESULT: " + roundScore.player1.roundScore);
                System.out.println("PLAYER 2 RESULT: " + roundScore.player2.roundScore);

                playerOneScore += roundScore.player1.roundScore;
                playerTwoScore += roundScore.player2.roundScore;
            }

            System.out.println("P1: " + playerOneScore);
            System.out.println("P2: " + playerTwoScore);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
