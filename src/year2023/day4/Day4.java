package year2023.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Day4 {

    public static void main(String[] args) {
        Path filePath = Path.of("src/year2023/day4/d4.txt");

        CardScratcher scratcher = new CardScratcher();
        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;

            while ((line = reader.readLine()) != null) {
                scratcher.appendCard(line);
            }

            scratcher.print();
            int points = scratcher.calculatePoints();
            int totalCopies = scratcher.calculateTotalCopies();

            System.out.println("Total Copies: " + totalCopies);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
