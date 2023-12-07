package year2023.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Day7 {

    public static void main(String[] args) {
        Path filePath = Path.of("src/year2023/day7/d7.txt");

        LineParser parser = new LineParser();
        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;

            while ((line = reader.readLine()) != null) {
                parser.appendHand(line);
            }

            CamelCardGame game = new CamelCardGame(parser.getHands());
            game.print();
            int sum = game.calculateSum();

            System.out.println("SUM: " + sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
