package year2023.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Day2Part1 {

    public static void main(String[] args) {
        Path filePath = Path.of("src/year2023/day2/d2.txt");

        int sum = 0;

        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;

            while ((line = reader.readLine()) != null) {
                Game game = new Game(line);
                boolean impossibleGame = game.containsCubesHigherThanMax();

                if(!impossibleGame) {
                    sum += game.gameId;
                }
            }

            System.out.println("Sum of IDs of possible games : " + sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
