package year2022.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class DayFive {

    public static void main(String[] args) {
        CrateSorter sorter = new CrateSorter();

        Path filePath = Path.of("src/year2022/day5/d5.txt");

        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;

            while ((line = reader.readLine()) != null) {
                sorter.sortCrates(line);
            }

            System.out.println(sorter.getTopOfStacks().toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
