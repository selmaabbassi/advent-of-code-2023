package year2022.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class DayFour {

    public static void main(String[] args) {
        Path filePath = Path.of("src/year2022/day4/d4.txt");

        int counter = 0;

        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                Pair pair = new Pair(line);
                if(pair.fullyOverlaps()) {
                    counter++;
                }
            }

            System.out.println("Nr of overlapping pairs: " + counter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
