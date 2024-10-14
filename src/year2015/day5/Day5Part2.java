package year2015.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Day5Part2 {
    public static void main(String[] args) {

        Path filePath = Path.of("src/year2015/day5/test.txt");

        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            NiceProcessor2 niceProcessor = new NiceProcessor2(lines);
            int i = niceProcessor.numberOfNiceStrings();

            System.out.println("Santa has " + i + " nice strings");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
