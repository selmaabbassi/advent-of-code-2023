package year2015.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Day2 {
    public static void main(String[] args) {
        Path filePath = Path.of("src/year2015/day2/d2.txt");

        LineParser parser = new LineParser();
        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;

            while ((line = reader.readLine()) != null) {
                parser.addPresent(line);
            }

            parser.print();
            //part 1
            int requiredWrappingPaper = parser.getRequiredWrappingPaper();

            //part 2
            int requiredRibbon = parser.getRequiredRibbon();

            System.out.println("The elves need to buy " + requiredWrappingPaper + " square feet of wrapping paper!");
            System.out.println("The elves need to buy " + requiredRibbon + " feet of ribbon!");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
