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
//                System.out.println(line);
                String[] split = line.split("\\s+");
                String player1 = split[0];
                String player2 = split[1];

//                System.out.println("P1: " + player1);
//                System.out.println("P2: " + player2);
//                System.out.println("" +
//                        "");

                GameMove gameMove_p1 = GameMoveMapper.mapTo(player1);
                GameMove gameMove_p2 = GameMoveMapper.mapTo(player2);

                Player p1 = new Player(gameMove_p1);
                Player p2 = new Player(gameMove_p2);

                RoundScore roundScore = new RoundScore(p1, p2);


                //round[0] -> p1
                //round[1] -> p2

                //metod som ger mig vem som vann och hur mycket båda har fått i poäng

                // Class RoundScore
                // Player1 -> hasWon (false)
                //         -> roundScore 0
                // Player2 -> hasWon (true)
                //         -> roundScore 6 + 1 = 7

                //roundscore.getPlayer1.roundscore = 0
                //roundscore.getPlayer2.roundscore = 7

                calculateScore(player1, player2);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void calculateScore(String player1, String player2) {

    }


}
